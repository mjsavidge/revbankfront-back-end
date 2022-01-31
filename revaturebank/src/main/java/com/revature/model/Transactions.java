package com.revature.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name ="Transactions")
public class Transactions {
	@Id
	@Column(name ="TransactionID")
	private int TransactionID;
	
	@Column(name ="DateTime")
	private Date DateTime;
	
	@Column(name ="TransferAmount")
	private float TransferAmount;
	
	@Column(name ="Status")
	private boolean Status;
	
	@Column(name ="Account")
	private int Account;
	
	@Column(name ="Customer")
	private int Customer;

	public Transactions() {
		super();
	}

	public Transactions(int transactionID, Date dateTime, float transferAmount, boolean status, int account,
			int customer) {
		super();
		TransactionID = transactionID;
		DateTime = dateTime;
		TransferAmount = transferAmount;
		Status = status;
		Account = account;
		Customer = customer;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}

	public float getTransferAmount() {
		return TransferAmount;
	}

	public void setTransferAmount(float transferAmount) {
		TransferAmount = transferAmount;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public int getAccount() {
		return Account;
	}

	public void setAccount(int account) {
		Account = account;
	}

	public int getCustomer() {
		return Customer;
	}

	public void setCustomer(int customer) {
		Customer = customer;
	}
	
	
}
