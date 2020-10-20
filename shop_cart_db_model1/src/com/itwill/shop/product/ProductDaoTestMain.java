package com.itwill.shop.product;

import javax.naming.InitialContext;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDao productDao = new ProductDao();
		Product product = new Product();
		
		//product = productDao.getProduct(1);
		System.out.println("product");
		//System.out.println(product);

	}

}
