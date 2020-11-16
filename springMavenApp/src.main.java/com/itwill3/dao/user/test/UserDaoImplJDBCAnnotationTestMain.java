package com.itwill3.dao.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;
import com.itwill3.dao.user.UserDao;

public class UserDaoImplJDBCAnnotationTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/user-dao-jdbc-annotation.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDaoImplJDBC");
		System.out.println("### "+userDao.findUserList());
		System.out.println("### "+userDao.findUser("helprun"));
	
	}

}
