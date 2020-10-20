
<%@page import="com.itwill.shop.cart.CartItemDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.cart.CartDao"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>	

<%
	/*
	//장바구니에 개를담고 view_cart.jsp 로 redirection...
	
	if (request.getMethod().equalsIgnoreCase("GET")) {
	    response.sendRedirect("shop_main.jsp");
		return;
	}
	
	String p_no = request.getParameter("p_no");
	String cart_qty = request.getParameter("cart_qty");

	CartService cartService = new CartService();
	ArrayList<CartItemDto> cartItemDtoList = new ArrayList();	
	cartItemDtoList = null;
	
	
	try {
		int insertRowCount = cartService.add(sUserId, Integer.parseInt(p_no), Integer.parseInt(cart_qty));
			
		out.println("insertRowCount ==>  "+insertRowCount);
		
		
		
		if (insertRowCount != 0) {
			cartItemDtoList = cartService.getCartItemList(sUserId);

			request.setAttribute("cartItemDtoList", cartItemDtoList);
			//request.setAttribute("p_no", p_no);
			
			RequestDispatcher rd = request.getRequestDispatcher("shop_view_cart.jsp");
			rd.forward(request, response);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return;
	}
	*/
	
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("shop_main.jsp");
		return;
	}
	/*
	파라메타받기(cart_qty,p_no)
	*/
	String cart_qtyStr=request.getParameter("cart_qty");
	String p_noStr=request.getParameter("p_no");
	CartService cartService=new CartService();
	cartService.add(sUserId,Integer.parseInt(p_noStr), Integer.parseInt(cart_qtyStr));
	//장바구니에 개를담고 view_cart.jsp 로 redirection...
	response.sendRedirect("shop_view_cart.jsp");
	
	
	
%>



