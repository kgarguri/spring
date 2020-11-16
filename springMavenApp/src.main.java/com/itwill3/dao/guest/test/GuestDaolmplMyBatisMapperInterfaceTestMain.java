package com.itwill3.dao.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;
import com.itwill3.dao.guest.GuestDaoImplMyBatis;

public class GuestDaolmplMyBatisMapperInterfaceTestMain {

	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill3/dao/guest/guest-dao-Mybatis-mapper-interface.xml");
		GuestDao guestDao=(GuestDao)applicationContext.getBean("guestDao");
		System.out.println("### "+guestDao.selectAll());
		System.out.println("### "+guestDao.selectByNo(51));
	}

}
