package io.github.xinyangpan.module.customer;

import io.github.xinyangpan.module.customer.bo.Customer;
import io.github.xinyangpan.module.customer.bo.Login;

public interface CustomerLoginService<T extends Customer> {

	T login(Login login);

	T loginByUsername(Login login);

	T loginByEmail(Login login);

	T loginByMobile(Login login);
	
	boolean changePassword(String username, String oldRawPassword, String newRawPassword);
	
}
