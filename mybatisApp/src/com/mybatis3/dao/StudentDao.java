package com.mybatis3.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;  // 이전 dataSource
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	
	public StudentDao() {
		try {
		InputStream mybatisConfigInputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		sqlSessionFactory = ssfb.build(mybatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* @@@@@@@@@@@@@@@@@@  delete  @@@@@@@@@@@@@@@*/
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteStudentById", studId);
		sqlSession.close();
		return deleteRowCount;
	}
	public int deleteStudentByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteStudentByName", name);
		sqlSession.close();
		return deleteRowCount;
	}
	public int deleteStudentByNameLike(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteStudentByNameLike", name);
		sqlSession.close();
		return deleteRowCount;
	}
	/* @@@@@@@@@@@@@@@@@@  update  @@@@@@@@@@@@@@@*/
	public int updateStudent(Student student) {
		/*
		 <<sqlSessionFactory.openSession(false)>>
		 
		 * true  :  autocommit true
		 * 	   		sqlSession.close();		
		 * false : autocommit false
		 *     		sqlSession.commit();
		 *     		sqlSession.close();
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRowCount = sqlSession.update(NAMESPACE+"updateStudent", student);
		sqlSession.close();
		return updateRowCount;
	}
	public int updateStudentParamMap(Map studentMap) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRowCount = sqlSession.update(NAMESPACE+"updateStudentParamMap", studentMap);
		sqlSession.close();
		return updateRowCount;
	}
		/* @@@@@@@@@@@@@@@@@@  insert  @@@@@@@@@@@@@@@*/
	/*
	 <<sqlSessionFactory.openSession(true)>>
	 
	 * true  :  autocommit true   => openSession() : 자동commit
	 * 	   		sqlSession.close();		
	 * false : autocommit false
	 *     		sqlSession.commit();
	 *     		sqlSession.close();
	 */
	public int insertStudent(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount = sqlSession.insert(NAMESPACE+"insertStudent", student);
		sqlSession.close();
		return insertRowCount;
	}
	
	public int insertStudentBySequence1(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int insertRowCount = sqlSession.
				insert(NAMESPACE+"insertStudentBySequence1",student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	public int insertStudentBySequence2(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int insertRowCount = sqlSession.
				insert(NAMESPACE+"insertStudentBySequence2",student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	/* @@@@@@@@@@@@@@@@@@  select [MAP] @@@@@@@@@@@@@@@*/
	public HashMap findStudentByIdMap(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		HashMap findStudent = sqlSession.
				selectOne(NAMESPACE+"findStudentByIdMap",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	public List<HashMap> findAllStudentsMapList() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<HashMap> studentMapList = sqlSession.
				selectList(NAMESPACE+"findAllStudentsMapList");
		sqlSession.close();
		return studentMapList;
		
		
	}
	/* @@@@@@@@@@@@@@@@@@  select [ETC] @@@@@@@@@@@@@@@*/
	public List<String> findStudentNameList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<String> nameList = sqlSession.selectList(NAMESPACE+"findStudentNameList");
		sqlSession.close();
		return nameList;
	}
	public String findStudentNameById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String name = sqlSession.selectOne(NAMESPACE+"findStudentNameById", studId);
		sqlSession.close();
		return name;
	}
	
	/* @@@@@@@@@@@@@@@@@@  select [join] @@@@@@@@@@@@@@@*/

	public Student findStudentByIdWithCourses(Integer courseId) {
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		Student findStudent=
				sqlSession
				.selectOne(NAMESPACE+"findStudentByIdWithCourses",
						courseId);
		
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = sqlSession.
				selectOne(NAMESPACE+"findStudentByIdWithAddress",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	/* @@@@@@@@@@@@@@@@@@  select  @@@@@@@@@@@@@@@*/
	public Student findStudentByIdresultMap(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = sqlSession.
				selectOne(NAMESPACE+"findStudentByIdResultMap",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
	}
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student findStudent = sqlSession.
				selectOne(NAMESPACE+"findStudentById",studId);
		sqlSession.commit();
		sqlSession.close();
		return findStudent;
		
		/*
		 *  아래 작업과 동일함
		 *  Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_NO);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				findGuest = new Guest(rs.getInt("guest_no"), rs.getString("guest_name"),
					              rs.getNString("guest_date"), rs.getString("guest_email"),
					              rs.getString("guest_homepage"), rs.getString("guest_title"), rs.getString("guest_content"));
			}
			rs.close();
			pstmt.close();
			ConnectionFactory.releaseConnection(con);
			return findGuest;
		 */
		
	}
	/* @@@@@@@@@@@@@@@@@@  select  @@@@@@@@@@@@@@@*/
	public List<Student> findAllStudents() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList = sqlSession.
				selectList(NAMESPACE+"findAllStudents");
		sqlSession.close();
		return studentList;
	}
	public List<Student> findStudentByIdRangeParamMap(Map rangeMap) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList = sqlSession.
				selectList(NAMESPACE+"findStudentByIdRangeParamMap", rangeMap);
		sqlSession.close();
		return studentList;
	}
	public List<Student> findStudentByIdThreeParamMap(Map threeMap) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList = sqlSession.
				selectList(NAMESPACE+"findStudentByIdThreeParamMap", threeMap);
		sqlSession.close();
		return studentList;
	}
	
	
}












