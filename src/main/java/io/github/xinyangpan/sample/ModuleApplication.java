package io.github.xinyangpan.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class ModuleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ModuleApplication.class, args);
		RegisterAndLogin bean = context.getBean(RegisterAndLogin.class);
		bean.test();
	}
}
