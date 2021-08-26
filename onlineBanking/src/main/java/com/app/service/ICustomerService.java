package com.app.service;

import com.app.pojos.Customer;

public interface ICustomerService {

	//register new customer
    String registerCustomer(Customer customer);
    
    Customer validateCustomer(String email,String password);
}
