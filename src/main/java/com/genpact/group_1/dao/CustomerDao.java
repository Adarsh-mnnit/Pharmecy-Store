package com.genpact.group_1.dao;

import java.util.List;

import com.genpact.group_1.model.Customer;

public interface CustomerDao {
	
	boolean addCusomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(String customerid);
	
	List<Customer> getAllCustomer();
	Customer getCostomerById(String CustomerName);
	Customer getCustomerByEmail(String CustomerEmail);
	

}