package com.itwill.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserListController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardpath = "";
		/*
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("user_login_form.jsp");
			forwardpath = "redirect:user_login_form.do";
		} else {
			try {
				UserService userService=new UserService();
				ArrayList<User> userList=userService.findUserList();
				request.setAttribute("userList", userList);
				forwardpath = "forward:/WEB-INF/views/user_list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				forwardpath = "redirect:user_login_form.do";
			}
		}
		*/
		try {
			UserService userService=new UserService();
			ArrayList<User> userList=userService.findUserList();
			request.setAttribute("userList", userList);
			forwardpath = "forward:/WEB-INF/views/user_list.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardpath = "redirect:user_error.jsp";
		}
		return forwardpath;
	}
}
