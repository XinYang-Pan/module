package io.github.xinyangpan.module.customer.bo;

import java.math.BigDecimal;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CustomerBalance {
	private long customerId;
	private CurrencyCode currencyCode;
	private BigDecimal balance;
	private BigDecimal frozenBalance;

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

	public BigDecimal getFrozenBalance() {
		return frozenBalance;
	}

	public void setFrozenBalance(BigDecimal frozenBalance) {
		this.frozenBalance = frozenBalance;
	}

}
