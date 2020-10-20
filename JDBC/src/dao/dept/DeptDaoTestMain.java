package dao.dept;

import java.util.ArrayList;

import dao.address.Address;

public class DeptDaoTestMain {

	public static void main(String[] args) throws Exception {
		
	
		DeptDao deptDao=new DeptDaoImpl();
		
		Dept department = new Dept(51, "MARKETING22", "PARIS22");
		int updateRowCount= deptDao.insert(department);
		
		System.out.println("create:"+updateRowCount);
		
		int deptno = 10;
		Dept findDept = deptDao.selectByNo(deptno);
		
		System.out.println(findDept.getDeptno() +"\t"+findDept.getDname()+"\t"+findDept.getLoc());

		ArrayList<Dept> deptList = (ArrayList<Dept>) deptDao.selectByAll();//

		for (int i = 0; i < deptList.size(); i++) {
			Dept deptListAll = deptList.get(i);

			int no = deptListAll.getDeptno();
			String dname = deptListAll.getDname();
			String loc = deptListAll.getLoc();
			
			System.out.println(no +"\t"+dname+"\t"+loc);
		
		
	}
	}
}
