package com.genpact.group_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;


import com.genpact.group_1.dao.AdminDao;
import com.genpact.group_1.mapper.ProductMapper;
import com.genpact.group_1.mapper.RowMapperOrder;
import com.genpact.group_1.mapper.RowMapperProduct;
import com.genpact.group_1.model.OrderTable;
import com.genpact.group_1.model.Product;

public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}