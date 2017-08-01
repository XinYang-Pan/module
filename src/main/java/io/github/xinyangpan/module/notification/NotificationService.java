package io.github.xinyangpan.module.notification;

import java.util.List;

import io.github.xinyangpan.module.notification.bo.Message;
import io.github.xinyangpan.module.notification.bo.Notification;

public interface NotificationService<TID, MID, M extends Message<MID>, N extends Notification<TID, MID>> {

	void post(TID targetId, M message);

	void markRead(TID targetId, MID messageId);

	default void markReadAll(TID targetId) {
		List<N> notifications = this.listAllUnread(targetId);
		for (N n : notifications) {
			this.markRead(targetId, n.getMessageId());
		}
	}

	void delete(TID targetId, MID messageId);

	default void deleteAll(TID targetId) {
		List<N> notifications = this.listAll(targetId);
		for (N n : notifications) {
			this.markRead(targetId, n.getMessageId());
		}
	}

	List<N> listAllUnread(TID targetId);

	List<N> listAll(TID targetId);

}
