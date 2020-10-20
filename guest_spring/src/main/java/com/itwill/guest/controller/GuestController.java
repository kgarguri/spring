package com.itwill.guest.controller;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.helpers.ParseConversionEventImpl;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	//@Qualifier("GuestService") 없으며 type 으로 imjection 한다
	private GuestService guestService;
	
	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "forward:/WEB-INF/views/guest_main.jsp";
	}
	@RequestMapping("/guest_list.do")
	public ModelAndView guest_list() throws Exception {
		ModelAndView mv = new ModelAndView();
		ArrayList<Guest> guestList = guestService.selectAll();
		mv.addObject("guestList", guestList);
		mv.setViewName("forward:/WEB-INF/views/guest_list.jsp");
		return mv;
	}
	
	@RequestMapping("/guest_write_form.do")
	public String guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping(value = "/guest_write_action.do", method = RequestMethod.GET)
	public String guest_write_action_get() throws Exception {
		return "redirect:guest_write_form.jsp";
	}
	
	@RequestMapping(value = "/guest_write_action.do", method = RequestMethod.POST)
	// = public String guest_write_action_post(@ModelAttribute Guest guest) {
	public String guest_write_action_post (
			@RequestParam String guest_name, 
			@RequestParam String guest_title, 
			@RequestParam String guest_email, 
			@RequestParam String guest_homepage, 
			@RequestParam String guest_content 
			) throws Exception {
		
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strDate = sdf.format(nowDate);

		Guest guest = new Guest(0, guest_name, strDate, guest_email, guest_homepage, guest_title, guest_content);
		guestService.insertGuest(guest);

		//return "redirect:/WEB-INF/views/guest_list.do";
		return "redirect:guest_list.do";
	}
	
	@RequestMapping("/guest_view.do")
	public String guest_view(HttpServletRequest request, @RequestParam String guest_no) throws Exception {
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
		request.setAttribute("guest", guest);
		return "forward:/WEB-INF/views/guest_view.jsp";
	}
	
	/*
	@RequestMapping("/guest_view.do")
	public ModelAndView guest_view(@RequestParam String guest_no) throws Exception {
		ModelAndView mv = new ModelAndView();
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
		mv.addObject("guest", guest);
		mv.setViewName("forward:/WEB-INF/views/guest_view.jsp");
		return mv;
	}
	*/
	/*
	@RequestMapping("/guest_modify_form.do")
	public String guest_modify_form(
			@RequestParam String guest_no
			) throws Exception {
		guestService.selectByNo(Integer.parseInt(guest_no));
		return "redirect : guest_modify_form.jsp";
	}
	*/
	@RequestMapping("/guest_modify_form.do")
	public ModelAndView guest_modify_form(@RequestParam String guest_no) throws Exception {
		ModelAndView mv = new ModelAndView();
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
		mv.addObject("guest", guest);
		mv.setViewName("forward:/WEB-INF/views/guest_modify_form.jsp");
		return mv;
	}
	@RequestMapping("/guest_modify_action.do")
	public String guest_modify_action(
					@RequestParam String guest_no,
					@RequestParam String guest_name,
					@RequestParam String guest_email,
					@RequestParam String guest_homepage,
					@RequestParam String guest_title,
					@RequestParam String guest_content
			) throws Exception{
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strDate = sdf.format(nowDate);

		Guest guest = new Guest(Integer.parseInt(guest_no), guest_name,
				          strDate, guest_email, guest_homepage, guest_title, guest_content);
		guestService.updateGuest(guest);
		return "redirect:guest_view.do?guest_no="+guest_no;
	}
	@ExceptionHandler(Exception.class) // throws Exception 할때마다 @ExceptionHandle 를 찾아서 실행한다
	public String guest_error_handle(Exception e) {
		return "";
	}
	
}
