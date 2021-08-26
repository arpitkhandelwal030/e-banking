package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Account;
import com.app.pojos.Customer;
@Repository
public class AccountDaoImpl implements IAccountDao {

	@Autowired
	private ICustomerDao customerDao;
	@Override
	public String addAccount(Account account,String username) {
		String mesg="Account creation failed!!!!";
		Customer customer=customerDao.getCustomerDetails(username);
		System.out.println(customer);
		// manager.persist(account);
		if(customer != null)
		{
			//course : persistent
			
			customer.addCustomer(account);//establish bi-dir relationship here.
			mesg="Account "+account.getId()+" added in Customer "+username;
		}
		return mesg;
	
	}

}
