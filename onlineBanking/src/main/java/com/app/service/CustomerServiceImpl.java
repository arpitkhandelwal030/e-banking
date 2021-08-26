package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public String registerCustomer(Customer customer) {
		
		return customerDao.registerCustomer(customer);
	}

	@Override
	public Customer validateCustomer(String email, String password) {
		System.out.println("in service : "+email+" "+password);
		// invoke dao's method
		return customerDao.validateCustomer(email, password);
	}

	
	
	

}
