package io.github.xinyangpan.module.notification.exception;

public class NotificationIsAlreadyDeletedException extends RuntimeException {
	private static final long serialVersionUID = 3807373031572109101L;

	public NotificationIsAlreadyDeletedException() {
		super("Notification is already deleted.");
	}

}