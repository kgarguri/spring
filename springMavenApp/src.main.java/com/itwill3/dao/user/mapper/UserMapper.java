package com.itwill3.dao.user.mapper;

import java.util.ArrayList;

import com.itwill3.dao.user.User;

public interface UserMapper {

	public int create(User user);
	
	public ArrayList<User> findUserList();
}
