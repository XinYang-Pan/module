package io.github.xinyangpan.module.customer.impl;

import io.github.xinyangpan.module.customer.CustomerRegisterService;

public abstract class CustomerRegisterServiceAdaptor<T> implements CustomerRegisterService<T> {

	@Override
	public boolean validateUsername(String username) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateEmail(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean validateMobile(String mobile) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean verifyMobile(String mobileVerificationCode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getMobileVerificationCode(String mobileNumber) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean verifyEmail(String mobileVerificationCode) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendVerificationEmail(String email) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void saveAntiPhishingCode(String antiPhishing) {
		throw new UnsupportedOperationException();
	}

}
