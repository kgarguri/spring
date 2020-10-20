package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserRemoveActionController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardpath = "";
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("user_main.jsp");
			forwardpath = "rediect:user_main.do";
		}
		try{
			String userId=request.getParameter("userId");
			
			//String sUserId=(String)session.getAttribute("sUserId");
			//String sUserId = request.setAttribute("sUserId", fuser);
			User fuser=(User)request.getAttribute("fuser");
			
			UserService userService=new UserService();
			int removeRowCount=userService.remove(userId);
			
			//if(userId.equals(sUserId)){
			if(userId.equals(fuser.getUserId())){
				//로그인 한사람일경우 로그아웃
				//response.sendRedirect("user_logout_action.jsp");
				forwardpath = "rediret:user_logout_action.jsp";
			}else{
				forwardpath = "forward:/WEB-INF/views/user_list.do";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			forwardpath = "redirect:user_error.jsp";
		}	
		
		return forwardpath;
	}
}
