package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public class UserLoginActionController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardpath = "";
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("user_login_form.jsp");
			forwardpath = "redirect:user_login_form.do";
			
		} else {
			String userId=null;
			String password=null;
			try{
				userId=request.getParameter("userId");
				password=request.getParameter("password");
				UserService userService=new UserService();
				User loginUser = userService.login(userId, password);
				//session.setAttribute("sUserId", userId);
				//session.setAttribute("sUser", loginUser);
				//response.sendRedirect("user_main.jsp");
				forwardpath = "redirect:user_main.do";
			}catch(UserNotFoundException e){
				/*********************case3[forward]****************/
				request.setAttribute("msg1", e.getMessage());
				request.setAttribute("fuser",new User(userId,password,"",""));
				
				//RequestDispatcher rd=
					//	request.getRequestDispatcher("user_login_form.jsp");
				//rd.forward(request, response);
				forwardpath = "forward:user_login_form.do";
	
			}catch(PasswordMismatchException e){
				
				request.setAttribute("msg2", e.getMessage());
				request.setAttribute("fuser",new User(userId,password,"",""));
				
				//RequestDispatcher rd=
						//request.getRequestDispatcher("user_login_form.jsp");
				//rd.forward(request, response);
				forwardpath = "forward:user_login_form.do";
	
			}catch(Exception e){
				e.printStackTrace();
				//response.sendRedirect("user_error.jsp");
				forwardpath = "redirect:user_login_form.do";
			}
		
		}
		return forwardpath;
	}
}
