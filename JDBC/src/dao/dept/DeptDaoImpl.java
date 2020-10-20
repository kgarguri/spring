package dao.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.address.Address;
import dao.common.ConnectionFactory;

public class DeptDaoImpl implements DeptDao{

	@Override
	public int insert(Dept department) throws Exception {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.INSERT);
		
		pstmt.setInt(1, department.getDeptno());
		pstmt.setString(2,department.getDname());
		pstmt.setString(3, department.getLoc());
		
		int insertRowcount = pstmt.executeUpdate();
		
		pstmt.close();
		ConnectionFactory.releaseConnection(con);

		return insertRowcount;
	}

	@Override
	public Dept selectByNo(int deptno) throws Exception {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTByNo);
		
		pstmt.setInt(1, deptno);
		ResultSet rs = pstmt.executeQuery();
		
		Dept findDept = null;
		while (rs.next()) {
			findDept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getNString("loc"));
		}
		
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return findDept;
	}

	@Override
	public List selectByAll() throws Exception {
		
		ArrayList<Dept> FindList = new ArrayList<Dept>();
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTAll);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			FindList.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return FindList;
	}

}
