package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;



public class dispatcherServlet2 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		/*
		 * 1.클라이언트의 요청URI를  사용해서 요청분석(구분)
		 */
		String requestURI = request.getRequestURI();
		//System.out.println("requestURI:"+requestURI);
		String contextPath= request.getContextPath();
		//System.out.println("contextPath:"+contextPath);
		String command =requestURI.substring(contextPath.length());
		//System.out.println("command:"+command);
		/*
		 * 2.클라이언트의 요청에따른 업무실행(XXService),forwardPath
		 */
		String forwardPath="";
		/*################################################################*/
		
		Controller controller = null; // Interface 생성
		
		if(command.equals("/guest_main.do")) {
			controller = new GuestMainController();
			//forwardPath = controller.handleRequest(request, response);
		}else if(command.equals("/guest_write_form.do")) {
			controller = new GuestMainController();
			//forwardPath = controller.handleRequest(request, response);
		}else if(command.equals("/guest_list.do")) {
			controller=new GuestListController();
			//forwardPath=controller.handleRequest(request, response);
		}else if(command.equals("/guest_view.do")) {
			controller=new GuestViewController();

		}else if(command.equals("/guest_write_action.do")) {
			controller=new GuestWriteActionController();
		}else if(command.equals("/guest_remove_action.do")) {
			controller=new GuestRemoveActionController();
		}else if(command.equals("/guest_modify_form.do")) {
			controller=new GuestModifyFormController();

		}else if(command.equals("/guest_modify_action.do")) {
			controller=new GuestModifyActionController();

		}else {
			controller=new GuestErrorController();
			/**************************************************
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			*/
		}
		
		/*################################################################*/
		forwardPath = controller.handleRequest(request, response);
		
		/*
		 * 3.JSP forward or redirect
		 */
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
