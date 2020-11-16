package com.itwill3.dao.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;
import com.itwill3.dao.user.User;
import com.itwill3.dao.user.UserDao;

public class UserDaoImplMyBatisMapperInterfaceTestMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/user-dao-mybatis-mapper-interface.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		/*
		User user=new User("gggg","gggg","ggg@gmail.com","지지지");
		System.out.println("### "+userDao.create(user));
		
		user.setName("지변경");
		System.out.println("### "+userDao.update(user));
		System.out.println("### "+userDao.findUser("gggg"));
		System.out.println("### "+userDao.remove("gggg"));
		*/

		System.out.println("### "+userDao.findUserList());
		
	}

}
