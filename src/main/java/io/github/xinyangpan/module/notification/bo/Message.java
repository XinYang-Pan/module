package io.github.xinyangpan.module.notification.bo;

public class Message {
	private long messageId;
	private String topic;
	private String content;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() { 
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
