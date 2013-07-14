package com.test.djackatron2.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.repository.AccountRepository;

@Controller
@RequestMapping
public class AccountController {

	AccountRepository accountRepository;	
	
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Account getOne(String accountId){
		
		return accountRepository.getAccount(accountId);
	}
	
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	
	public Account update(Account account) {
		return accountRepository.update(account);
	}

	public String delete(String accountId) {
		return accountRepository.delete(accountId);
	}

}
