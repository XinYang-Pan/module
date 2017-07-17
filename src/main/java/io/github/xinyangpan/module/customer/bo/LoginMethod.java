package io.github.xinyangpan.module.customer.bo;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.Assert;

public enum LoginMethod {
	USERNAME {
		@Override
		public boolean predicate(String password) {
			Assert.notNull(password, "password must not be null");
			return true;
		}
	},
	EMAIL {
		@Override
		public boolean predicate(String password) {
			Assert.notNull(password, "password must not be null");
			return password.contains("@");
		}
	},
	MOBILE {
		@Override
		public boolean predicate(String password) {
			Assert.notNull(password, "password must not be null");
			return NumberUtils.isDigits(password);
		}
	};

	public abstract boolean predicate(String password);

}
