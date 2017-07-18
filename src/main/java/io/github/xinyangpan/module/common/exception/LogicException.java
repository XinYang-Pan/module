package io.github.xinyangpan.module.common.exception;

public class LogicException extends RuntimeException {
	private static final long serialVersionUID = 6456721552380002859L;

	public LogicException() {
		super();
	}

	public LogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicException(String message) {
		super(message);
	}

	public LogicException(Throwable cause) {
		super(cause);
	}

}