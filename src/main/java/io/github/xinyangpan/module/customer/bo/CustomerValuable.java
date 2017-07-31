package io.github.xinyangpan.module.customer.bo;

import java.math.BigDecimal;

public class CustomerValuable<I> {
	private I customerId;
	private CurrencyCode currencyCode;
	private BigDecimal amount;

	public I getCustomerId() {
		return customerId;
	}

	public void setCustomerId(I customerId) {
		this.customerId = customerId;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getBalance() {
		return amount;
	}

	public void setBalance(BigDecimal balance) {
		this.amount = balance;
	}

}
