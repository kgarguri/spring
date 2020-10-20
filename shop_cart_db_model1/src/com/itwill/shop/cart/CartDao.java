package com.itwill.shop.cart;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwill.shop.product.Product;
import com.itwill.user.User;
import com.sun.media.jfxmedia.logging.Logger;

public class CartDao {
	private DataSource dataSource;
	public CartDao() throws Exception {
		InitialContext ic=new InitialContext();
		dataSource=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
	}
	public  boolean isProductExist(String sUserId,int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isExist=false;
		String selectQuery = "select count(*) as p_count from cart2 c join user2 u on c.userid = u.userid join product2 p on c.p_no=p.p_no where u.userid=? and c.p_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			pstmt.setInt(2,p_no);
			rs = pstmt.executeQuery();
			int count=0;
			if (rs.next()) {
				count=rs.getInt(1);
			}
			if(count==0) {
				isExist=false;
			}else {
				isExist=true;
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return isExist;
	}
	public  int add(String sUserId,Product product, int cart_qty) throws Exception {
			/*
			CREATE TABLE cart1_guard(
					cart_itemno                   		NUMBER(10)		 NULL ,
					userId                        		VARCHAR2(100)		 NULL ,
					p_no                          		NUMBER(10)		 NULL ,
					cart_qty                      		NUMBER(10)		 DEFAULT 0		 NOT NULL,
					cart_tot_price                		NUMBER(10)		 DEFAULT 0		 NOT NULL
			);
			 */
		
			Connection con = null;
			PreparedStatement pstmt = null;
			String insertQuery = "INSERT INTO cart2(cart_itemno, userId, p_no, cart_qty, cart_tot_price) VALUES (cart2_cart_itemno_SEQ.nextval, ?, ?, ?, ?)";
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(insertQuery);
				pstmt.setString(1, sUserId);
				pstmt.setInt(2, product.getP_no());
				pstmt.setInt(3, cart_qty);
				pstmt.setInt(4, product.getP_price()*cart_qty);
				int rows = pstmt.executeUpdate();
				return rows;
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			}
	}
	public  int update(String sUserId,Product product,int cart_qty) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String updateQuery = "update cart2 set cart_qty = cart_qty + ?,cart_tot_price = (cart_qty + ?) * ?  where userid=? and p_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1, cart_qty);
			pstmt.setInt(2, cart_qty);
			pstmt.setInt(3, product.getP_price());
			pstmt.setString(4, sUserId);
			pstmt.setInt(5, product.getP_no());
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
	
	public  ArrayList<CartItemDto> getCartItemList(String sUserId) throws Exception{
		
		System.out.println("dao getCartItemList");
		
		ArrayList<CartItemDto> cartItemList= new ArrayList<CartItemDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		/*
		select c.p_no,c.cart_qty,c.cart_tot_price ,p.p_name,p.p_image,p.p_price 
		from cart2 c join user2 u 
		on c.userid = u.userid join product2 p on c.p_no=p.p_no where u.userid='guard1';
		 */
		String selectQuery = " select c.cart_itemno cart_itemno, c.p_no p_no, c.cart_qty cart_qty, c.cart_tot_price cart_tot_price, p.p_name p_name, p.p_image p_image, p.p_price "+
							 " from cart2 c join user2 u "+
							 " on c.userid = u.userid join product2 p on c.p_no=p.p_no where u.userid=? ";
		try {
			con = dataSource.getConnection();
			
			
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
		
			while (rs.next()) {

				cartItemList.add(new CartItemDto(
						rs.getInt("cart_itemno"),
						sUserId,
						rs.getInt("p_no"),
						rs.getString("p_name"),
						rs.getString("p_image"),
						rs.getInt("cart_qty"),
						rs.getInt("cart_tot_price")
						));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return cartItemList;
		
	}
	
	
	public  int deleteCartItem(int cart_itemno)  throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String removeQuery = "delete from cart2 where cart_itemno = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setInt(1, cart_itemno);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	public  int deleteCart(String sUserId)  throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		String removeQuery = "delete from cart2 where userid=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setString(1, sUserId);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
}
