package com.genpact.group_1.dao;

import java.util.List;

import com.genpact.group_1.model.Product;

public interface ProductDao {

	//Product
		//Curd
		boolean addProduct(Product product);
		boolean updateProduct(Product product);
		boolean deleteProduct(int id);
		//Query
		List<Product> getAllProduct();
		Product searchProductById(int id);
		Product searchProductByName(String name);
		List<Product> searchProduct(String str);
}
