package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Transactions;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Integer>{

}
