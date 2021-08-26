package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="account_tbl")
public class Account extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(name="account_type",length = 20)	
    private Type accountType;
	@Column(name="opening_balance")
	private double openingBalance;
	//many to one bi dir association
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id") //to specify name of the FK column
	private Customer selectedCustomer;
	
	public Account() {
		
	}


	public Account(Type accountType, double openingBalance) {
		super();
		this.accountType = accountType;
		this.openingBalance = openingBalance;
	}


	public Type getAccountType() {
		return accountType;
	}


	public void setAccountType(Type accountType) {
		this.accountType = accountType;
	}


	public double getOpeningBalance() {
		return openingBalance;
	}


	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}


	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}


	@Override
	public String toString() {
		return "Account id="+getId()+" [accountType=" + accountType + ", openingBalance=" + openingBalance + "]";
	}
	

   
}
  
