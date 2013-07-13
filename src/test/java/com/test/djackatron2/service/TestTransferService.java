package com.test.djackatron2.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.test.djackatron2.model.Account;

public class TestTransferService {

	//Given
	double transferAmount = 30.00d;
	double feeRate = 5.00d;
	
	@Test
	public void testTransferComplete() {
		
	TransferService transferService = new TransferService();	
	
	Account srcAccount = new Account();
	srcAccount.setAccountId("1-1234-2345-34-5");
	srcAccount.setAccountBalance(100.00d);
	
	Account desAccount = new Account();
	desAccount.setAccountId("7-7777-7777-77-7");
	desAccount.setAccountBalance(0.00d);
	
//Create Account Repository and Mock it up
	//AccountRepository accountRepository = accRepo.getAcc("1-1234-2345-34-5");
	AccountRepository accountRepository = mock(AccountRepository.class);
	when(accountRepository.getAccount("1-1234-2345-34-5")).thenReturn(srcAccount);
	when(accountRepository.getAccount("7-7777-7777-77-7")).thenReturn(desAccount);
		
	assertTrue(transferService.transfer(accountRepository, "1-1234-2345-34-5" , "7-7777-7777-77-7", 30.00d, feeRate));
	
	assertEquals(65.00d, accountRepository.getAccount("1-1234-2345-34-5").getAccountBalance(), 2);
	assertEquals(30.00d, accountRepository.getAccount("7-7777-7777-77-7").getAccountBalance(), 2);
	
	}

	
	@Test
	public void testTransferFail() {
		
	TransferService transferService = new TransferService();
	
	Account srcAccount = new Account();
	srcAccount.setAccountId("1-1234-2345-34-5");
	srcAccount.setAccountBalance(100.00d);
	
	Account desAccount = new Account();
	desAccount.setAccountId("7-7777-7777-77-7");
	desAccount.setAccountBalance(0.00d);
	
//Create Account Repository and Mock it up
	//AccountRepository accountRepository = accRepo.getAcc("1-1234-2345-34-5");
	AccountRepository accountRepository = mock(AccountRepository.class);
	when(accountRepository.getAccount("1-1234-2345-34-5")).thenReturn(srcAccount);
	when(accountRepository.getAccount("7-7777-7777-77-7")).thenReturn(desAccount);
	
	assertTrue(transferService.transfer(accountRepository, "1-1234-2345-34-5" , "7-7777-7777-77-7", 20.00d, feeRate));
	
	assertEquals(75.00d, accountRepository.getAccount("1-1234-2345-34-5").getAccountBalance(), 2);
	assertEquals(20.00d, accountRepository.getAccount("7-7777-7777-77-7").getAccountBalance(), 2);
	
	}

}
