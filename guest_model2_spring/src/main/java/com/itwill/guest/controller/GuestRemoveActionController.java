package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestRemoveActionController implements Controller {
	private GuestService guestService;
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
		//System.out.println("### GuestListController : setGuestService("+guestService+") 메쏘드호출");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/********************guest_remove_action.do******************/
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("guest_main.do");
			forwardPath="redirect:guest_main.do";
		}else {
		    try{
			    String guest_noStr = request.getParameter("guest_no");
			    
			    guestService.deleteGuest(Integer.parseInt(guest_noStr));
			    //response.sendRedirect("guest_list.do");
			    forwardPath="redirect:guest_list.do";
		    }catch(Exception e){
		    	e.printStackTrace();
		    	//response.sendRedirect("guest_error.do");
		    	forwardPath="redirect:guest_error.do";
		    }
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName(forwardPath);
		return mv;
	}

}
