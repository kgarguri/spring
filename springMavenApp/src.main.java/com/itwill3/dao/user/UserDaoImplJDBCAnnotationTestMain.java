package com.itwill3.dao.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplJDBCAnnotationTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/user-dao-jdbc-annotation.xml");
		
		//UserDao userdao = (UserDao)applicationContext.getBean("userDao");
		UserDao userdao = (UserDao)applicationContext.getBean("userDaoImplJDBC");
		//UserDaoImplJDBC userdao = (UserDaoImplJDBC)applicationContext.getBean("userDaoImplJDBC");
		
		//System.out.println(userdao.findUser("guard1"));
		//userdao.findUserList();
		userdao.existedUser("guard1");
		System.out.println(userdao.findUserList());
		System.out.println(userdao.existedUser("guard1"));

	}

}
