<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>

<%
	//장바구니에 있는 모든개를지우고  view_cart.jsp 로 redirection...
	CartService cartService = new CartService();
 	cartService.deleteCart(sUserId);
	response.sendRedirect("shop_view_cart.jsp");
%>