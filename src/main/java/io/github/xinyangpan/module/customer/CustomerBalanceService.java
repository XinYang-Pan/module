package io.github.xinyangpan.module.customer;

import java.util.List;

import io.github.xinyangpan.module.customer.bo.BalanceAction;
import io.github.xinyangpan.module.customer.bo.CurrencyCode;
import io.github.xinyangpan.module.customer.bo.CustomerBalance;
import io.github.xinyangpan.module.customer.bo.CustomerValuable;

public interface CustomerBalanceService<B extends CustomerBalance> {

	public void addBalanceAccount(long customerId, CurrencyCode currencyCode);

	default void changeBalance(CustomerValuable customerValuable, BalanceAction balanceAction, String msg) {
		B customerBalance = this.getBalanceInfo(customerValuable.getCustomerId(), customerValuable.getCurrencyCode());
		switch (balanceAction) {
		case FREEZE:
			customerBalance.setFrozenBalance(customerBalance.getFrozenBalance().add(customerValuable.getBalance()));
			break;
		case CREDIT:
			customerBalance.setBalance(customerBalance.getBalance().add(customerValuable.getBalance()));
			break;
		case DEBIT:
			customerBalance.setBalance(customerBalance.getBalance().subtract(customerValuable.getBalance()));
			break;
		default:
			throw new RuntimeException("No action define for "+ balanceAction);
		}
	}

	default void freeze(CustomerValuable customerValuable) {
		this.changeBalance(customerValuable, BalanceAction.FREEZE, "freeze balance");
	}

	default void transfer(CustomerValuable source, CustomerValuable dest) {
		this.changeBalance(source, BalanceAction.DEBIT, "Transfer out");
		this.changeBalance(dest, BalanceAction.CREDIT, "Transfer in");
	}

	default void exchange(CustomerValuable source, CustomerValuable dest, CustomerValuable transactionFee) {
		this.transfer(source, dest);
		this.changeBalance(transactionFee, BalanceAction.DEBIT, "Transaction fee");
	}

	public B getBalanceInfo(long customerId, CurrencyCode currencyCode);

	public List<B> getAllBalanceInfos(long customerId);

}
