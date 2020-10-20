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

public class StudentDaoDynamicSql {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapperDynamicSql.";
	public StudentDaoDynamicSql(){
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Student> findStudents(Student findStudent) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> findStudentList = sqlSession.selectList(NAMESPACE+"findStudents", findStudent);
		sqlSession.close();
		return findStudentList;
	}
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateRowCount = sqlSession.update(NAMESPACE+"updateStudentById", updateStudent);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	public List<Student> findStudentsOrderList(String columnName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> findStudentOrderList = sqlSession.selectList(NAMESPACE+"findStudentsOrderList", columnName);
		//sqlSession.commit();
		sqlSession.close();
		return findStudentOrderList;
	}
}












