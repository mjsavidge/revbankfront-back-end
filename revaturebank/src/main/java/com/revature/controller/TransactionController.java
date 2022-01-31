package com.revature.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.repo.TransactionsRepo;
import com.revature.exception.ResourceNotFoundException;
import com.revature.model.Transactions;

@CrossOrigin(origins ="http://localhost:4200")
//@RestController
//@RequestMapping("/api/v1")
public class TransactionController {
	@Autowired
	private TransactionsRepo transactionsRepo;
	
	//get all transactions
	@GetMapping("/transactions")
	public List<Transactions> getAllTransactions(){
		return transactionsRepo.findAll();
	}
	
	//create transactions rest api
	@PostMapping
	public Transactions createTransactions(@RequestBody Transactions transactions) {
		return transactionsRepo.save(transactions);
	}
	
	//get trans id rest api
	@PutMapping("/transactions/{id}")
	public ResponseEntity<Transactions> getTransactionsID(@PathVariable Integer ID){
		Transactions transactions = transactionsRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
		return ResponseEntity.ok(transactions);
	}
	
	// update trans rest api
	@PutMapping("/transactions/{id}")
	public ResponseEntity<Transactions> updateTransactions(@PathVariable Integer ID, @RequestBody Transactions transactionsDetails){
		Transactions transactions = transactionsRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
		
		transactions.setAccount(transactionsDetails.getAccount());
		transactions.setCustomer(transactionsDetails.getCustomer());
		transactions.setDateTime(transactionsDetails.getDateTime());
		transactions.setTransactionID(transactionsDetails.getTransactionID());
		transactions.setTransferAmount(transactionsDetails.getTransferAmount());
		transactions.setStatus(transactionsDetails.isStatus());
		
		Transactions updatedTransactions = transactionsRepo.save(transactions);
		return ResponseEntity.ok(updatedTransactions);

	}
	
	//delete trans rest api
	@DeleteMapping
	public ResponseEntity<Map<String, Boolean>> deleteTransactions(@PathVariable Integer ID){
		Transactions transactions = transactionsRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
		
		transactionsRepo.delete(transactions);
		Map<String,Boolean>  response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
