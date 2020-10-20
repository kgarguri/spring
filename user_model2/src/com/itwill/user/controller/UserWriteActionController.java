package com.itwill.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;

public class UserWriteActionController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath = "";
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("user_write_form.do");
			forwardPath = "redirect:user_write_form.do";
		
		} else {
		
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			User newUser=null;
			try{
				newUser=new User(userId,password,name,email);
				UserService userService=new UserService();
				int rowCount = userService.create(newUser);
				forwardPath = "redirect:user_login_form.do";
				//response.sendRedirect("user_login_form.do");
			}catch(ExistedUserException e){
	
				request.setAttribute("fuser", newUser);
				request.setAttribute("msg", e.getMessage());
				//RequestDispatcher rd=
					//	request.getRequestDispatcher("user_write_form.do");
				//rd.forward(request, response);
				//forwardPath = "forward:/WEB-INF/views/user_write_form.do";
				forwardPath = "forward:user_write_form.do";
	
			}catch(Exception e){
				e.printStackTrace();
				//response.sendRedirect("user_error.jsp");
				forwardPath = "redirect:user_error.jsp";
			}
		
		}
		
		return forwardPath;
	}
}
