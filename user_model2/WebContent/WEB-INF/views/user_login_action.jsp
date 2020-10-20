<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.exception.PasswordMismatchException"%>
<%@page import="com.itwill.user.exception.UserNotFoundException"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	String userId=null;
	String password=null;
	try{
		userId=request.getParameter("userId");
		password=request.getParameter("password");
		UserService userService=new UserService();
		User loginUser = userService.login(userId, password);
		session.setAttribute("sUserId", userId);
		session.setAttribute("sUser", loginUser);
		response.sendRedirect("user_main.jsp");
	}catch(UserNotFoundException e){
		/*********************case3[forward]****************/
		request.setAttribute("msg1", e.getMessage());
		request.setAttribute("fuser",new User(userId,password,"",""));
		
		RequestDispatcher rd=
				request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		/***********************************/
		/***************case1[redirect]****************
		response.sendRedirect("user_login_form.jsp");
		************************************/
		/*****************case2[정상응답]**********************
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		********************************************/
		
	}catch(PasswordMismatchException e){
		
		request.setAttribute("msg2", e.getMessage());
		request.setAttribute("fuser",new User(userId,password,"",""));
		
		RequestDispatcher rd=
				request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("user_login_form.jsp");
		
		/*****************case2[정상응답]**********************
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		********************************************/
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
--%>








