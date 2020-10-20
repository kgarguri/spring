package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;

import javax.print.attribute.standard.Finishings;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		/*
		System.out.println("-------findStudentById-------");
		System.out.println("### : "+studentDao.findStudentById(1));
		System.out.println("-------findStudentByIdResultMap-------");
		System.out.println("### : "+studentDao.findStudentByIdresultMap(2));
		System.out.println("---------findAllStudents---------");
		System.out.println("### : "+studentDao.findAllStudents());
		
		System.out.println("---------insertStudent(Dto)--------------");
		Student student1 = new Student(8001, "이순일", "leesun1@gmain.com", new Date());
		System.out.println("### : "+studentDao.insertStudent(student1));
		System.out.println("insert PK : "+student1);
	
		System.out.println("---------insertStudentBySequence1---------");
		Student student2 = new Student(null, "이순육", "leesun6@gmain.com", new Date());
		System.out.println("### : "+studentDao.insertStudentBySequence1(student2));
		System.out.println("insert PK : "+student2.getStudId());
		
		System.out.println("---------insertStudentBySequence2---------");
		Student student3 = new Student(null, "이순칠", "leesun7@gmain.com", new Date());
		System.out.println("### : "+studentDao.insertStudentBySequence2(student3));
		System.out.println("insert PK : "+student3.getStudId());
		
		System.out.println("---------updateStudent-------------------");
		Student upStudent = studentDao.findStudentById(2);
		upStudent.setName("김변경");
		upStudent.setEmail("change@gmail.com");
		upStudent.setDob(new Date());
		System.out.println("update :"+studentDao.updateStudent(upStudent));
		System.out.println("###"+studentDao.deleteStudentById(2));
		System.out.println("###"+studentDao.deleteStudentByName("김팔천"));
		System.out.println("###"+studentDao.deleteStudentByNameLike("김시퀀스"));
		System.out.println("---------findStudentByIdWithAddress----------");
		System.out.println("###"+studentDao.findStudentByIdWithAddress(1));
		System.out.println("---------findStudentNameList----------");
		System.out.println("### "+studentDao.findStudentNameList());
		System.out.println("---------findStudentNameById----------");
		System.out.println("### "+studentDao.findStudentNameById(1));
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("###"+studentDao.findStudentByIdMap(1));
		System.out.println("-------findAllStudentsMapList-------");
		System.out.println("###"+studentDao.findAllStudentsMapList());
		System.out.println("---------findStudentByIdWithCourses----------");
		System.out.println("###"+studentDao.findStudentByIdWithCourses(1));

		System.out.println("---------updateStudentParamMap(parameter Map)----");
		HashMap studentMap = new HashMap();
		studentMap.put("studId", 1);
		studentMap.put("name", "이맵맵");
		studentMap.put("email", "map@gmail.com");
		studentMap.put("dob", new Date());
		System.out.println("###"+studentDao.updateStudentParamMap(studentMap));
		
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)----");
		HashMap rangeMap = new HashMap();
		rangeMap.put("startNo", 1);
		rangeMap.put("endNo", 3);
		System.out.println("###"+studentDao.findStudentByIdRangeParamMap(rangeMap));
		
		System.out.println("---------findStudentByIdThreeParamMap(parameter Map)----");
		Student firstStudent = new Student(1);
		Student secondStudent = new Student(3);
		Student thirdStudent = new Student(5);
		HashMap threeStudentMap = new HashMap();
		threeStudentMap.put("first", firstStudent);
		threeStudentMap.put("second", secondStudent);
		threeStudentMap.put("third", thirdStudent);
		System.out.println("###"+studentDao.findStudentByIdThreeParamMap(threeStudentMap));
		*/
		
		
		
		/*
		System.out.println("------------findAllStudentsMap-------------");
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		*/
	}
}
