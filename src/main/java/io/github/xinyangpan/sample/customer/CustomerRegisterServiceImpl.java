package io.github.xinyangpan.sample.customer;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.xinyangpan.module.customer.CustomerRegisterService;
import io.github.xinyangpan.sample.persistent.dao.CustomerDao;
import io.github.xinyangpan.sample.persistent.po.CustomerPo;

public class CustomerRegisterServiceImpl implements CustomerRegisterService<CustomerPo> {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public CustomerPo register(CustomerPo userInfo) {
		return customerDao.save(userInfo);
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
		return false;
	}

	@Override
	public void sendVerificationEmail(String email) {

	}

	@Override
	public void setAntiPhishingCode(String antiPhishing) {

	}

}
