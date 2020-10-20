<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	
	/*
	1.파라메타바끼
	2.GuestService.updateGuest()메쏘드호출
	3.성공 -->guest_view.jsp?guest_no=67 redirection
	  실패-->guest_error.jsp redirection
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
	try{
		request.setCharacterEncoding("UTF-8");
		String guest_noStr=request.getParameter("guest_no");
		String guest_name=request.getParameter("guest_name");
		String guest_email=request.getParameter("guest_email");
		String guest_homepage=request.getParameter("guest_homepage");
		String guest_title=request.getParameter("guest_title");
		String guest_content=request.getParameter("guest_content");
		GuestService guestService=new GuestService();
		int updateRowCount=
				guestService.updateGuest(
							new Guest(Integer.parseInt(guest_noStr),
								guest_name,null,
								guest_email,guest_homepage,
								guest_title,guest_content));
		response.sendRedirect("guest_view.do?guest_no="+guest_noStr);
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("guest_error.do");
	}
	
%>

