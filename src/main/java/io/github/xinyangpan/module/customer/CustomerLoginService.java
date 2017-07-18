package io.github.xinyangpan.module.customer;

import io.github.xinyangpan.module.customer.bo.Customer;
import io.github.xinyangpan.module.customer.bo.Login;

public interface CustomerLoginService<T extends Customer> {

	public T login(Login login);

	public T loginByUsername(Login login);

	public T loginByEmail(Login login);

	public T loginByMobile(Login login);

}
