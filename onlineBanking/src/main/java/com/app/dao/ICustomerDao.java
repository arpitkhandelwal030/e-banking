package com.app.dao;

import com.app.pojos.Customer;

public interface ICustomerDao {

	//register new customer
     String registerCustomer(Customer customer);
   //add a method for customer login
 	Customer validateCustomer(String email,String password);
 	
 // get ONLY customer username 
 	Customer getCustomerDetails(String username);

}
