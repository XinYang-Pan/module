package io.github.xinyangpan.sample.customer;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.xinyangpan.module.customer.CustomerBalanceService;
import io.github.xinyangpan.module.customer.bo.CurrencyCode;
import io.github.xinyangpan.module.customer.bo.CustomerBalance;
import io.github.xinyangpan.sample.persistent.dao.CustomerBalanceDao;
import io.github.xinyangpan.sample.persistent.po.CustomerBalancePo;

@Service
public class CustomerBalanceServiceImpl implements CustomerBalanceService {
	@Autowired
	private CustomerBalanceDao customerBalanceDao;

	@Override
	public void addBalanceAccount(long customerId, CurrencyCode currencyCode) {
		CustomerBalancePo customerBalancePo = new CustomerBalancePo();
		customerBalancePo.setCustomerId(customerId);
		customerBalancePo.setCurrencyCode(currencyCode);
		customerBalancePo.setBalance(BigDecimal.ZERO);
		customerBalancePo.setFrozenBalance(BigDecimal.ZERO);
		customerBalanceDao.save(customerBalancePo);
	}

	@Override
	public CustomerBalance getBalanceInfo(long customerId, CurrencyCode currencyCode) {
		return customerBalanceDao.findByCustomerIdAndCurrencyCode(customerId, currencyCode);
	}

}
