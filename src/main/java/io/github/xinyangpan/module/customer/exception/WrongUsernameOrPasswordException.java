package io.github.xinyangpan.module.customer.exception;

import io.github.xinyangpan.module.common.exception.LogicException;

public class WrongUsernameOrPasswordException extends LogicException {
	private static final long serialVersionUID = 5568554406677602970L;

	public WrongUsernameOrPasswordException() {
		super("Wrong username or password");
	}

}