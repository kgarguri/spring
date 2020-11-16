package com.itwill2.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class ApplicationContextBeanDependencyCollectionMapMain {

	public static void main(String[] args) throws Exception{
		/*
		 * ApplicationContext객체생성
		 *  - BeanFactory객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill2/di/2.bean-dependency-collection-map.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		CollectionMapInjectionBean cmibean=
				(CollectionMapInjectionBean)
				applicationContext.getBean("collectionMapInjectionBean");
		System.out.println("###");
		cmibean.print();
		
		}
	}


















