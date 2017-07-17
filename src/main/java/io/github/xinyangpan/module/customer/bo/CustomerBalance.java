package io.github.xinyangpan.module.customer.bo;

import java.math.BigDecimal;

public class CustomerBalance {
	private long customerId;
	private CurrencyCode currencyCode;
	private BigDecimal balance;
	private BigDecimal freezingBalance;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getFreezingBalance() {
		return freezingBalance;
	}

	public void setFreezingBalance(BigDecimal freezingBalance) {
		this.freezingBalance = freezingBalance;
	}

}
