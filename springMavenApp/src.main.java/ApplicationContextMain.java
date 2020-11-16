

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) {
		/*
		 * ApplicationContext객체생성
		 *  - BeanFactory객체생성
		 *  - Spring Container객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"xxx.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		
		}
	}


















