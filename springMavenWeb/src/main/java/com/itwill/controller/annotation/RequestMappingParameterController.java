package com.itwill.controller.annotation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestMappingParameterController {
	
	@RequestMapping("/parameter_guest_write_form.do")
	public String parameter_guest_write_form() {
		return "forward:/WEB-INF/views/quest_write_form.jsp";
	}
	
	@RequestMapping( value = "/parameter_guest_write_action.do",
			         method = RequestMethod.GET)
	public String parameter_guest_write_action_get() {
		//return "forward:parameter_guest_write_form.do";
		//return "redirect:parameter_guest_write_form.do";
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping( value = "/parameter_guest_write_action.do",
			method = RequestMethod.POST)
	public String parameter_guest_write_action(
								@RequestParam String guest_name,
								@RequestParam("guest_title") String title,
								@RequestParam String guest_email,
								@RequestParam String guest_homepage,
								@RequestParam String guest_content
								) {
		
		//guest_name=new String(guest_name.getBytes("8859_1"),"UTF-8");
		
		Guest guest = new Guest(0, guest_name, title, guest_homepage, guest_email, guest_content);
		
		System.out.println("##########  guest parameter : "+guest);
		
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	
	@RequestMapping( value = "/model_attribute_guest_write_action.do",
			method = RequestMethod.POST)
	//public String model_attribute_guest_write_action(@ModelAttribute("guest") Guest guest) {
	public String model_attribute_guest_write_action( Guest guest) {
		System.out.println("#######  @ModelAttribute guest : "+guest);
		
		 /*
		 * 1. 파라메타의모든객체 받기
		 * 2. 선언된DTO객체[Guest]생성(기본생성자)
		 * 3. 받은파라메타 데이타를 파라메타이름과 일치하는
		 *    Guest객체의 속성메쏘드(setter method)호출해서대입
		 * 4. Guest클래스이름 첫글자를 소문자로변경한이름(guest)으로
		 *    request객체에 속성(attribute)등록
		 *    request.setAttribute("guest",guest);
		 */
		/*
		 * GuestService메쏘드호출
		 */
		
		this.guestList();
		/*
		 ArrayList<Guest> guestList=this.guestList();
		 request.setAttribute("guestList",guestList);
		 */
		
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	private ArrayList<Guest> guestList() {
		ArrayList<Guest> guestsList = new ArrayList<Guest>();
		guestsList.add(new Guest());
		guestsList.add(new Guest());
		guestsList.add(new Guest());
		guestsList.add(new Guest());
		guestsList.add(new Guest());
		guestsList.add(new Guest());
		return guestsList;
	}
	
	
	
}
