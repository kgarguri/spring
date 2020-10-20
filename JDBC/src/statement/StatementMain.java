package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Properties;

import javax.print.attribute.standard.PrinterStateReason;

import Basic.JDBCFlowMain;

public class StatementMain {

	public static void main(String[] args) throws Exception{
		Properties dbProperties = new Properties();
		dbProperties.load(StatementMain.class.getResourceAsStream("../Basic/db.properties"));
		
		String driverClass = dbProperties.getProperty("driverClass");
		String url = dbProperties.getProperty("url");
		String user = dbProperties.getProperty("user");
		String password = dbProperties.getProperty("password");
		String selectSql="select * from emp";
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		/*
		 * ResultSet의 행의수를 제한
		 *  setMaxRows(5) : 5개 row 반환
		 *  setMaxRows(0) : 제힌이 없다.
		 */
		stmt.setMaxRows(5);
		
		ResultSet rs=stmt.executeQuery(selectSql);
		
		while(rs.next()) {
			System.out.println(rs.getInt("EMPNO")+"\t"+
								rs.getString("ENAME")+"\t"+
								rs.getString("JOB")+"\t"+
								rs.getDouble("SAL"));
		}
		rs.close();
		
		String selectSql2="select * from emp order by sal desc";
		ResultSet rs2 = stmt.executeQuery(selectSql2);
		System.out.println("-----------------sal desc------------");
		while(rs2.next()) {
			System.out.println(rs2.getInt("EMPNO")+"\t"+
								rs2.getString("ENAME")+"\t"+
								rs2.getString("JOB")+"\t"+
								rs2.getDouble("SAL"));
		}
		rs2.close();
		
		/*
		이름       널?       유형           
		-------- -------- ------------ 
		EMPNO    NOT NULL NUMBER(4)    
		ENAME             VARCHAR2(10) 
		JOB               VARCHAR2(9)  
		MGR               NUMBER(4)    
		HIREDATE          DATE         
		SAL               NUMBER(7,2)  
		COMM              NUMBER(7,2)  
		DEPTNO            NUMBER(2) 
		 */
		String insertSql="insert into emp "
				+ "values(9999,'JAMES','MANAGER',null,"
				+ "to_date('2020/05/20','YYYY/MM/DD'),6000,null,30)";
		String updateSql="update emp set sal=6789.89 where empno >=7369 and empno<=7600";
		String deleteSql="delete emp where empno=8888";
		
		try {
			int insertRowCount = stmt.executeUpdate(insertSql);
			System.out.println(insertRowCount+ " 행 insert..");
		}catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("catch >>> 이미존재하는 사번입니다..");
			e.printStackTrace();
		}
		int updateRowCount = stmt.executeUpdate(updateSql);
		System.out.println(updateRowCount+ " 행 update..");
		int deleteRowCount = stmt.executeUpdate(deleteSql);
		System.out.println(deleteRowCount+ " 행 delete..");
		
		/*
		 * 행의수제한제거
		 */
		System.out.println("-------setMaxRows(0)[행의수제한제거]-------");
		stmt.setMaxRows(0);
		ResultSet rs3 = stmt.executeQuery(selectSql2);
		while (rs3.next()) {
			System.out.println(rs3.getInt("EMPNO")+"\t"+
					rs3.getString("ENAME")+"\t"+
					rs3.getString("JOB")+"\t"+
					rs3.getDouble("SAL"));
		}
		
		rs3.close();
		stmt.close();
		con.close();
		
	}

}
