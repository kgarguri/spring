package com.itwill.guest.test;

import java.util.Date;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImplMyBatis;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDaoImplMyBatis();
		/*
		System.out.println(guestDao.selectAll());
		System.out.println("1.insert");
		System.out.println(guestDao
				.insertGuest(
						new Guest(-9090, "이름", null, "이메일", "홈페이지", "타이틀", "내용")));
		
		Guest guest=guestDao.selectByNo(4);
		guest.setGuest_name("김변경");
		System.out.println("2.update");
		*/

		//System.out.println(guestDao.updateGuest(new Guest
			//	(8,  "이미란", "lee@naver.com", "lee@lee.com", "영화배우", "안녕하세요 천만배우 이미란입니다.")));
		//Guest(8,  "이미란", "lee@naver.com", "lee@lee.com", "영화배우", "안녕하세요 천만배우 이미란입니다.")));
		
		//Guest updateGuest = new Guest(8, "수정수정", new Date(), "modify@naver.com", "modify@naver.com", "수", "수정수정");
		//Guest updateGuest = new Guest(8, "수정수정", "2020-09-22", "modify@naver.com", "modify@naver.com", "수", "수정수정");
		Guest updateGuest = new Guest(8,  "이미란", "lee@naver.com", "lee@lee.com", "영화배우", "안녕하세요 천만배우 이미란입니다.");
		System.out.println(guestDao.updateGuest(updateGuest));
	}	

}
