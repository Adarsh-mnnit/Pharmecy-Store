package com.genpact.group_1.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.genpact.group_1.model.Customer;
import com.genpact.group_1.model.OrderTable;

public class CustomerMapper {
	
	public static Customer mapCustomer(ResultSet rs) throws SQLException
	{
		Customer customer = new Customer();
		customer.setCustomerid(rs.getString("customerid"));
		customer.setPassword(rs.getString("password"));
		customer.setEmailid(rs.getString("emailid"));
		customer.setAge(rs.getInt("age"));
		customer.setContact(rs.getString("contact"));
		customer.setCity(rs.getString("city"));
		customer.setState(rs.getString("state"));
		customer.setPincode(rs.getString("pincode"));
		return customer;
	}

}
