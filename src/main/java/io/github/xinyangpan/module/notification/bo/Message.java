package io.github.xinyangpan.module.notification.bo;

import io.github.xinyangpan.module.common.function.ReadWriteId;

public interface Message<I> extends ReadWriteId<I> {

	public String getTopic();

	public void setTopic(String topic);

	public String getContent();

	public void setContent(String content);

}
