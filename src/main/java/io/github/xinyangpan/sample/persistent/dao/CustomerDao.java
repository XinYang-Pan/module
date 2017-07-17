package io.github.xinyangpan.sample.persistent.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.xinyangpan.sample.persistent.po.CustomerPo;

public interface CustomerDao extends PagingAndSortingRepository<CustomerPo, Long> {

	CustomerPo findByEmailAndPassword(String email, String password);

	CustomerPo findByMobileAndPassword(String mobile, String password);

	CustomerPo findByUsernameAndPassword(String username, String password);

}
