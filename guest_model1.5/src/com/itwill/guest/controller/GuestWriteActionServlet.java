package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestWriteActionServlet
 */
@WebServlet("/guest_write_action.do")
public class GuestWriteActionServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:guest_write_form.do";
			//response.sendRedirect("guest_write_form.do");
		}else {
			try{
				request.setCharacterEncoding("UTF-8");
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
				Guest guest=
						new Guest(-999,guest_name,
								  null,guest_email,
								  guest_homepage,guest_title,
								  guest_content);
				GuestService guestService=new GuestService();
				int insertRowCount=
						guestService.insertGuest(guest);
				forwardPath="rediect:guest_list.do";
				//response.sendRedirect("guest_list.do");
			}catch(Exception e){
				e.printStackTrace();
				//response.sendRedirect("guest_error.jsp");
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
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
