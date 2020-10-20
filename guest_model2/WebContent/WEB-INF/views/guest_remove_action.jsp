<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1.파라메타바끼 (quest_no)
	2.GuestService.deleteGuest()메쏘드호출
	3.성공 -->guest_list.jsp redirection
      실패 -->guest_error.jsp redirection
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_main.do");
		return;
	}
    try{
	    String guest_noStr = request.getParameter("guest_no");
	    GuestService guestService=new GuestService();
	    guestService.deleteGuest(Integer.parseInt(guest_noStr));
	    response.sendRedirect("guest_list.do");
    }catch(Exception e){
    	e.printStackTrace();
    	response.sendRedirect("guest_error.do");
    }
%>
