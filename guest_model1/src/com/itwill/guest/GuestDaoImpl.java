package com.itwill.guest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.css.PseudoClass;



public class GuestDaoImpl implements GuestDao{
	
	public GuestDaoImpl() throws Exception{
		
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		int insertRowcount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return insertRowcount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest findGuest = new Guest();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_NO);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			findGuest = new Guest(rs.getInt("guest_no"), rs.getString("guest_name"),
					              rs.getNString("guest_date"), rs.getString("guest_email"),
					              rs.getString("guest_homepage"), rs.getString("guest_title"), rs.getString("guest_content"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return findGuest;
	}
	/*
		이름             널?       유형             
		-------------- -------- -------------- 
		GUEST_NO       NOT NULL NUMBER(10)     
		GUEST_NAME     NOT NULL VARCHAR2(100)  
		GUEST_DATE     NOT NULL DATE           
		GUEST_EMAIL             VARCHAR2(100)  
		GUEST_HOMEPAGE          VARCHAR2(100)  
		GUEST_TITLE    NOT NULL VARCHAR2(255)  
		GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
	 */
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList=new ArrayList<Guest>();
		
		Connection con = 
				ConnectionFactory.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			guestList.add(
					new Guest(rs.getInt("guest_no"),
							rs.getString("guest_name"),
							rs.getString("guest_date"),
							rs.getString("guest_email"),
							rs.getString("guest_homepage"),
							rs.getString("guest_title"),
							rs.getString("guest_content")));
			
		}
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		System.out.println("name :"+guest.getGuest_name());
		System.out.println("email :"+guest.getGuest_email());
		System.out.println("homepage :"+guest.getGuest_homepage());
		System.out.println("title :"+guest.getGuest_title());
		System.out.println("content :"+guest.getGuest_content());
		System.out.println("no :"+guest.getGuest_no());
		
		
		
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		int update_cnt = pstmt.executeUpdate();
		return update_cnt;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int deleteCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return deleteCount;
	}

}
