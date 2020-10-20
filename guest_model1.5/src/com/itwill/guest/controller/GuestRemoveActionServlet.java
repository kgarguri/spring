package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestRemoveActionServlet
 */
@WebServlet("/guest_remove_action.do")
public class GuestRemoveActionServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="rediredct :guest_main.do";
		} else {
		    try{
			    String guest_noStr = request.getParameter("guest_no");
			    GuestService guestService=new GuestService();
			    guestService.deleteGuest(Integer.parseInt(guest_noStr));
			    forwardPath="rediredct :guest_list.do";
		    }catch(Exception e){
		    	e.printStackTrace();
		    	forwardPath="rediredct :guest_error.do";
		    }
		}
		
		String [] pathArray = forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];
		
		
		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
