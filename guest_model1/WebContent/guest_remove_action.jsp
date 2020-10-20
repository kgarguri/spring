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
    String findGuest = request.getParameter("guest_no");
    
	GuestService guestService = new GuestService();
	int delete_cnt = guestService.deleteGuest(Integer.parseInt(findGuest));
	if (delete_cnt == 1) {
		response.sendRedirect("guest_list.jsp");
	} else {
		response.sendRedirect("guest_error.jsp");
	}
	
%>
