package com.mybatis3.dao;

public class TutorDaoMain {

	public static void main(String[] args) {
		TutorDao tutorDao=new TutorDao();
		/*
		System.out.println("----------findTutorById--------");

		System.out.println("----------selectTutorWithAddressAndCourses--------");

		System.out.println("-------------nestedSelectTutorById----------------");
		*/
		System.out.println("----------findTutorByIdWithCoursesAndAddress--------");
		System.out.println("### "+tutorDao.findTutorByIdWithCoursesAndAddress(1));
	}

}
