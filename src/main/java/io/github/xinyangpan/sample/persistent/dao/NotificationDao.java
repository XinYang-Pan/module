package io.github.xinyangpan.sample.persistent.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.xinyangpan.module.notification.bo.NotificationStatus;
import io.github.xinyangpan.sample.persistent.po.NotificationPo;

public interface NotificationDao extends PagingAndSortingRepository<NotificationPo, Long> {

	NotificationPo findByTargetIdAndMessageId(long targetId, long messageId);

	List<NotificationPo> findByTargetIdAndNotificationStatus(long targetId, NotificationStatus notificationStatus);

	List<NotificationPo> findByTargetIdAndNotificationStatusNot(long targetId, NotificationStatus notificationStatus);

}
