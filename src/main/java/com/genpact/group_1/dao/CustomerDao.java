package com.genpact.group_1.dao;

import java.util.List;

import com.genpact.group_1.model.Customer;

public interface CustomerDao {
	
	boolean addCusomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	Customer getCostomerByName(String CustomerName);
	Customer getCustomerById(String CustomerId);
	

}