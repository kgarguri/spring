package com.itwill.user.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext객체생성
		 *  - BeanFactory객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill/user/annotation/user-annotation.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		
		UserServiceImplAnnotation userServiceImplAnnotation =
				    (UserServiceImplAnnotation)applicationContext.getBean("userServiceImplAnnotation");
		userServiceImplAnnotation.findUser("11");
		userServiceImplAnnotation.findUserList();
		
		}
}


















