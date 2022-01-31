package com.revature.model;

import javax.persistence.*;

@Entity
@Table(name= "Account")
public class Account {
	@Id
	@Column(name= "AccountID")
	private int AccountID;
	
	@Column(name ="SpendingAccount")
	private float SpendingAccount;
	
	@Column(name ="SavingsAccount")
	private float SavingsAccount;
	
	@Column(name= "DepositAccount")
	private float DepositAccount;
	
	@Column(name ="LoanAccount")
	private float LoanAccount;

	public Account() {
		super();
	}

	public Account(int accountID, float spendingAccount, float savingsAccount, float depositAccount,
			float loanAccount) {
		super();
		AccountID = accountID;
		SpendingAccount = spendingAccount;
		SavingsAccount = savingsAccount;
		DepositAccount = depositAccount;
		LoanAccount = loanAccount;
	}

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public float getSpendingAccount() {
		return SpendingAccount;
	}

	public void setSpendingAccount(float spendingAccount) {
		SpendingAccount = spendingAccount;
	}

	public float getSavingsAccount() {
		return SavingsAccount;
	}

	public void setSavingsAccount(float savingsAccount) {
		SavingsAccount = savingsAccount;
	}

	public float getDepositAccount() {
		return DepositAccount;
	}

	public void setDepositAccount(float depositAccount) {
		DepositAccount = depositAccount;
	}

	public float getLoanAccount() {
		return LoanAccount;
	}

	public void setLoanAccount(float loanAccount) {
		LoanAccount = loanAccount;
	}
	
	
}
