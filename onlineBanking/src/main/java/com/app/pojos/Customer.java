package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_tbl")
public class Customer extends BaseEntity {
    @Column(length = 30,name="user_name")
	private String username;
    @Column(length = 30,unique = true)
	private String email;
    @Column(length = 30)
	private String password;
    @OneToMany(mappedBy = "selectedCustomer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();
	
	public Customer() {
		
	}

	public Customer(String username, String email,String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	//add helper methods : to link n de-link
		public void addCustomer(Account account)
		{
			//parent --> child
			accounts.add(account);
			//child --> parent
			account.setSelectedCustomer(this);
		}
		public void removeCustomer(Account account)
		{
			//parent ----X  -----> child
			accounts.remove(account);
			//child --X--> parent
			account.setSelectedCustomer(null);		
		}
	

	@Override
	public String toString() {
		return "Customer [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	
	
}
