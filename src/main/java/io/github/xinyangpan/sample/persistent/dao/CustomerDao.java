package io.github.xinyangpan.sample.persistent.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.xinyangpan.sample.persistent.po.CustomerPo;

public interface CustomerDao extends PagingAndSortingRepository<CustomerPo, Long> {

	CustomerPo findByEmail(String email);

	CustomerPo findByMobile(String mobile);

	CustomerPo findByUsername(String username);

}
