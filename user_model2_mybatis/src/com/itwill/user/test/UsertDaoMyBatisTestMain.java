package com.itwill.user.test;

import java.util.List;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserDaoMyBatis;

public class UsertDaoMyBatisTestMain {

	public static void main(String[] args)throws Exception {
		UserDaoMyBatis userDao = new UserDaoMyBatis();
		/*
		Boolean findUser = userDao.existedUser("guard1");
		System.out.println("existedUser : "+findUser);
		*/
		
		List<User> userList = userDao.findUserList();
		System.out.println("findUserList() : "+userList);
	}

}
