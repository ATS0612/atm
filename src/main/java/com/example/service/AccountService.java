package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.resource.ResponseAmount;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
//    public List<Account> findAll() {
//    	return this.accountRepository.findAll();
//    }
    
    public Account registration(ResponseAmount responseAmount) {
    	Account account = new Account();
    	account.setAmount(responseAmount.getAmount());
    	
    	return this.accountRepository.save(account);
    }
    
    // 残高照会
    public Account findById(Integer accountId) {
    	Optional<Account> optionalAccount = this.accountRepository.findById(accountId);
    	Account account  = optionalAccount.get();
    	
      return account;
    	
// ② 	Optional<Account> optionalAccount = this.accountRepository.findById(accountId);
//    	Account account = optionalAccount.get();
//    	ResponseAmount responseAmount = new ResponseAmount();
//    	responseAmount.setAmount(account.getAmount());
//    	return responseAmount;
    }
}