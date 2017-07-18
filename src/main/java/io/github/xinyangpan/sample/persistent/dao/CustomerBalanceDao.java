package io.github.xinyangpan.sample.persistent.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.xinyangpan.module.customer.bo.CurrencyCode;
import io.github.xinyangpan.sample.persistent.po.CustomerBalancePo;

public interface CustomerBalanceDao extends PagingAndSortingRepository<CustomerBalancePo, Long> {

	CustomerBalancePo findByCustomerIdAndCurrencyCode(long customerId, CurrencyCode currencyCode);

}
