package com.itwill1.bean.annotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args)throws Exception {
		/*
		 * ApplicationContext객체생성
		 *  - BeanFactory객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill1/bean/annotation/1.bean-create-annotation.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		
		System.out.println("---------scope [singleton]--------------");
		SingletoneScopeBean singletoneScopeBean1 = 
				 (SingletoneScopeBean)applicationContext.getBean("singletoneBean");
		SingletoneScopeBean singletoneScopeBean2 = 
				 (SingletoneScopeBean)applicationContext.getBean("singletoneBean");
		System.out.println(singletoneScopeBean1);
		System.out.println(singletoneScopeBean2);
		
		/* 자주 사용안함(prototype)
		System.out.println("---------scope [prototype]--------------");
		SingletoneScopeBean singletonScopeBean3=
				(SingletoneScopeBean)applicationContext.getBean("prototypeBean");
		SingletoneScopeBean singletonScopeBean4=
				(SingletoneScopeBean)applicationContext.getBean("prototypeBean");
		System.out.println(singletonScopeBean3);
		System.out.println(singletonScopeBean4);
		*/
		System.out.println("---------init-method ,destroy-method--------------");
		DisposableBean  context=(DisposableBean)applicationContext;
		context.destroy();
		
		
		
		
		}
	}


















