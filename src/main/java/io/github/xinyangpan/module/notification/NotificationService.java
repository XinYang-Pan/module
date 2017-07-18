package io.github.xinyangpan.module.notification;

import java.util.List;

import io.github.xinyangpan.module.notification.bo.Message;
import io.github.xinyangpan.module.notification.bo.Notification;

public interface NotificationService<M extends Message, N extends Notification> {

	void post(long targetId, M messageBo);

	void markRead(long targetId, long messageId);

	default void markReadAll(long targetId) {
		List<N> notifications = this.listAllUnread(targetId);
		for (N n : notifications) {
			this.markRead(targetId, n.getMessageId());
		}
	}

	void delete(long targetId, long messageId);

	default void deleteAll(long targetId) {
		List<N> notifications = this.listAll(targetId);
		for (N n : notifications) {
			this.markRead(targetId, n.getMessageId());
		}
	}

	List<N> listAllUnread(long targetId);

	List<N> listAll(long targetId);

}
