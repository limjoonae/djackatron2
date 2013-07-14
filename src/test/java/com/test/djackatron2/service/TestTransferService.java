package com.test.djackatron2.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.repository.AccountRepository;

public class TestTransferService {

	// Given
	double transferAmount = 30.00d;
	double feeRate = 5.00d;

	TransferService transferService = new TransferService();

	Account srcAccount = new Account();
	Account desAccount = new Account();

	// Create Account Repository and Mock it up
	// AccountRepository accountRepository = accRepo.getAcc("1-1234-2345-34-5");
	AccountRepository accountRepository = mock(AccountRepository.class);

	@Test
	public void testTransferThirtyBaht() throws Exception {

		srcAccount.setAccountId("1-1234-2345-34-5");
		srcAccount.setAccountBalance(100.00d);

		desAccount.setAccountId("7-7777-7777-77-7");
		desAccount.setAccountBalance(0.00d);

		when(accountRepository.getAccount("1-1234-2345-34-5")).thenReturn(
				srcAccount);
		when(accountRepository.getAccount("7-7777-7777-77-7")).thenReturn(
				desAccount);

		transferService.setAccountRepository(accountRepository);
		assertTrue(transferService.transfer("1-1234-2345-34-5",
				"7-7777-7777-77-7", 30.00d, feeRate));

		assertEquals(65.00d, accountRepository.getAccount("1-1234-2345-34-5")
				.getAccountBalance(), 2);
		assertEquals(30.00d, accountRepository.getAccount("7-7777-7777-77-7")
				.getAccountBalance(), 2);

	}

	@Test
	public void testTransferTwentyBaht() throws Exception {

		srcAccount.setAccountId("1-1234-2345-34-5");
		srcAccount.setAccountBalance(100.00d);

		desAccount.setAccountId("7-7777-7777-77-7");
		desAccount.setAccountBalance(0.00d);

		when(accountRepository.getAccount("srcAcc")).thenReturn(srcAccount);
		when(accountRepository.getAccount("desAcc")).thenReturn(desAccount);

		transferService.setAccountRepository(accountRepository);
		assertTrue(transferService
				.transfer("srcAcc", "desAcc", 20.00d, feeRate));

		assertEquals(75.00d, accountRepository.getAccount("srcAcc")
				.getAccountBalance(), 2);
		assertEquals(20.00d, accountRepository.getAccount("desAcc")
				.getAccountBalance(), 2);

	}

	@Test
	public void testTransferWhenTransferAmountLessThanMinimumTransferAmount()
			throws Exception {

		double minTransfAmt = 100.00d;
		transferService.setMinTransfAmt(minTransfAmt);

		srcAccount.setAccountId("1-1234-2345-34-5");
		srcAccount.setAccountBalance(100.00d);

		desAccount.setAccountId("7-7777-7777-77-7");
		desAccount.setAccountBalance(0.00d);

		when(accountRepository.getAccount("srcAcc")).thenReturn(srcAccount);
		when(accountRepository.getAccount("desAcc")).thenReturn(desAccount);

		transferService.setAccountRepository(accountRepository);
		assertTrue(transferService
				.transfer("srcAcc", "desAcc", 20.00d, feeRate));

		assertEquals(75.00d, accountRepository.getAccount("srcAcc")
				.getAccountBalance(), 2);
		assertEquals(20.00d, accountRepository.getAccount("desAcc")
				.getAccountBalance(), 2);

	}

	@Test
	public void testTransferWhenTransferAmountMoreThanOrEqualMinimumTransferAmount()
			throws Exception {

		double minTransfAmt = 20.00d;
		transferService.setMinTransfAmt(minTransfAmt);

		srcAccount.setAccountId("1-1234-2345-34-5");
		srcAccount.setAccountBalance(100.00d);

		desAccount.setAccountId("7-7777-7777-77-7");
		desAccount.setAccountBalance(0.00d);

		when(accountRepository.getAccount("srcAcc")).thenReturn(srcAccount);
		when(accountRepository.getAccount("desAcc")).thenReturn(desAccount);

		transferService.setAccountRepository(accountRepository);
		assertTrue(transferService
				.transfer("srcAcc", "desAcc", 20.00d, feeRate));

		assertEquals(75.00d, accountRepository.getAccount("srcAcc")
				.getAccountBalance(), 2);
		assertEquals(20.00d, accountRepository.getAccount("desAcc")
				.getAccountBalance(), 2);

	}


}
