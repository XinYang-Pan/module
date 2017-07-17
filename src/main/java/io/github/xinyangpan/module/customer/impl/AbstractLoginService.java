package io.github.xinyangpan.module.customer.impl;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import io.github.xinyangpan.module.customer.CustomerLoginService;
import io.github.xinyangpan.module.customer.bo.LoginMethod;
import io.github.xinyangpan.module.customer.bo.LoginVo;
import io.github.xinyangpan.module.customer.util.WrongUsernameOrPasswordException;

public abstract class AbstractLoginService<T> implements CustomerLoginService<T> {
	private static final Logger log = LoggerFactory.getLogger(AbstractLoginService.class);

	@Override
	public T login(LoginVo loginVo) {
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
	public T loginByEmail(LoginVo loginVo) {
		return this.doLogin(loginVo, this::doLoginByEmail);
	}

	@Override
	public T loginByMobile(LoginVo loginVo) {
		return this.doLogin(loginVo, this::doLoginByMobile);
	}

	@Override
	public T loginByUsername(LoginVo loginVo) {
		return this.doLogin(loginVo, this::doLoginByUsername);
	}

	private T doLogin(LoginVo loginVo, Function<LoginVo, T> loginFunction) {
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

	protected abstract T doLoginByEmail(LoginVo loginVo);

	protected abstract T doLoginByMobile(LoginVo loginVo);

	protected abstract T doLoginByUsername(LoginVo loginVo);

	private void validate(LoginVo loginVo) {
		Assert.notNull(loginVo, "loginVo must not be null");
		Assert.notNull(loginVo.getUsername(), "Username must not be null");
		Assert.notNull(loginVo.getPassword(), "Password must not be null");
	}

}
