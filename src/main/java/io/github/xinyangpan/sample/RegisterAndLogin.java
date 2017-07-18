package io.github.xinyangpan.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.github.xinyangpan.module.customer.CustomerBalanceService;
import io.github.xinyangpan.module.customer.CustomerLoginService;
import io.github.xinyangpan.module.customer.CustomerRegisterService;
import io.github.xinyangpan.module.customer.bo.CurrencyCode;
import io.github.xinyangpan.module.customer.bo.Login;
import io.github.xinyangpan.module.notification.NotificationService;
import io.github.xinyangpan.sample.persistent.po.CustomerBalancePo;
import io.github.xinyangpan.sample.persistent.po.CustomerPo;
import io.github.xinyangpan.sample.persistent.po.MessagePo;
import io.github.xinyangpan.sample.persistent.po.NotificationPo;

@Controller
public class RegisterAndLogin {

	@Autowired
	private CustomerLoginService<CustomerPo> customerLoginService;
	@Autowired
	private CustomerRegisterService<CustomerPo> customerRegisterService;
	@Autowired
	private CustomerBalanceService<CustomerBalancePo> customerBalanceService;
	@Autowired
	private NotificationService<MessagePo, NotificationPo> notificationService;

	public void test() {
		// Register
		CustomerPo customerInfo = new CustomerPo();
		customerInfo.setEmail("abc@gmail.com");
		customerInfo.setMobile("13886");
		customerInfo.setUsername("pxy");
		customerInfo.setPassword("1234");
		customerRegisterService.register(customerInfo);
		// Login
		Login login = new Login("pxy", "1234");
		CustomerPo customerPo = customerLoginService.login(login);
		System.out.println(customerPo);
		long customerId = customerPo.getId();
		// Create Balance Account
		customerBalanceService.addBalanceAccount(customerId, CurrencyCode.USD);
		customerBalanceService.addBalanceAccount(customerId, CurrencyCode.BTC);
		List<CustomerBalancePo> balanceInfos = customerBalanceService.getAllBalanceInfos(customerId);
		System.out.println(balanceInfos);
		// Notification Messages
		MessagePo message = new MessagePo();
		message.setTopic("Hello");
		message.setContent("Hello World!");
		notificationService.post(customerId, message);
		List<NotificationPo> unread = notificationService.listAllUnread(customerId);
		System.out.println(unread);
	}

}
