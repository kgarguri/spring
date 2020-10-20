package com.mybatis3.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.mybatis3.domain.Student;

public class StudentDaoDynamicSqlMain {

	public static void main(String[] args) throws Exception {
		StudentDaoDynamicSql studentDaoDynamicSql = new StudentDaoDynamicSql();

		Student findStudent = new Student();
		/*
		System.out.println("---------updateStudentDynamicSql---------");
		
		studentDaoDynamicSql.findStudents(findStudent);
		System.out.println("###"+studentDaoDynamicSql.findStudents(findStudent) );
		
		findStudent.setDob(new Date());
		System.out.println("###"+studentDaoDynamicSql.findStudents(findStudent) );
		
		
		findStudent.setStudId(1);
		findStudent.setName("이순일");
		findStudent.setEmail("11@gmail.com");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date dob = dateFormat.parse("2020/01/01");
		
		findStudent.setDob(dob);
		System.out.println("###"+studentDaoDynamicSql.findStudents(findStudent) );
		
		Student updateStudent = new Student();
		updateStudent.setStudId(2);
		updateStudent.setName("이순"+System.currentTimeMillis());
		updateStudent.setEmail(System.currentTimeMillis()+"@gmail.com");
		updateStudent.setDob(new Date());
		//studentDaoDynamicSql.updateStudentById(updateStudent);
		System.out.println("###"+studentDaoDynamicSql.updateStudentById(updateStudent) );
		*/
		//Student findStudentOrder = new Student();
		System.out.println("---------findStudentsOrder---------");
		System.out.println("###"+studentDaoDynamicSql.findStudentsOrderList("stud_id") );

	}
}
