<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>	

<%
	if(request.getMethod().equalsIgnoreCase("GET")) {
		//response.sendRedirect("");
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
		return;
	}


	//장바구니에서 원하는 품목을 삭제시킨 후 view_cart.jsp 로 sendRedirect 시킨다..
	
	String cart_itemno = request.getParameter("cart_itemno");
	CartService cartService = new CartService();
	cartService.deleteCartItem(Integer.parseInt(cart_itemno));
	response.sendRedirect("shop_view_cart.jsp");
%>
