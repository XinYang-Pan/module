package io.github.xinyangpan.sample.persistent.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.github.xinyangpan.module.notification.bo.Notification;

@Entity
public class NotificationPo extends Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
}
