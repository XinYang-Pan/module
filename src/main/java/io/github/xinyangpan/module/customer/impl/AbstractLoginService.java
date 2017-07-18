package io.github.xinyangpan.module.customer.impl;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import io.github.xinyangpan.module.customer.CustomerLoginService;
import io.github.xinyangpan.module.customer.bo.LoginMethod;
import io.github.xinyangpan.module.customer.exception.WrongUsernameOrPasswordException;
import io.github.xinyangpan.module.customer.bo.Login;

public abstract class AbstractLoginService<T> implements CustomerLoginService<T> {
	private static final Logger log = LoggerFactory.getLogger(AbstractLoginService.class);

	@Override
	public T login(Login loginVo) {
		// 
		this.validate(loginVo);
		// 
		String password = loginVo.getPassword();
		if (LoginMethod.EMAIL.predicate(password)) {
			return this.loginByEmail(loginVo);
		} else if (LoginMethod.MOBILE.predicate(password)) {
			return this.loginByMobile(loginVo);
		} else if (LoginMethod.USERNAME.predicate(password)) {
			return this.loginByUsername(loginVo);
		} else {
			throw new RuntimeException("No login method found.");
		}
	}

	@Override
	public T loginByEmail(Login loginVo) {
		return this.doLogin(loginVo, this::doLoginByEmail);
	}

	@Override
	public T loginByMobile(Login loginVo) {
		return this.doLogin(loginVo, this::doLoginByMobile);
	}

	@Override
	public T loginByUsername(Login loginVo) {
		return this.doLogin(loginVo, this::doLoginByUsername);
	}

	private T doLogin(Login loginVo, Function<Login, T> loginFunction) {
		// 
		this.validate(loginVo);
		// 
		T t = loginFunction.apply(loginVo);
		if (t != null) {
			log.info("login user - {}", t);
			return t;
		} else {
			throw new WrongUsernameOrPasswordException();
		}
	}

	protected abstract T doLoginByEmail(Login loginVo);

	protected abstract T doLoginByMobile(Login loginVo);

	protected abstract T doLoginByUsername(Login loginVo);

	private void validate(Login loginVo) {
		Assert.notNull(loginVo, "loginVo must not be null");
		Assert.notNull(loginVo.getLogin(), "Username must not be null");
		Assert.notNull(loginVo.getPassword(), "Password must not be null");
	}

}
