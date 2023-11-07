package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.resource.RequestAmount;
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
    
    // 預け入れ
    public ResponseAmount deposit(Integer accountId, RequestAmount requestAmount) {
    	Account account = this.findById(accountId);
    	Integer totalAmount = (account.getAmount() + requestAmount.getAmount());
    	account.setAmount(totalAmount);
    	accountRepository.save(account);
    	
    	ResponseAmount responseAmount = new ResponseAmount();
    	responseAmount.setAmount(account.getAmount());
    	return responseAmount;
    }
    
    // 引き出し
    public ResponseAmount withdraw(Integer accountId, RequestAmount requestAmount) {
    	Account account = this.findById(accountId);
    	if (requestAmount.getAmount() <= account.getAmount()) {
    		Integer totalAmount = (account.getAmount() - requestAmount.getAmount());
    		account.setAmount(totalAmount);
    		accountRepository.save(account);
    	} else {
    		System.out.println("残高不足です");
    	}
    	ResponseAmount responseAmount = new ResponseAmount();
    	responseAmount.setAmount(account.getAmount());
    	return responseAmount;
    }
}