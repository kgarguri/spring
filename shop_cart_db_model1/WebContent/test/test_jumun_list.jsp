<%@page import="com.itwill.shop.jumun.Jumun"%>
<%@page import="com.itwill.shop.jumun.JumunService"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JumunService jumunService=new JumunService();
	ArrayList<Jumun> jumunList =jumunService.list("guard1");
%>

<%for(Jumun j:jumunList){ %>
	<a href='test_jumun_detail.jsp?j_no=<%=j.getJ_no()%>'><%=j %></a><br/>
<%}%>
    
