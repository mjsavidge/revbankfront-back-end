package com.revature.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.exception.ResourceNotFoundException;
import com.revature.model.Account;
import com.revature.repo.AccountRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AccountController {
	
	@Autowired
	private AccountRepo accountRepo;
	
	//get all accounts
	@GetMapping("/accounts")
	public List<Account> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	//create account rest api
	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		return accountRepo.save(account);
	}
	
	//get acccount id rest api
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Integer ID){
		Account account = accountRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
		return ResponseEntity.ok(account);
	}
	
	//updating account rest api
	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable Integer ID, @RequestBody Account accountDetails){
		Account account = accountRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
		
		account.setSpendingAccount(accountDetails.getSpendingAccount());
		account.setSavingsAccount(accountDetails.getSavingsAccount());
		account.setDepositAccount(accountDetails.getDepositAccount());
		account.setLoanAccount(accountDetails.getLoanAccount());
		
		Account updateAccount = accountRepo.save(account);
		return ResponseEntity.ok(updateAccount);

	}
	
	//delete account rest api
	@DeleteMapping("/account/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable Integer ID){
		Account account = accountRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
		
		accountRepo.delete(account);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
