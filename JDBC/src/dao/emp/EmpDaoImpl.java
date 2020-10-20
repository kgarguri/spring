package dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.common.ConnectionFactory;



public class EmpDaoImpl implements EmpDao {

	@Override
	public int insert(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int empno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Emp findByEmpno(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Emp> findByDeptno(int deptno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// 사원정보(부서정보포함) 한개 반환
	@Override
	public HashMap findEmpnoWithDept(int no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(EmpSQL.SELECT_EMPNO_WITHDEPT);
		pstmt.setInt(1, no);
		/*
		 * select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc from emp e left outer join dept d on e.deptno = d.deptno
		 */
		ResultSet rs = pstmt.executeQuery();
		HashMap<String, Object> rowMap = new HashMap<String, Object>();
		if (rs.next()) {	
			rowMap.put("EMPNO", rs.getInt("EMPNO"));
			rowMap.put("ENAME", rs.getString("ENAME"));
			rowMap.put("JOB", rs.getString("JOB"));
			rowMap.put("MGR", rs.getInt("MGR"));
			rowMap.put("HIREDATE", rs.getDate("HIREDATE"));
			rowMap.put("SAL", rs.getDouble("SAL"));
			rowMap.put("COMM", rs.getInt("COMM"));
			rowMap.put("DEPTNO", rs.getInt("DEPTNO"));
			rowMap.put("DNAME", rs.getString("DNAME"));
			rowMap.put("LOC", rs.getString("LOC"));
		}	
		return rowMap;
	}
	//사원정보(부서정보포함) 전체목록 반환
	@Override
	public ArrayList<HashMap> findEmpsWithDept() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(EmpSQL.SELECT_ALLEMP_WITHDEPT);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<HashMap> rowMapList = new ArrayList<HashMap>();
		while (rs.next()) {	
			HashMap<String, Object> rowMap = new HashMap<String, Object>();
			rowMap.put("EMPNO", rs.getInt("EMPNO"));
			rowMap.put("ENAME", rs.getString("ENAME"));
			rowMap.put("JOB", rs.getString("JOB"));
			rowMap.put("MGR", rs.getInt("MGR"));
			rowMap.put("HIREDATE", rs.getDate("HIREDATE"));
			rowMap.put("SAL", rs.getDouble("SAL"));
			rowMap.put("COMM", rs.getInt("COMM"));
			rowMap.put("DEPTNO", rs.getInt("DEPTNO"));
			rowMap.put("DNAME", rs.getString("DNAME"));
			rowMap.put("LOC", rs.getString("LOC"));
			rowMapList.add(rowMap);
		}	
		return rowMapList;
	}
}
