<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.cart.CartItemDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
    String sUserId = "guard1";
	CartService cartService = new CartService();
	cartService.getCartItemList(sUserId);
	//cartService.getCartItemList("guard1");

	//ArrayList<CartItemDto> cartItemDtoList = (ArrayList<CartItemDto>)request.getAttribute("cartItemDtoList");
	ArrayList<CartItemDto> cartItemList = cartService.getCartItemList(sUserId);
%>

<%=cartItemList%>