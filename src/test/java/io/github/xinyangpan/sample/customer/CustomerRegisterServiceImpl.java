package io.github.xinyangpan.sample.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.xinyangpan.module.customer.CustomerRegisterService;
import io.github.xinyangpan.sample.persistent.dao.CustomerDao;
import io.github.xinyangpan.sample.persistent.po.CustomerPo;

@Service
public class CustomerRegisterServiceImpl implements CustomerRegisterService<CustomerPo> {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public CustomerPo register(CustomerPo customerInfo) {
		customerInfo.setPassword(passwordEncoder.encode(customerInfo.getPassword()));
		return customerDao.save(customerInfo);
	}

	@Override
	public boolean verifyMobile(String mobileVerificationCode) {
		return true;
	}

	@Override
	public String getMobileVerificationCode(String mobileNumber) {
		return "123456";
	}

	@Override
	public boolean verifyEmail(String mobileVerificationCode) {
		return true;
	}

	@Override
	public void sendVerificationEmail(String email) {

	}

	@Override
	public void saveAntiPhishingCode(String antiPhishing) {

	}

}
