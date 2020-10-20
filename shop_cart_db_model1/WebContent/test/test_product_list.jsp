<%@page import="com.itwill.shop.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductService productService=new ProductService();
	ArrayList<Product> productList =productService.getProductList();
%>

<%for(Product p:productList){ %>
	<%=p %><br/>
<%}%>
    
