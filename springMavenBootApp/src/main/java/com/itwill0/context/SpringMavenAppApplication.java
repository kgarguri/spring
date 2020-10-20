package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMavenAppApplication {

	public static void main(String[] args) {
		
		/************spring이 제어를한다.[IOC]**********/
		System.out.println("------------spring 초기화 시작--------------------------------------");
		ApplicationContext applicationContext=
				SpringApplication.run(SpringMavenAppApplication.class, args);
		System.out.println("------------spring 초기화 끝--------------------------------------");
		
		System.out.println("ApplicationContext[BeanFactory객체,SpringContainer객체]:"+applicationContext);
		System.out.println("--------------------------------------------------");
		
		/************************************************/
		ProductService productService=(ProductService)applicationContext.getBean("productService");
		productService.list();

		/************개발자님이 제어를한다 **********
		ProductDao productDao=new ProductDao();
		ProductService productService=new ProductService();
		productService.setProductDao(productDao);
		productService.list();
		********************************************/
	}

}
