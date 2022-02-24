package com.genpact.group_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.genpact.group_1.mapper.ProductMapper;
import com.genpact.group_1.mapper.RowMapperProduct;
import com.genpact.group_1.dao.CustomerDao;
import com.genpact.group_1.model.Customer;
import com.genpact.group_1.model.OrderTable;
import com.genpact.group_1.model.Product;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	 create table admin(
		 adminid varchar(20) primary key,
		 password varchar(15) not null,
		 emailid  varchar(20) not null unique,
		 age int not null,
		 contact char(10) not null unique,
		 city varchar(20) not null,
		 state varchar(20) not null,
		 pincode char(6) not null unique
		 );
	 */


	@Override
	public boolean addCusomer(Customer customer) {
		try {
			String query = "insert into admin values "
					+ "(?,?,?,?,?,?,?,?) ";
			int count = jdbcTemplate.execute(query,new PreparedStatementCallback<Integer>(){

				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					ps.setString(1, customer.getCustomerid());
					ps.setString(2, customer.getPassword());
					ps.setString(3, customer.getEmailid());
					ps.setInt(4, customer.getAge());
					
					return ps.executeUpdate();
				}
				
			});
			if(count > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCostomerByName(String CustomerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(String CustomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}