package com.itwill.shop.cart;

import java.util.ArrayList;

import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class CartService {
	private CartDao cartDao;
	private ProductDao productDao;
	public CartService() throws Exception{
		cartDao=new CartDao();
		productDao=new ProductDao();
	}
	
	public synchronized int add(String sUserId,int p_no, int cart_qty) throws Exception{
		
		Product product=productDao.getProduct(p_no);
		if(cartDao.isProductExist(sUserId, p_no)) {
			return cartDao.update(sUserId, product, cart_qty);
		}else {
			return cartDao.add(sUserId,product, cart_qty);
		}
	}
	public synchronized int update(String sUserId,int p_no,int cart_qty) throws Exception{
		Product product=productDao.getProduct(p_no);
		if(cartDao.isProductExist(sUserId, p_no)) {
			return cartDao.update(sUserId, product, cart_qty);
		}
		return 0;
	}
	
	public synchronized ArrayList<CartItemDto> getCartItemList(String sUserId) throws Exception{
		return cartDao.getCartItemList(sUserId);
	}
	public  int deleteCartItem(int cart_itemno)  throws Exception{
		return cartDao.deleteCartItem(cart_itemno);
	}

	public synchronized int deleteCart(String sUserId)  throws Exception{
		return cartDao.deleteCart(sUserId);
	}
}
