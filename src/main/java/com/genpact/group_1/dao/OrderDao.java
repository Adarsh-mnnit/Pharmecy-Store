package com.genpact.group_1.dao;

import java.util.List;

import com.genpact.group_1.model.OrderTable;

public interface OrderDao {
	
	List<OrderTable> getAllOrder();
	List<OrderTable> allCompleteOrder();
	
	List<OrderTable> checkPendingOrder();
	boolean acceptOrder(int orderId);
	
	//Order
	boolean addOrderByQuantity(String productName,int unit,String customerId);
	boolean cancelOrder(int orderId);

}
