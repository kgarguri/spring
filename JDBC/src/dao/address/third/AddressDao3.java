package dao.address.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.address.Address;

public class AddressDao3 {
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

	public int create(Address insertAddress) throws Exception {
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		String insertSql="insert into address values(address_no_seq.nextval,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1, insertAddress.getId());
		pstmt.setString(2, insertAddress.getName());
		pstmt.setString(3, insertAddress.getPhone());
		pstmt.setString(4, insertAddress.getAddress());
		int insertRowCount=pstmt.executeUpdate();
		return insertRowCount;
	}
	public int delete(int no) throws Exception {
		String deleteSql = "delete address where no =" + no;
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		stmt.close();
		con.close();
		return rowCount;
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
	public int update(Address updateAddress)  throws Exception{
		String updateSql=
"update address set id=?,name=?,phone=?,address=? where no=?";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(updateSql);
		pstmt.setString(1, updateAddress.getId());
		pstmt.setString(2, updateAddress.getName());
		pstmt.setString(3, updateAddress.getPhone());
		pstmt.setString(4, updateAddress.getAddress());
		pstmt.setInt(5, updateAddress.getNo());
		int updateRowCount=pstmt.executeUpdate();
		return updateRowCount;
	}
	
	public Address selectByNo(int fno) throws Exception {
		Address findAddress=null;
		String selectSql="select * from address where no=?";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(selectSql);
		pstmt.setInt(1,fno);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			findAddress=new Address(rs.getInt("no"),
									rs.getString("id"), 
									rs.getString("name"), 
									rs.getString("phone"), 
									rs.getString("address"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findAddress;
	}
	public ArrayList<Address> selectAll() throws Exception {
		ArrayList<Address> findAddressList=new ArrayList<Address>();
		String selectSql="select * from address";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt=con.prepareStatement(selectSql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			findAddressList.add(new Address(rs.getInt("no"),
									rs.getString("id"), 
									rs.getString("name"), 
									rs.getString("phone"), 
									rs.getString("address")));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findAddressList;
	}
}











