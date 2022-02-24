package com.genpact.group_1.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.genpact.group_1.model.OrderDetail;

public class RowMapperOrderDetail implements RowMapper<OrderDetail>{
	
	public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDetail order = new OrderDetail();
		order.setOrderid(rs.getInt(1));
		order.setProductName(rs.getString(2));
		order.setQuantity(rs.getInt(3));
		order.setOrderdate(rs.getString(4));
		order.setDeliverydate(rs.getString(5));
		order.setCustomerid(rs.getString(6));
		order.setBillamount(rs.getInt(7));
		
		return order;
	}

}