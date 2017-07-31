package io.github.xinyangpan.sample.persistent.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.xinyangpan.sample.persistent.po.MessagePo;

public interface MessageDao extends PagingAndSortingRepository<MessagePo, Long> {

}
