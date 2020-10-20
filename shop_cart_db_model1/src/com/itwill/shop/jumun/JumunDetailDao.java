package com.itwill.shop.jumun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwill.shop.product.Product;

import sun.security.action.GetIntegerAction;

public class JumunDetailDao {
	private DataSource dataSource;
	public JumunDetailDao() throws Exception{
		InitialContext ic=new InitialContext();
		dataSource=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
	}
	/*
	 * 주문1개의 주문상세들삭제
	 */
	public int delete(int j_no)throws Exception{
		/*
		delete from jumun_detail2 where j_no=6;
		 */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String jumunDetailDeleteQuery = "delete from jumun_detail2 where j_no=?";
		int deleteRowCount=0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(jumunDetailDeleteQuery);
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
	 * 주문상세생성
	 */
	public int create(String sUserId,JumunDetail jumunDetail) throws Exception{
		
		System.out.println("dao jumun_detail2");
		
		Connection con = null;
		PreparedStatement pstmt1= null;
		PreparedStatement pstmt2= null;
		ResultSet rs = null;
		
		String jumunDetailNoSelectQuery="select max(jd_no)+1 jd_no from jumun_detail2";
		
		String jumunInsertQuery = "INSERT INTO jumun_detail2 (jd_no, jd_qty, jd_pname, jd_tot_price, j_no, p_no) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			con = dataSource.getConnection();
			int jd_no = -999;
			
			pstmt1 = con.prepareStatement(jumunDetailNoSelectQuery);
			rs=pstmt1.executeQuery();
			rs.next();
			jd_no = rs.getInt("jd_no");
			
			pstmt2 = con.prepareStatement(jumunInsertQuery);
			pstmt2.setInt(1, jd_no);
			pstmt2.setInt(2, jumunDetail.getJd_qty());
			pstmt2.setString(3,jumunDetail.getJd_pname());
			pstmt2.setInt(4,jumunDetail.getJd_tot_price());
			pstmt2.setInt(5,jumunDetail.getJ_no());
			pstmt2.setInt(6,jumunDetail.getP_no());
			int rows = pstmt2.executeUpdate();
			
			return rows;
		} finally {
			if (pstmt2 != null)
				pstmt1.close();
				pstmt2.close();
			if (con != null)
				con.close();
		}
	}
	/*
	 * 주문상세리스트
	 */
	public  ArrayList<JumunDetail> list(String sUserId,int j_no) throws Exception{
		ArrayList<JumunDetail> jumunDetailList= new ArrayList<JumunDetail>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*
		 select j.*,jd.* from jumun2 j 
		 join jumun_detail2 jd 
		 on j.j_no=jd.j_no 
		 where j.userid='guard1' and j.j_no=1; 
		 */
		String selectQuery = "select j.*,jd.*,p.* from jumun2 j " + 
				"		join jumun_detail2 jd " + 
				"		on j.j_no=jd.j_no "+ 
				"       join product2 p on jd.p_no=p.p_no " + 
				"		where j.userid=? and j.j_no=?" ;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			pstmt.setInt(2,j_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				Product jumunProduct=new Product(rs.getInt("p_no"),
												rs.getString("p_name"),
												rs.getInt("p_price"),
												rs.getString("p_image"),
												rs.getString("p_desc"),
												rs.getInt("p_click_count")); 
				
				JumunDetail jumunDetail=new JumunDetail(rs.getInt("jd_no"),
						rs.getInt("jd_qty"),
						rs.getString("jd_pname"),
						rs.getInt("jd_tot_price"),
						rs.getInt("j_no"),
						rs.getInt("p_no"),jumunProduct);
				
				jumunDetailList.add(jumunDetail);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return jumunDetailList;
		
	}
	
	
	
	
	
	
	
	
}
