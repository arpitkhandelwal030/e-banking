package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private EntityManager manager;
	
	
	@Override
	public String registerCustomer(Customer customer) {
		manager.persist(customer);
		return "Customer registered successfully with ID ="+customer.getId();
	}


	@Override
	public Customer validateCustomer(String email, String password) {
		String jpql = "select c from Customer c where c.email = :em and c.password=:pass";
		return manager.createQuery(jpql, Customer.class).setParameter("em", email).setParameter("pass", password).getSingleResult();
		
	}


	@Override
	public Customer getCustomerDetails(String username) {
		String jpql = "select c from Customer c where c.username=:username";
		return manager.createQuery(jpql, Customer.class).setParameter("username", username).getSingleResult();
		
	}
	
	
	

}
