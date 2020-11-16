package com.itwill2.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class ApplicationContextBeanDependencyMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext객체생성
		 *  - BeanFactory객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill2/di/2.bean-dependency.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		System.out.println("---------Constructor Injection---------");
		UserService userService=(UserService)applicationContext.getBean("userService");
		userService.create(null);
		userService.findUser("");
		User constructorUser1=(User)applicationContext.getBean("constructorUser1");
		System.out.println("###"+constructorUser1);
		System.out.println("----------Setter Injection--------");
		UserService setUserService=(UserService)applicationContext.getBean("setUserService");
		setUserService.create(null);
		setUserService.findUser("");
		User setUser2=(User)applicationContext.getBean("setUser2");
		System.out.println("###"+setUser2);
		
		
		}
	}


















