package com.test.djackatron2.model;

public class Account {
	
	public String accountId;
	public double accountBalance;
	
	public Account() {}

	public Account(String accountId, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
