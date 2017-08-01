package io.github.xinyangpan.module.notification.bo;

import java.util.Date;

public interface Notification<TID, MID> {

	public TID getTargetId();

	public void setTargetId(TID targetId);

	public MID getMessageId();

	public void setMessageId(MID messageId);

	public NotificationStatus getNotificationStatus();

	public void setNotificationStatus(NotificationStatus notificationStatus);

	public Date getCreateDate();

	public void setCreateDate(Date createDate);

	public Date getReadDate();

	public void setReadDate(Date readDate);

}
