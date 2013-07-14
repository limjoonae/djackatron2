package com.test.djackatron2.service;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.repository.AccountRepository;

public class TransferService {

	AccountRepository accountRepository;

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	double minTransfAmt = 0.00d; // initial value

	public void setMinTransfAmt(double minTransfAmt) {
		this.minTransfAmt = minTransfAmt;
	}

	public boolean transfer(String srcAccountId, String desAccountId,
			double transferAmount, double feeRate) throws Exception {

		if (transferAmount <= 0 || transferAmount < minTransfAmt) {
			throw new IllegalArgumentException();
		}

		Account srcAcc = accountRepository.getAccount(srcAccountId);
		Account desAcc = accountRepository.getAccount(desAccountId);

		double srcAccBalance = srcAcc.getAccountBalance() - transferAmount
				- feeRate;
		accountRepository.getAccount(srcAccountId).setAccountBalance(
				srcAccBalance);

		double desAccBalance = desAcc.getAccountBalance() + transferAmount;
		accountRepository.getAccount(desAccountId).setAccountBalance(
				desAccBalance);
		return true;

	}

}
