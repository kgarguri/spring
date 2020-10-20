package com.itwill.shop.jumun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwill.shop.cart.CartItemDto;

public class JumunDao {
	private DataSource dataSource;
	public JumunDao() throws Exception{
		InitialContext ic=new InitialContext();
		dataSource=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
	}
	/*
	 * 주문1개삭제
	 */
	public int delete(int j_no)throws Exception{
		/*
		delete from jumun2 where j_no=6;
		 */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String jumunDeleteQuery = "delete from jumun2 where j_no=?";
		int deleteRowCount=0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(jumunDeleteQuery);
			pstmt.setInt(1, j_no);
			deleteRowCount = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return deleteRowCount;
	}
	/*
	 * 주문생성
	 */
	public int create(String sUserId,Jumun jumun) throws Exception{

		System.out.println("dao jumun2");
		
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String jumunNoSelectQuery="select max(j_no)+1 j_no from jumun2";
		String jumunInsertQuery = "INSERT INTO jumun2 (j_no, j_desc, j_date, j_price, userId) "
				+ " VALUES (?, ?, sysdate, ?, ?)";
		
		int jumun_no = -999;
		try {
			con = dataSource.getConnection();
			
			pstmt1=con.prepareStatement(jumunNoSelectQuery);
			rs=pstmt1.executeQuery();
			rs.next();
			jumun_no = rs.getInt("j_no");
			
			pstmt2 = con.prepareStatement(jumunInsertQuery);
			pstmt2.setInt(1, jumun_no);
			pstmt2.setString(2, jumun.getJ_desc());
			pstmt2.setInt(3, jumun.getJ_price());
			pstmt2.setString(4, jumun.getUserId());
			
			int rows = pstmt2.executeUpdate();
			
			return jumun_no;

		} finally {
			if (pstmt1 != null)
				pstmt1.close();
				pstmt2.close();
			if (con != null)
				con.close();
		}
	}
	/*
	주문전체리스트
	
	이름      널?       유형            
	------- -------- ------------- 
	J_NO    NOT NULL NUMBER(10)    
	J_DESC           VARCHAR2(100) 
	J_DATE           DATE          
	J_PRICE          NUMBER(10)    
	USERID           VARCHAR2(100) 
	 */
	public ArrayList<Jumun> list(String sUserId) throws Exception{
		String selectQuery= " select j.*,u.* from " + 
							" user2 u join jumun2 j " + 
							" on u.userid = j.userid and u.userid=?";
		ArrayList<Jumun> jumunList=new ArrayList<Jumun>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(selectQuery);
			pstmt.setString(1, sUserId);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				jumunList.add(new Jumun(rs.getInt("j_no"),
										rs.getString("j_desc"),
										rs.getDate("j_date"),
										rs.getInt("j_price"),
										rs.getString("userid")
										));
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}
		return jumunList;
		
	}
	
	/*
	public  ArrayList<Jumun> list(String sUserId) throws Exception{
		ArrayList<Jumun> jumunList= new ArrayList<Jumun>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String selectQuery = "select j.* ,u.* from " + 
				" 		 user2 u join jumun2 j " + 
				" 		 on u.userid = j.userid and u.userid=? ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				jumunList.add(new Jumun(rs.getInt("j_no"),
										rs.getString("j_desc"),
										rs.getDate("j_date"),
										rs.getInt("j_price"),
										sUserId));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return jumunList;
		
	}
   */
	/*
	 * 주문한개보기
	 */
	public Jumun detail(String sUserId,int j_no)throws Exception {
		Jumun jumun=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		select j.*, u.* from 
 		user2 u join jumun2 j
 		on u.userid = j.userid and u.userid='guard1' 
 		and j_no=1 ;
		 */
		String selectQuery = "select j.*, u.* from " + 
				" 		 user2 u join jumun2 j " + 
				" 		 on u.userid = j.userid and u.userid=? "+ 
				"        and j_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			pstmt.setInt(2,j_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jumun=new Jumun(rs.getInt("j_no"),
										rs.getString("j_desc"),
										rs.getDate("j_date"),
										rs.getInt("j_price"),
										sUserId);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return jumun;
	}
	
	/*
	 * 주문삭제
	 */
	public void delete() {
		
	}
	
	
	
	
	
	
	
	
	
}
