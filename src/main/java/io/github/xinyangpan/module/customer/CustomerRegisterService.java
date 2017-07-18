package io.github.xinyangpan.module.customer;

public interface CustomerRegisterService<T> {

	public T register(T userInfo);

	public boolean verifyMobile(String mobileVerificationCode);

	public String getMobileVerificationCode(String mobileNumber);

	public boolean verifyEmail(String mobileVerificationCode);

	public void sendVerificationEmail(String email);
	
	public void saveAntiPhishingCode(String antiPhishing);

}
