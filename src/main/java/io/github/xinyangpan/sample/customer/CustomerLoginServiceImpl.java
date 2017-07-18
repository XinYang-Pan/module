package io.github.xinyangpan.sample.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.xinyangpan.module.customer.bo.Login;
import io.github.xinyangpan.module.customer.impl.AbstractLoginService;
import io.github.xinyangpan.sample.persistent.dao.CustomerDao;
import io.github.xinyangpan.sample.persistent.po.CustomerPo;

@Service
public class CustomerLoginServiceImpl extends AbstractLoginService<CustomerPo> {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected CustomerPo doLoginByEmail(Login login) {
		return customerDao.findByEmail(login.getLogin());
	}

	@Override
	protected CustomerPo doLoginByMobile(Login login) {
		return customerDao.findByMobile(login.getLogin());
	}

	@Override
	protected CustomerPo doLoginByUsername(Login login) {
		return customerDao.findByUsername(login.getLogin());
	}

	@Override
	protected PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	@Override
	public boolean changePassword(String username, String oldRawPassword, String newRawPassword) {
		CustomerPo customerPo = this.loginByUsername(new Login(username, oldRawPassword));
		if (customerPo != null) {
			customerPo.setPassword(passwordEncoder.encode(newRawPassword));
			customerDao.save(customerPo);
			return true;
		}
		return false;
	}

}
