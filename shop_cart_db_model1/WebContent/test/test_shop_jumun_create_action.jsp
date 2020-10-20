<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@page import="com.itwill.shop.jumun.Jumun"%>
<%@page import="com.itwill.shop.jumun.JumunService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sUserId = "guard3";

	String buyType = request.getParameter("buyType");
	String p_noStr = request.getParameter("p_no");
	String p_qtyStr = request.getParameter("p_qty");
	
	JumunService jumunService=new JumunService();	
	ProductService productService=new ProductService();	
	
	if(buyType.equals("cart")){
		jumunService.create(sUserId);
		
		
		
	}else if(buyType.equals("direct")){
		Product product=productService.getProduct(Integer.parseInt(p_noStr));
		Jumun jumun=new Jumun(999,product.getP_name(),null,product.getP_price()*Integer.parseInt(p_qtyStr),sUserId);
		jumunService.create(sUserId, jumun,Integer.parseInt(p_noStr),Integer.parseInt(p_qtyStr));
	}	
	response.sendRedirect("shop_jumun_list.jsp");
	
	
%>