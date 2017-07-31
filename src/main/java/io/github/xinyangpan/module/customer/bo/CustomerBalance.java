package io.github.xinyangpan.module.customer.bo;

import java.math.BigDecimal;

import javax.persistence.MappedSuperclass;

import io.github.xinyangpan.module.customer.function.ReadWriteCustomerId;

@MappedSuperclass
public interface CustomerBalance<I> extends ReadWriteCustomerId<I> {

	public CurrencyCode getCurrencyCode();

	public void setCurrencyCode(CurrencyCode currencyCode);

	public BigDecimal getBalance();

	public void setBalance(BigDecimal balance);

	public BigDecimal getFrozenBalance();

	public void setFrozenBalance(BigDecimal frozenBalance);

}
