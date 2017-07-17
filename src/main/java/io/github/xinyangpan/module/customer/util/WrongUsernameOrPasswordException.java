package io.github.xinyangpan.module.customer.util;

public class WrongUsernameOrPasswordException extends RuntimeException {
	private static final long serialVersionUID = 5568554406677602970L;

	public WrongUsernameOrPasswordException() {
		super("Wrong username or password");
	}

}