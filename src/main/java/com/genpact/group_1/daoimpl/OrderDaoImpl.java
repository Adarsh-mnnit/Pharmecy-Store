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

import com.genpact.group_1.dao.OrderDao;
import com.genpact.group_1.mapper.ProductMapper;
import com.genpact.group_1.mapper.RowMapperOrder;
import com.genpact.group_1.model.OrderTable;
import com.genpact.group_1.model.Product;

public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<OrderTable> getAllOrder() {
			List<OrderTable> lst = new ArrayList<>();
		
		String query = "select o.orderid, p.name, o.quantity, o.orderdate, o.deliverydate, c.customerid ,o.billamount"
				+ "from ordertable o,product p,customer c "
				+ "where o.customerid like c.customerid and o.productid = p.productid";
		
		try {
		   lst=jdbcTemplate.query(query, new RowMapperOrder());
		}
		catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
		
		return lst;
	}

	@Override
	public List<OrderTable> allCompleteOrder() {
		List<OrderTable> lst = new ArrayList<>();
		
		String query ="SELECT * FROM ordertable where canceled = 0 and confirm = 1";
			
			try {
			 lst=jdbcTemplate.query(query, new RowMapperOrder() );
			}
			catch (Exception e) {
				e.printStackTrace();
				lst.clear();
				return lst;
			}
			
			return lst;
	}

	@Override
	public List<OrderTable> checkPendingOrder() {
		
		List<OrderTable> lst = new ArrayList<>();
		
		String query = "select o.orderid, p.name, o.quantity, o.orderdate, o.deliverydate, c.customerid ,o.billamount "
				+ "from ordertable o,product p,customer c"
				+ " where o.customerid like c.customerid and o.productid = p.productid and o.canceled = 0 and o.confirm = 0";
		
		try {
		
		lst = jdbcTemplate.query(query, new RowMapperOrder());
		
		} catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
		
		return lst;
	}
	@Override
	public boolean acceptOrder(int orderId) {
		
		boolean b = false;
		String query = "update  ordertable set confirm = 1 where orderid = ? and canceled = 0 and confirm =  0";
		
		try {
			b = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
				
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) 
						throws SQLException, DataAccessException {
					
					ps.setInt(1,orderId);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.isBeforeFirst())
						return true;
					else
						return false;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return b;
	}

	

	@Override
	public boolean addOrderByQuantity(String productName, int unit, String customerId) {

		String query1 = "SELECT * FROM product where name like ?";

		// find Product details using its name for placing order

		Product product = null;
		try {

			product = jdbcTemplate.execute(query1, new PreparedStatementCallback<Product>() {

				@Override
				public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					ps.setString(1, productName);

					ResultSet rs = ps.executeQuery();

					if (rs.isBeforeFirst()) {
						rs.next();
						Product pr = ProductMapper.mapProduct(rs);

						return pr;
					} else
						return null;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Finding Current Date
		long millis = System.currentTimeMillis();
		Date date = new java.sql.Date(millis);

		// Finding Delivery date after 4 days
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date.toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cal.add(Calendar.DAY_OF_MONTH, 4);
		String deliveryDate = sdf.format(cal.getTime());

		// Making order object and setting each values

		OrderTable order = new OrderTable();

		if (product != null) {
			order.setProductid(product.getProductid());
			order.setBillamount(unit * product.getPrice());
		}
		order.setCustomerid(customerId);
		order.setQuantity(unit);
		order.setOrderdate(date.toString());
		order.setDeliverydate(deliveryDate);

		// Insertion of Order Details in database
		boolean b = false;
		String query2 = "insert into "
				+ "ordertable(productid,customerid,quantity,"
				+ "orderdate,deliverydate,billamount) values"
				+ "(?,?,?,?,?,?)";

		int count = jdbcTemplate.execute(query2, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setInt(1, order.getProductid());
				ps.setString(2, order.getCustomerid());
				ps.setInt(3, order.getQuantity());
				ps.setDate(4, (java.sql.Date) date);
				ps.setDate(5, (java.sql.Date) cal.getTime());
				ps.setInt(6, order.getBillamount());
				return ps.executeUpdate();
			}
		});

		if (count > 0)
			b = true;

		return b;
	}

	@Override
	public boolean cancelOrder(int orderId) {

		boolean b = false;
		String query = "update ordertable set canceled=1 where orderid=? and canceled=0 and confirm=0";
		try {

			int count = jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {

				@Override
				public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1, orderId);
					return ps.executeUpdate();
				}
			});

			if (count > 0)
				b = true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return b;
	}

}
