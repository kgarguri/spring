package com.itwill3.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill3.dao.user.mapper.UserMapper;

@Repository("UserDaoImplMyBatisMapperInterface")
public class UserDaoImplMyBatisMapperInterface implements UserDao {
	@Autowired
	private UserMapper userMapper;
	
	public UserDaoImplMyBatisMapperInterface() {
		// TODO Auto-generated constructor stub
	}
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : create() 호출  ");
		//int insertRowCount=sqlSession.insert(NAMESPACE+"create", user);
		int insertRowCount = userMapper.create(user);
		//sqlSession.commit();
		//sqlSession.close();
		return insertRowCount;
	}
	

	/*
	 * 기존의 사용자정보를 수정
	 */
	public int update(User user) {
		return 0; 
	};

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	public int remove(String userId) {
		return 0;
	};

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서
	 * User 도메인클래스에 저장하여 반환
	 */
	public User findUser(String userId) {
		User user1 = new User();
		return user1;
	};

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 
	 * List<User> 콜렉션 에 저장하여 반환
	 */
	public List<User> findUserList() {
		//List users = new List();
		ArrayList<User> uArrayList = new ArrayList<User>();
		//List<User> uArrayList = new List<User>();
		uArrayList = userMapper.findUserList();
		return uArrayList;
	};

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	public boolean existedUser(String userId) throws Exception{
		boolean isExist=false;
		return isExist;
	};

	
	
	
}














