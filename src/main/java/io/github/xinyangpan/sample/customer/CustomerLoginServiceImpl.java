package io.github.xinyangpan.sample.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.xinyangpan.module.customer.bo.LoginVo;
import io.github.xinyangpan.module.customer.impl.AbstractLoginService;
import io.github.xinyangpan.sample.persistent.dao.CustomerDao;
import io.github.xinyangpan.sample.persistent.po.CustomerPo;

@Service
public class CustomerLoginServiceImpl extends AbstractLoginService<CustomerPo> {
	@Autowired
	private CustomerDao customerDao;

	@Override
	protected CustomerPo doLoginByEmail(LoginVo loginVo) {
		return customerDao.findByEmailAndPassword(loginVo.getLogin(), loginVo.getPassword());
	}

	@Override
	protected CustomerPo doLoginByMobile(LoginVo loginVo) {
		return customerDao.findByMobileAndPassword(loginVo.getLogin(), loginVo.getPassword());
	}

	@Override
	protected CustomerPo doLoginByUsername(LoginVo loginVo) {
		return customerDao.findByUsernameAndPassword(loginVo.getLogin(), loginVo.getPassword());
	}

}
