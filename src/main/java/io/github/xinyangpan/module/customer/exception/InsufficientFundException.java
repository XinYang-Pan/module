package io.github.xinyangpan.module.customer.exception;

import io.github.xinyangpan.module.common.exception.LogicException;

public class InsufficientFundException extends LogicException {
	private static final long serialVersionUID = 3807373031572109101L;

	public InsufficientFundException() {
		super("Insufficient Fund");
	}

}