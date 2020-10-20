package com.itwill.shop.jumun;

import java.sql.Date;
import java.util.ArrayList;

import com.itwill.user.User;

public class Jumun {
	/*
	이름      널?       유형            
	------- -------- ------------- 
	J_NO    NOT NULL NUMBER(10)    
	J_DESC           VARCHAR2(100) 
	J_DATE           DATE          
	J_PRICE          NUMBER(10)    
	USERID           VARCHAR2(100) 
	 */
	private int j_no;
	private String j_desc;
	private Date j_date;
	private int j_price;
	private String userId;

	/*
	 * private User user;
	 */
	private ArrayList<JumunDetail> jumunDetailList;
	
	
	public Jumun() {
		
	}
	public Jumun(int j_no, String j_desc, Date j_date, int j_price, String userId) {
		super();
		this.j_no = j_no;
		this.j_desc = j_desc;
		this.j_date = j_date;
		this.j_price = j_price;
		this.userId = userId;
		this.jumunDetailList=new ArrayList<JumunDetail>();
	}
	
	public Jumun(int j_no, String j_desc, Date j_date, int j_price, String userId,
			ArrayList<JumunDetail> jumunDetailList) {
		super();
		this.j_no = j_no;
		this.j_desc = j_desc;
		this.j_date = j_date;
		this.j_price = j_price;
		this.userId = userId;
		this.jumunDetailList = jumunDetailList;
	}
	public ArrayList<JumunDetail> getJumunDetailList() {
		return jumunDetailList;
	}
	public void setJumunDetailList(ArrayList<JumunDetail> jumunDetailList) {
		this.jumunDetailList = jumunDetailList;
	}
	public int getJ_no() {
		return j_no;
	}

	
	public void setJ_no(int j_no) {
		this.j_no = j_no;
	}

	public String getJ_desc() {
		return j_desc;
	}

	public void setJ_desc(String j_desc) {
		this.j_desc = j_desc;
	}

	public Date getJ_date() {
		return j_date;
	}

	public void setJ_date(Date j_date) {
		this.j_date = j_date;
	}

	public int getJ_price() {
		return j_price;
	}

	public void setJ_price(int j_price) {
		this.j_price = j_price;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Jumun [j_no=" + j_no + ", j_desc=" + j_desc + ", j_date=" + j_date + ", j_price=" + j_price
				+ ", userId=" + userId + "]";
	}
	
}
