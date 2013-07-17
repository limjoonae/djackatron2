package com.test.djackatron2.rest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.repository.AccountRepository;

public class AccountControllerTest {

	@Test
	public void testFindOne() {
		// Given
		String accountId = "accA";
		Account account = new Account(accountId, 100d);

		AccountController accountController = new AccountController();

		AccountRepository repository = mock(AccountRepository.class);
		when(repository.getAccount(accountId)).thenReturn(account);

		accountController.setAccountRepository(repository);

		// When
		Account result = accountController.getOne(accountId);

		// Then
		assertEquals(accountId, result.getAccountId());
		verify(repository).getAccount(accountId);
	}

	@Test
	public void testSave() {
		// Given
		String accountId = "accA";
		Account account = new Account(accountId, 100d);

		AccountController accountController = new AccountController();

		AccountRepository repository = mock(AccountRepository.class);
		when(repository.save(account)).thenReturn(account);

		accountController.setAccountRepository(repository);

		// When
		Account result = accountController.save(account);

		// Then
		assertEquals(accountId, result.getAccountId());
		verify(repository).save(account);
	}

	@Test
	public void testUpdate() {
		// Given
		String accountId = "accA";
		Account account = new Account(accountId, 100d);

		AccountController accountController = new AccountController();

		AccountRepository repository = mock(AccountRepository.class);
		when(repository.update(account)).thenReturn(account);

		accountController.setAccountRepository(repository);

		// When
		Account result = accountController.update(account);

		// Then
		assertEquals(accountId, result.getAccountId());
		verify(repository).update(account);
	}

	@Test
	public void testDelete() {
		// Given
		String accountId = "accA";
		Account account = new Account(accountId, 100d);

		AccountController accountController = new AccountController();

		AccountRepository repository = mock(AccountRepository.class);
		when(repository.delete(accountId)).thenReturn(accountId);

		accountController.setAccountRepository(repository);

		// When
		String result = accountController.delete(accountId);

		// Then
		assertEquals(accountId, result);
		verify(repository).delete(accountId);
	}

}
