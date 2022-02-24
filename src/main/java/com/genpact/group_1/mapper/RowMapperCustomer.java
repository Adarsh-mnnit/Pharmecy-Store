package com.genpact.group_1.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.group_1.model.Customer;

public class RowMapperCustomer implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
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
