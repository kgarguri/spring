package com.itwill.guest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestListController implements Controller{
	private GuestService guestService;
	
	public GuestListController() {
		System.out.println("### GuestListController: 기본생성자호출");
	}
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
		System.out.println("### GuestListController : setGuestService("+guestService+") 메쏘드호출");
	}



	public ModelAndView handleRequest(HttpServletRequest request,
								HttpServletResponse response) {
		/********************guest_list.do***********************/
		ModelAndView mv = new ModelAndView();
		String forwardPath="";
		
		try {
			//GuestServiceImpl guestService=new GuestServiceImpl(); 생성하면 안됨
			
			ArrayList<Guest> guestList=guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath="forward:/WEB-INF/views/guest_list.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		mv.setViewName(forwardPath);
		return mv;
	}
}
