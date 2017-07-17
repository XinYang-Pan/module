package io.github.xinyangpan.module.notification;

import java.util.List;

import io.github.xinyangpan.module.notification.bo.MessageBo;
import io.github.xinyangpan.module.notification.bo.NotificationBo;

public interface NotificationService {

	void post(long targetId, MessageBo messageBo);

	void read(long targetId, long messageId);

	void readAll(long targetId);

	void delete(long targetId, long messageId);

	void deleteAll(long targetId);

	void update(NotificationBo notificationBo);

	List<NotificationBo> listAllUnread(long targetId);
	
	List<NotificationBo> listAll(long targetId);

}
