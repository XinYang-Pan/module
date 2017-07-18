package io.github.xinyangpan.module.customer.bo;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.Assert;

public enum LoginMethod {
	USERNAME {
		@Override
		public boolean predicate(String login) {
			Assert.notNull(login, "login must not be null");
			return true;
		}
	},
	EMAIL {
		@Override
		public boolean predicate(String login) {
			Assert.notNull(login, "login must not be null");
			return login.contains("@");
		}
	},
	MOBILE {
		@Override
		public boolean predicate(String login) {
			Assert.notNull(login, "login must not be null");
			return NumberUtils.isDigits(login);
		}
	};

	public abstract boolean predicate(String login);

}
