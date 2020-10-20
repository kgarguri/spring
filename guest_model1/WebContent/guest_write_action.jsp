<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	/*
	0. GET방식이면 guest_write_form.jsp redirection
	
	0 . 요청객체 인코딩설정
	1 . 파라메타받기 
		- 5개받기
	2 . Service객체 메쏘드호출(업무처리)
		- GuestService.insertGuest()
	3 . 요청클라이언트로 응답 
		- 성공:guest_main.jsp 로 redirection
		- 실패:guest_error.jsp로 redirection
	*/
	
	if(request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("guest_write_form.jsp");	
	}
	
	//int guest_no = Integer.parseInt(request.getParameter("guest_no"));
	String guest_name = request.getParameter("guest_name");
	//String guest_date = request.getParameter("guest_date");
	String guest_email = request.getParameter("guest_email");
	String guest_homepage = request.getParameter("guest_homepage");
	String guest_title = request.getParameter("guest_title");
	String guest_content = request.getParameter("guest_content");
	
	GuestService guestService = new GuestService();
	int inserRowCount = guestService.insertGuest(new Guest(guest_name,guest_email,
			            guest_homepage,guest_title, guest_content));
	
	if(inserRowCount != 0) {
		response.sendRedirect("guest_main.jsp");
	} else {
		response.sendRedirect("guest_error.jsp");
	}
	%>
