package com.itwill.guest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDaoImpl();
		//System.out.println(guestDao.selectAll());
		//System.out.println(guestDao.selectByNo(5));
		int in_cnt = guestDao.insertGuest(new Guest( "김남오", "kim5@korea.com", "aaa5@korea.com", "대한민국5", "나는 국가대표 축구선수입니다5"));
		System.out.println(in_cnt);
		
		//int delete_cnt = guestDao.deleteGuest(5);
		//System.out.println(delete_cnt);
		
		//SimpleDateFormat fDate = new SimpleDateFormat("yyyy.MM.dd"); //같은 형식으로 맞춰줌
       // Date n = fDate.parse("2020.08.24");

		//int update_cnt = guestDao.updateGuest(new Guest(7, "이미란", "lee@naver.com", "lee@lee.com", "영화배우", "안녕하세요 천만배우 이미란입니다."));
		//System.out.println(update_cnt);
		
	}

}
