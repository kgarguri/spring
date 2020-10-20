package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyActionController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardpath = "";
		
		if(request.getMethod().equals("GET")){
			//response.sendRedirect("user_main.jsp");
			forwardpath = "redirect:user_main.do";
		}
		try{
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			User user=new User(userId,password,name,email);
			UserService userService=new UserService();
			int updateRowCount=userService.update(user);
			//response.sendRedirect("user_view.jsp?userId="+userId);
			forwardpath = "forward:/WEB-INF/views/user_view.jsp?userId=+userId";
			
		}catch(Exception e){
			e.printStackTrace();
			forwardpath = "redirect:user_error.jsp";
		}
		
		return forwardpath;
	}
}
