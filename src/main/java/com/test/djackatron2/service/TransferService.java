package com.test.djackatron2.service;

import com.test.djackatron2.model.Account;

public class TransferService {

	public boolean transfer(AccountRepository accountRepository,
			String srcAccountId, String desAccountId, double transferAmount,
			double feeRate) {

		double srcAccBalance = accountRepository.getAccount(srcAccountId)
				.getAccountBalance() - transferAmount - feeRate;
		accountRepository.getAccount(srcAccountId).setAccountBalance(srcAccBalance);

		double desAccBalance = accountRepository.getAccount(desAccountId)
				.getAccountBalance() + transferAmount;
		accountRepository.getAccount(desAccountId).setAccountBalance(desAccBalance);

		return true;
	}

}
