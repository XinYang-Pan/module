package io.github.xinyangpan.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.github.xinyangpan.module.customer.CustomerLoginService;
import io.github.xinyangpan.module.customer.CustomerRegisterService;
import io.github.xinyangpan.module.customer.bo.Login;
import io.github.xinyangpan.sample.persistent.po.CustomerPo;

@Controller
public class RegisterAndLogin {

	@Autowired
	private CustomerLoginService<CustomerPo> customerLoginService;
	@Autowired
	private CustomerRegisterService<CustomerPo> customerRegisterService;

	public void test() {
		// 
		CustomerPo customerInfo = new CustomerPo();
		customerInfo.setEmail("abc@gmail.com");
		customerInfo.setMobile("13886");
		customerInfo.setUsername("pxy");
		customerInfo.setPassword("1234");
		customerRegisterService.register(customerInfo);
		// 
		Login login = new Login("pxy", "1234");
		CustomerPo customerPo = customerLoginService.login(login);
		System.out.println(customerPo);
	}

}
