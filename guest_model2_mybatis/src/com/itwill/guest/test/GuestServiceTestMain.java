package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestServiceTestMain {
	public static void main(String[] args) throws Exception{
		GuestService guestService=new GuestService();
		//System.out.println(guestService.selectAll());
		//System.out.println(guestService.selectByNo(1));
		int update_cnt = guestService.
				updateGuest(new Guest(8,  "이미란", "lee@naver.com", "lee@lee.com", "영화배우", "안녕하세요 천만배우 이미란입니다."));
		System.out.println(update_cnt);
		//System.out.println(guestService.selectByNo(1));
	}
}