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

import com.itwill3.dao.guest.mapper.GuestMapper;


@Repository("guestDaoImplMyBatisMapperInterface")
public class GuestDaoImplMyBatisMapperInterface  implements GuestDao{
	@Autowired
	private GuestMapper guestMapper; // 내부적으로 sqlsession 을 가지고 있다.
	
	public GuestDaoImplMyBatisMapperInterface() throws Exception {
		
	}
	public void setGuestMapper(GuestMapper guestMapper) {
		this.guestMapper = guestMapper;
	}
	/*
	 * READ ALL
	 */
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList1 = new ArrayList<Guest>();
		List<Guest> guestList2 = guestMapper.selectAll();
		guestList1=(ArrayList<Guest>)guestList2;
		return guestList1;
	}
	/*
	 * CREATE
	 */
	public int insertGuest(Guest guest) throws Exception {
		int insertRowCount=0;
		insertRowCount=guestMapper.insertGuest(guest);
		return insertRowCount;
	};
	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		Guest guest=guestMapper.selectByNo(no);
		return guest;
	}
	/*
	 * DELETE
	 */
	public int deleteGuest(int guest_no) throws Exception{
		int deleteRowCount=guestMapper.deleteGuest(guest_no);
		return deleteRowCount;
	}
	/*
	 * UPDATE
	 */
	public int updateGuest(Guest updateGuest) throws Exception{
		int updateRowCount=0;
		updateRowCount=guestMapper.updateGuest(updateGuest);
		return updateRowCount;
	}
	

}










