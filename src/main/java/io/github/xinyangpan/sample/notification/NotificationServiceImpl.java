package io.github.xinyangpan.sample.notification;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.xinyangpan.module.notification.NotificationService;
import io.github.xinyangpan.module.notification.bo.NotificationStatus;
import io.github.xinyangpan.sample.persistent.dao.MessageDao;
import io.github.xinyangpan.sample.persistent.dao.NotificationDao;
import io.github.xinyangpan.sample.persistent.po.MessagePo;
import io.github.xinyangpan.sample.persistent.po.NotificationPo;

public class NotificationServiceImpl implements NotificationService<MessagePo, NotificationPo> {

	@Autowired
	private MessageDao messageDao;
	@Autowired
	private NotificationDao notificationDao;

	@Override
	public void post(long targetId, MessagePo messagePo) {
		messagePo = messageDao.save(messagePo);
		NotificationPo notificationPo = new NotificationPo();
		notificationPo.setMessageId(messagePo.getMessageId());
		notificationPo.setTargetId(targetId);
		notificationPo.setNotificationStatus(NotificationStatus.NEW);
		notificationPo.setCreateDate(new Date());
		notificationPo.setReadDate(null);
		notificationDao.save(notificationPo);
	}

	@Override
	public void markRead(long targetId, long messageId) {
		NotificationPo notificationPo = notificationDao.findByTargetIdAndMessageId(targetId, messageId);
		if (notificationPo.getNotificationStatus() == NotificationStatus.NEW) {
			notificationPo.setNotificationStatus(NotificationStatus.READ);
			notificationDao.save(notificationPo);
		}
	}

	@Override
	public void delete(long targetId, long messageId) {
		NotificationPo notification = notificationDao.findByTargetIdAndMessageId(targetId, messageId);
		notification.setNotificationStatus(NotificationStatus.DELETE);
		notificationDao.save(notification);
	}

	@Override
	public List<NotificationPo> listAllUnread(long targetId) {
		return notificationDao.findByTargetIdAndNotificationStatus(targetId, NotificationStatus.NEW);
	}

	@Override
	public List<NotificationPo> listAll(long targetId) {
		return notificationDao.findByTargetIdAndNotificationStatusNot(targetId, NotificationStatus.DELETE);
	}

}
