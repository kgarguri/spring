package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("guestMyBatis")
public class GuestDaoImplMyBatis implements GuestDao{
	@Autowired
	private GuestService guestService;
	
	public final static String NAMESPACE = "com.itwill3.dao.guest.mapper.GuestMapper.";
	
	public GuestDaoImplMyBatis() throws Exception {
		
	}
	
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList1 = new ArrayList<Guest>();
		//List<Guest> guestList2 = sqlSession.selectList(NAMESPACE+"selectAll");
		//guestList1=(ArrayList<Guest>)guestList2;
		return guestList1;
	}
	/*
	 * CREATE
	 */
	public int insertGuest(Guest guest) throws Exception {
		//int insertRowCount=sqlSession.insert(NAMESPACE+"insertGuest", guest); 
		//sqlSession.commit();
		//return insertRowCount;
		return 0;
	}

	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		//Guest guest =sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		Guest guest = null;
		return guest;
	}
	
	
	
	/*
	 * DELETE
	 */
	public int deleteGuest(int guest_no) throws Exception{
		boolean deleteOK=false;
		
		//int deleteRowCount=sqlSession.insert(NAMESPACE+"deleteGuest", guest_no); 
		//sqlSession.commit();
		//return deleteRowCount;
		return 0;
	}
	/*
	 * UPDATE
	 */
	public int updateGuest(Guest updateGuest) throws Exception{
		
		//int updateRowCount=sqlSession.insert(NAMESPACE+"updateGuest", updateGuest); 
		//sqlSession.commit();
		//return updateRowCount;
		return 0;
	}
	
}
