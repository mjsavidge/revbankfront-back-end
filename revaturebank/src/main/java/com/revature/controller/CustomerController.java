package com.revature.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.revature.exception.ResourceNotFoundException;
import com.revature.model.Customer;
import com.revature.repo.CustomerRepo;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;;

	// get all customer
	@GetMapping("/customer")
	public List<Customer> getAllAccounts() {
		return customerRepo.findAll();
	}

	// create customer rest api
	@PostMapping("/customer/{id}")
	public Customer createAccount(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}

	// get customer by id rest api
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getAccountID(@PathVariable Integer ID) {
		Customer customer = customerRepo.findById(ID)
				.orElseThrow(() -> new ResourceNotFoundException("Customer ID not found"));
		return ResponseEntity.ok(customer);
	}
	
	// updating customer rest api
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateAccount(@PathVariable Integer ID, @RequestBody Customer customerDetails){
		Customer customer =  customerRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		
		customer.setName(customerDetails.getName());
		customer.setEmail(customerDetails.getEmail());
		customer.setPassword(customerDetails.getPassword());
		customer.setMobile(customerDetails.getMobile());
		customer.setAddress(customerDetails.getAddress());
		
		Customer updatedCustomer = customerRepo.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	//delete customer rest api
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Integer ID){
		Customer customer = customerRepo.findById(ID).orElseThrow(() -> new ResourceNotFoundException("Cusromer not found"));
		customerRepo.delete(customer);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
