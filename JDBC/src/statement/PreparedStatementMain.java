package statement;
/*
<<PreparedStatement>>
	1. sql문작성
	    - ?(파라메타) 를 사용해서 나중에 외부에서 데이타(리터럴)를 받을수있게한다.
	      ex> insert into emp(empno,ename,job,manager,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)	
	    - 테이블이름,컬럼이름등은 ? 를 사용해서 외부에서 입력받을수없다.
	      ex> select * from ? 
	          select ?,? from emp    
	2. PreparedStatement 객체생성시 인자로 sql문을 넣어서생성한다
	   ex> PreparedStatement pstmt = con.prepareStatement(sql);
	3. 생성된 PreparedStatement 객체에 파라메타를 setting 한다
	    - sql 좌측 ? 부터 1,2,3...
	   ex> 	pstmt.setInt(1,1234);              
	 	   	pstmt.setString(2,"KIM");              
	   		pstmt.setString(3,"MANAGER");              
	  		pstmt.setInt(4,7839);              
	   		pstmt.setDate(5,new Date());              
	   		pstmt.setDouble(6,1000.12);              
	   		pstmt.setInt(7,0);              
	   		pstmt.setInt(8,10);              
	 4.  실행
	    - 실행시 sql문을 인자로 넣지안는다.
	    ex> pstmt.executeUpdate();         
	        pstmt.executeQuery();         
*/

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementMain {

	public static void main(String[] args) throws Exception{
		Properties dbProperties=new Properties();
		dbProperties.load(
				StatementMain.class.getResourceAsStream("../basic/db.properties"));
		
		String driverClass=dbProperties.getProperty("driverClass");
		String url=dbProperties.getProperty("url");
		String user=dbProperties.getProperty("user");
		String password=dbProperties.getProperty("password");
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		
		int startSal=0;
		int endSal=9000;
		String job="CLERK";
		
		System.out.println("----------SELECT(Statement)-------");
		String selectSql1=
				"select * from emp where sal >= "
						+startSal+" and sal<= "
						+endSal+" and job='"
						+job+"'";
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery(selectSql1);
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String jobs=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
			
		}
		rs.close();
		stmt.close();
		System.out.println("----------SELECT(PreparedStatement)-------");
		String selectSql2="select * from emp where sal>=? and sal<=? and job=?";
		PreparedStatement pstmt=con.prepareStatement(selectSql2);
		System.out.println("--------PreparedStatement반복-----");
		pstmt.setInt(1, startSal);
		pstmt.setInt(2, endSal);
		pstmt.setString(3, job);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String jobs=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
			
		}
		System.out.println("--------PreparedStatement반복-----");
		startSal=100;
		endSal=5000;
		job="SALESMAN";
		
		pstmt.setInt(1, startSal);
		pstmt.setInt(2, endSal);
		pstmt.setString(3, job);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String jobs=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
			
		}
		rs.close();
		pstmt.close();
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
		System.out.println("----------INSERT(PreparedStatement)-------");
		String insertSql1="insert into emp values(?,?,?,?,?,?,?,?)";
		/*
		pstmt = con.prepareStatement(insertSql1);
		pstmt.setInt(1, 1000);
		pstmt.setString(2,"ALICE");
		pstmt.setString(3,"CLERK");
		pstmt.setInt(4,7369);
		pstmt.setDate(5, new Date(System.currentTimeMillis()));
		pstmt.setDouble(6, 561.93);
		pstmt.setDouble(7, 30.67);
		pstmt.setInt(8, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+" 행 insert...");
		*/
		
		String insertSql2="insert into emp values(?,?,?,?,sysdate,?,?,?)";
		/*
		pstmt = con.prepareStatement(insertSql2);
		pstmt.setInt(1, 2000);
		pstmt.setString(2,"TOM");
		pstmt.setString(3,"MANAGER");
		pstmt.setInt(4,7369);
		pstmt.setDouble(5, 561.93);
		pstmt.setDouble(6, 30.67);
		pstmt.setInt(7, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+" 행 insert...");
		*/
		String insertSql3=
		"insert into emp values(?,?,?,?,to_date(?,?),?,?,?)";
		/*
		pstmt = con.prepareStatement(insertSql3);
		pstmt.setInt(1, 3000);
		pstmt.setString(2,"MARK");
		pstmt.setString(3,"SALESMAN");
		pstmt.setInt(4,7369);
		pstmt.setString(5, "2019/01/12");
		pstmt.setString(6, "YYYY/MM/DD");
		pstmt.setDouble(7, 561.93);
		pstmt.setDouble(8, 30.67);
		pstmt.setInt(9, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+" 행 insert...");
		*/
		
		String insertSql4=
				"insert into emp values(?,?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(insertSql4);
		
		pstmt.setInt(1, 5907);
		pstmt.setString(2,"MARK");
		pstmt.setString(3,"SALESMAN");
		pstmt.setInt(4,7369);
		/*********Date객체생성********/
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(sdf.parse("2018-05-01").getTime());
		
		pstmt.setDate(5, date);
		pstmt.setDouble(6, 561.93);
		pstmt.setDouble(7, 30.67);
		pstmt.setInt(8, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+" 행 insert...");
		
		pstmt.setInt(1, 5908);
		
		insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+" 행 insert...");

		pstmt.clearParameters();
	}

}

