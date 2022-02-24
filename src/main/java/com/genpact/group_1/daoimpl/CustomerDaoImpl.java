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

import com.genpact.group_1.mapper.CustomerMapper;
import com.genpact.group_1.mapper.ProductMapper;
import com.genpact.group_1.mapper.RowMapperCustomer;
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
					ps.setString(5,customer.getContact());
					ps.setString(6, customer.getCity());
					ps.setString(7, customer.getState());
					ps.setString(8, customer.getPincode());
					
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
	public boolean deleteCustomer(String customerid) {
		try {
			String query = "delete from customer where customerid like ? ";
			int count = jdbcTemplate.execute(query,new PreparedStatementCallback<Integer>(){

				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					
					ps.setString(1, customerid);
					
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
	public List<Customer> getAllCustomer() {
		List<Customer> lst = new ArrayList<>();
		try {
			String query = "SELECT * FROM customer";
			lst = jdbcTemplate.query(query,new RowMapperCustomer());
		} catch (Exception e) {
			e.printStackTrace();
			lst.clear();
		}
		return lst;
	}

	@Override
	public Customer getCostomerById(String CustomerId) {
		Customer customer = null;
		try {
			String query = "select * from customer where customerid like ? ";
			return customer = jdbcTemplate.execute(query,new PreparedStatementCallback<Customer>() {

				@Override
				public Customer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					Customer cs = null;
					ps.setString(1, CustomerId);
					ResultSet rs = ps.executeQuery();
					
					
					if(rs.isBeforeFirst()) {
						rs.next();
						cs = CustomerMapper.mapCustomer(rs);
					}
					return cs;
					
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer getCustomerByEmail(String CustomerEmail) {
		Customer customer = null;
		try {
			String query = "select * from customer where emailid like ? ";
			return customer = jdbcTemplate.execute(query,new PreparedStatementCallback<Customer>() {

				@Override
				public Customer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					Customer cs = null;
					ps.setString(1, CustomerEmail);
					ResultSet rs = ps.executeQuery();
					
					
					if(rs.isBeforeFirst()) {
						rs.next();
						cs = CustomerMapper.mapCustomer(rs);
					}
					return cs;
					
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

}