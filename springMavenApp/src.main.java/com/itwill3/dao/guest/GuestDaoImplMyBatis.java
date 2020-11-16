package com.itwill3.dao.guest;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("guestDaoMyBatis")
public class GuestDaoImplMyBatis  implements GuestDao{
	@Autowired
	private SqlSession sqlSession;
	
	public final static String NAMESPACE=
			"com.itwill3.dao.guest.mapper.GuestMapper.";
	public GuestDaoImplMyBatis() throws Exception {
		
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/*
	 * READ ALL
	 */
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList1 = new ArrayList<Guest>();
		List<Guest> guestList2 = sqlSession.selectList(NAMESPACE+"selectAll");
		guestList1=(ArrayList<Guest>)guestList2;
		return guestList1;
	}
	/*
	 * CREATE
	 */
	public int insertGuest(Guest guest) throws Exception {
		int insertRowCount=sqlSession.insert(NAMESPACE+"insertGuest", guest); 
		sqlSession.commit();
		return insertRowCount;
	}

	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		Guest guest =sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		return guest;
	}
	
	
	
	/*
	 * DELETE
	 */
	public int deleteGuest(int guest_no) throws Exception{
		boolean deleteOK=false;
		
		int deleteRowCount=sqlSession.insert(NAMESPACE+"deleteGuest", guest_no); 
		sqlSession.commit();
		return deleteRowCount;
	}
	/*
	 * UPDATE
	 */
	public int updateGuest(Guest updateGuest) throws Exception{
		
		int updateRowCount=sqlSession.insert(NAMESPACE+"updateGuest", updateGuest); 
		sqlSession.commit();
		return updateRowCount;
	}
	

}










