package io.github.xinyangpan.module.customer;

import io.github.xinyangpan.module.customer.bo.BalanceAction;
import io.github.xinyangpan.module.customer.bo.CurrencyCode;
import io.github.xinyangpan.module.customer.bo.CustomerBalance;
import io.github.xinyangpan.module.customer.bo.CustomerValuable;

public interface CustomerBalanceService {

	public void addBalanceAccount(long customerId, CurrencyCode currencyCode);

	public void changeBalance(CustomerValuable customerValuable, BalanceAction balanceAction, String msg);

	public void freeze(CustomerValuable customerValuable);

	default void transfer(CustomerValuable source, CustomerValuable dest) {
		this.changeBalance(source, BalanceAction.DEBIT, "Transfer out");
		this.changeBalance(dest, BalanceAction.CREDIT, "Transfer in");
	}

	default void exchange(CustomerValuable source, CustomerValuable dest, CustomerValuable transactionFee) {
		this.transfer(source, dest);
		this.changeBalance(transactionFee, BalanceAction.DEBIT, "Transaction fee");
	}

	public CustomerBalance getBalanceInfo(long customerId, CurrencyCode currencyCode);

}
