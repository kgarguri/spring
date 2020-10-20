<%@page import="com.itwill.shop.jumun.JumunDetail"%>
<%@page import="com.itwill.shop.jumun.Jumun"%>
<%@page import="com.itwill.shop.jumun.JumunService"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String j_noStr=request.getParameter("j_no");
	if(j_noStr==null|| j_noStr.equals("")){
		j_noStr="1";
	}
	JumunService jumunService=new JumunService();
    Jumun jumun=jumunService.detail("guard1", Integer.parseInt(j_noStr));

%>

<%=jumun%><br/>
<br/>
<%for(JumunDetail jumunDetail:jumun.getJumunDetailList()){ %>
	<%=jumunDetail.toString() %><br/>
	<%=jumunDetail.getProduct()%><br/>
	
<%}%>