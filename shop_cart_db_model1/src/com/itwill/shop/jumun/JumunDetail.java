package com.itwill.shop.jumun;

import com.itwill.shop.product.Product;


public class JumunDetail {
	/*
	이름           널?       유형            
	------------ -------- ------------- 
	JD_NO        NOT NULL NUMBER(10)    
	JD_QTY                NUMBER(10)    
	JD_PNAME              VARCHAR2(100) 
	JD_TOT_PRICE          NUMBER(10)    
	J_NO                  NUMBER(10)    
	P_NO                  NUMBER(10)    
	*/
	private int jd_no;
	private int jd_qty;
	private String jd_pname;
	private int jd_tot_price;
	private int j_no;
	private int p_no;
	
	private Product product;
	
	public JumunDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	public JumunDetail(int jd_no, int jd_qty, String jd_pname, int jd_tot_price, int j_no, int p_no, Product product) {
		super();
		this.jd_no = jd_no;
		this.jd_qty = jd_qty;
		this.jd_pname = jd_pname;
		this.jd_tot_price = jd_tot_price;
		this.j_no = j_no;
		this.p_no = p_no;
		this.product = product;
	}


	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "JumunDetail [jd_no=" + jd_no + ", jd_qty=" + jd_qty + ", jd_pname=" + jd_pname + ", jd_tot_price="
				+ jd_tot_price + ", j_no=" + j_no + ", p_no=" + p_no + ", product=" + product + "]";
	}
	public int getJd_no() {
		return jd_no;
	}
	public void setJd_no(int jd_no) {
		this.jd_no = jd_no;
	}
	public int getJd_qty() {
		return jd_qty;
	}
	public void setJd_qty(int jd_qty) {
		this.jd_qty = jd_qty;
	}
	public String getJd_pname() {
		return jd_pname;
	}
	public void setJd_pname(String jd_pname) {
		this.jd_pname = jd_pname;
	}
	public int getJd_tot_price() {
		return jd_tot_price;
	}
	public void setJd_tot_price(int jd_tot_price) {
		this.jd_tot_price = jd_tot_price;
	}
	public int getJ_no() {
		return j_no;
	}
	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	
}
