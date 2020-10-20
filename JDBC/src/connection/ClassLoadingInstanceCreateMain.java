package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ClassLoadingInstanceCreateMain {

	public static void main(String[] args) throws Exception {
		/*
		Driver strongDriver=new StrongDriver();
		DriverManager.registerDriver(strongDriver);
		Connection con=DriverManager.getConnection("","","");
		*/		
		
		/*
		Class driverClazz = Class.forName("connection.StrongDriver");
		Driver driver = (Driver)driverClazz.newInstance();//기본생성자 호출
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection("","","");
		*/
		Class.forName("connection.StrongDriver");	
		//Connection con=DriverManager.getConnection("","","");
		

	}

}
