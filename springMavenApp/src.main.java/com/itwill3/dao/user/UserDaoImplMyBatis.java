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

@Repository("userDaoImplMyBatis")
public class UserDaoImplMyBatis implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	public final static String NAMESPACE=
			"com.itwill3.dao.user.mapper.UserMapper.";
	public UserDaoImplMyBatis() {
		System.out.println("#### UserDaoImplMyBatis() : 디폴트생성자 호출  ");
	}
	public UserDaoImplMyBatis(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatis(SqlSession sqlSession) : 생성자 호출  ");
		this.sqlSession = sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatis.setSqlSession("+sqlSession+") : 호출  ");
		this.sqlSession = sqlSession;
	}


	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#create(com.itwill.user.User)
	 */
	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : create() 호출  ");
		int insertRowCount=sqlSession.insert(NAMESPACE+"create", user);
		//sqlSession.commit();
		//sqlSession.close();
		return insertRowCount;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#update(com.itwill.user.User)
	 */
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : update() 호출  ");
		int updateRoweCount=sqlSession.insert(NAMESPACE+"update", user);
		//sqlSession.commit();
		//sqlSession.close();
		return updateRoweCount;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#remove(java.lang.String)
	 */
	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : remove() 호출  ");
		int removeRoweCount=sqlSession.insert(NAMESPACE+"remove", userId);
		//sqlSession.commit();
		//sqlSession.close();
		return removeRoweCount;
	}
	
	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서
	 * User 도메인클래스에 저장하여 반환
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUser() 호출  ");
		User user=sqlSession.selectOne(NAMESPACE+"findUser", userId);
		//sqlSession.commit();
		//sqlSession.close();
		return user;
	}
	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 
	 * List<User> 콜렉션 에 저장하여 반환
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#findUserList()
	 */
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUserList 호출  ");
		List<User> userList=sqlSession.selectList(NAMESPACE+"findUserList");
		//sqlSession.commit();
		//sqlSession.close();
		return userList;
	}
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#existedUser(java.lang.String)
	 */

	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplMyBatis : existedUser 호출  ");
		int  count = sqlSession.selectOne(NAMESPACE+"existedUser", userId);
		boolean isExist=false;
		if(count==1) {
			isExist=true;
		}else {
			isExist=false;
		}
		//sqlSession.commit();
		//sqlSession.close();
		return isExist;
	}
	
}














