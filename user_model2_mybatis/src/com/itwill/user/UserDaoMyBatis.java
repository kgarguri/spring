package com.itwill.user;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDaoMyBatis {
	private SqlSessionFactory sqlSessionFactory;
	public static final String Namespace = "com.itwill.user.mapper.UserMapper.";
	
	public UserDaoMyBatis() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int create (User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertRowCount = sqlSession.insert(Namespace+"create", user);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	
	public int update(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateRowCount = sqlSession.insert(Namespace+"uodate", user);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	public int remove(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteRowCount = sqlSession.delete(Namespace+"remove", userId);
		sqlSession.commit();
		sqlSession.close();
		return deleteRowCount;
	}
	public User findUser (String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User findUser = sqlSession.selectOne(Namespace+"existedUser", userId);
		sqlSession.close();
		return findUser;
	}
	public List<User> findUserList () {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> findUserList = sqlSession.selectList(Namespace+"findUserList");
		sqlSession.close();
		return findUserList;
	}
	public boolean existedUser (String userId) {
		boolean isExist = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User findUser = sqlSession.selectOne(Namespace+"existedUser", userId);
		if (findUser != null) {
			isExist = true;
		}
		sqlSession.close();
		return isExist;
	}

	
}
