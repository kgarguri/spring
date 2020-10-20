package resultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.common.ConnectionFactory;

public class ScrollableResultsetMain {

	public static void main(String[] args) throws Exception{
		String selectSql="select * from emp order by empno asc";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(selectSql,
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=pstmt.executeQuery();
		/*
		 * Cursor를 자유롭게움직일수있는 ResultSet생성
		 */
		System.out.println("-----------rs.next()-----------");
		while(rs.next()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		}
		System.out.println("-----------rs.previous()-----------");
		while(rs.previous()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		}
		System.out.println("-----------rs.first()-----------");
		rs.first();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("-----------rs.last()-----------");
		rs.last();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		rs.first();
		int rowCount=rs.getRow();
		System.out.println("rowCount:"+rowCount);
		
		System.out.println("-----------rs.beforeFirst()-----------");
		rs.beforeFirst();
		//System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		rs.next();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));		
		
	}

}