package io.github.xinyangpan.module.customer;

import io.github.xinyangpan.module.customer.bo.Login;

public interface CustomerLoginService<T> {

	public T login(Login loginVo);

	public T loginByUsername(Login loginVo);

	public T loginByEmail(Login loginVo);

	public T loginByMobile(Login loginVo);

}
