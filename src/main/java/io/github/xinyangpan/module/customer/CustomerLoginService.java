package io.github.xinyangpan.module.customer;

import io.github.xinyangpan.module.customer.bo.LoginVo;

public interface CustomerLoginService<T> {

	public T login(LoginVo loginVo);

	public T loginByUsername(LoginVo loginVo);

	public T loginByEmail(LoginVo loginVo);

	public T loginByMobile(LoginVo loginVo);

}
