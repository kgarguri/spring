package com.itwill.guest;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GuestDaoImplMyBatis  implements GuestDao{

	private SqlSessionFactory sqlSessionFactory;
	public final static String NAMESPACE=
			"com.itwill.guest.mapper.GuestMapper.";
	
	public GuestDaoImplMyBatis() throws Exception {
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = 
					new SqlSessionFactoryBuilder()
					.build(in);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * READ ALL
	 */
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList1 = new ArrayList<Guest>();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Guest> guestList2 = sqlSession.selectList(NAMESPACE+"selectAll");
		guestList1=(ArrayList<Guest>)guestList2;
		sqlSession.close();
		return guestList1;
	}
	/*
	 * CREATE
	 */
	public int insertGuest(Guest guest) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int insertRowCount=sqlSession.insert(NAMESPACE+"insertGuest", guest); 
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}

	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Guest guest =sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		sqlSession.close();
		return guest;
	}
	
	
	
	/*
	 * DELETE
	 */
	public int deleteGuest(int guest_no) throws Exception{
		boolean deleteOK=false;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=sqlSession.insert(NAMESPACE+"deleteGuest", guest_no); 
		sqlSession.commit();
		sqlSession.close();
		return deleteRowCount;
	}
	/*
	 * UPDATE
	 */
	public int updateGuest(Guest updateGuest) throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int updateRowCount=sqlSession.insert(NAMESPACE+"updateGuest", updateGuest); 
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	

}










