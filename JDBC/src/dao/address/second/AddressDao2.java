package dao.address.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao2 {
	/************** DB접속정보 **************/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user = "javapython31";
	String password = "javapython31";

	public void create(String id, String name, String phone, String address) throws Exception {

		String insertSql = "insert into address values(address_no_seq.nextval,'" + id + "','" + name + "','" + phone
				+ "','" + address + "')";
		System.out.println("insertSql:" + insertSql);

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);

		System.out.println(rowCount + " 행 insert..");
		stmt.close();
		con.close();
	}

	public void delete(int no) throws Exception {

		String deleteSql = "delete address where no =" + no;
		System.out.println("deleteSql:" + deleteSql);

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(rowCount + " 행 delete..");

		stmt.close();
		con.close();
	}

	public void update(int no, String id, String name, String phone, String address) throws Exception {

		String updateSql = "update address set id='" + id + "',name='" + name + "',phone='" + phone + "',address='"
				+ address + "' where no=" + no;
		System.out.println("updateSql:" + updateSql);

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);

		System.out.println(rowCount + " 행 update..");
		stmt.close();
		con.close();

	}

	public void selectByNo(int fno) throws Exception {

		String selectSql = "select no,id,name,phone,address from address where no=" + fno;
		System.out.println("selectSql:" + selectSql);

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + id + "\t" + name + "\t" + phone + "\t" + address);
		}
		rs.close();
		stmt.close();
		con.close();
	}

	public void selectAll() throws Exception {

		String selectSql = "select no,id,name,phone,address from address";
		System.out.println("selectSql:" + selectSql);

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);

		while (rs.next()) {
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + id + "\t" + name + "\t" + phone + "\t" + address);
		}
		rs.close();
		stmt.close();
		con.close();

	}
}
