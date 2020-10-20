package Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressSelectByNoMain {

	public static void main(String[] args) throws Exception {
		/**************설정파일로부터 DB접속정보얻기**************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython7";
		String password="javapython7";
		
		String selectSql = "select no, id, name, phone, address from address where no=10";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();

		stmt.executeQuery(selectSql);

		ResultSet rs = stmt.executeQuery(selectSql);
		
		//boolean isExist = rs.next();
		
		while (rs.next()) {
			/*
			 DB number   --> java int, double
			 DB varchar2 --> java String
			 DB date     --> java Date 
			 XXX var = rs.getXXX(칼럼이름) 
			 */
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		//rs.getInt("no");
		rs.close();
		stmt.close();
		con.close();
		

	}

}
