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
	public T login(Login loginObj) {
		// 
		this.validate(loginObj);
		// 
		String login = loginObj.getLogin();
		if (LoginMethod.EMAIL.predicate(login)) {
			return this.loginByEmail(loginObj);
		} else if (LoginMethod.MOBILE.predicate(login)) {
			return this.loginByMobile(loginObj);
		} else if (LoginMethod.USERNAME.predicate(login)) {
			return this.loginByUsername(loginObj);
		} else {
			throw new RuntimeException("No login method found.");
		}
	}

	@Override
	public T loginByEmail(Login login) {
		return this.doLogin(login, this::doLoginByEmail);
	}

	@Override
	public T loginByMobile(Login login) {
		return this.doLogin(login, this::doLoginByMobile);
	}

	@Override
	public T loginByUsername(Login login) {
		return this.doLogin(login, this::doLoginByUsername);
	}

	private T doLogin(Login login, Function<Login, T> loginFunction) {
		// 
		this.validate(login);
		// 
		T t = loginFunction.apply(login);
		if (t != null) {
			log.info("login user - {}", t);
			return t;
		} else {
			throw new WrongUsernameOrPasswordException();
		}
	}

	protected abstract T doLoginByEmail(Login login);

	protected abstract T doLoginByMobile(Login login);

	protected abstract T doLoginByUsername(Login login);

	private void validate(Login login) {
		Assert.notNull(login, "loginVo must not be null");
		Assert.notNull(login.getLogin(), "Username must not be null");
		Assert.notNull(login.getPassword(), "Password must not be null");
	}

}
