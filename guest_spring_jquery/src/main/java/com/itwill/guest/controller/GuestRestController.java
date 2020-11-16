package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestResultList;
import com.itwill.guest.GuestService;

@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value = "guest_existed_id_check", produces = "text/plain;charset=UTF-8")
	public String guest_existed_id_check(@RequestParam String guest_id) {
		String result = "false";
		if (guest_id.equals("user1") || guest_id.equals("user1")) {
			result = "true";
		}else {
			result = "false";
		}
		return result;
	}
	
	@RequestMapping(value = "/guest_insert_action", produces = "text/plain;charset=UTF-8")
	public String guest_insert_action(@ModelAttribute Guest guest) throws Exception{
		boolean insertOk = guestService.insertGuest(guest);
		if(insertOk) {
			return "true"; 
		}else {
			return "false"; 
		}
	}
	
	@RequestMapping(value = "/guest_logout_action", produces = "text/plain;charset=UTF-8")
	public String guest_logout_action(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	@RequestMapping(value = "/guest_login_action", produces = "text/plain;charset=UTF-8")
	public String guest_login_action(@RequestParam String guest_id,
									 @RequestParam String guest_pass,
									 HttpSession session) {
		/*
		id  | pass
		-----|-----
		user1|user1
		user2|user2
		*/
		String result="fail";
		if((guest_id.equals("user1") && guest_pass.equals("user1"))||
			(guest_id.equals("user2") && guest_pass.equals("user2"))	
			) {
			session.setAttribute("user_id", guest_id);
			result="success";
		}else {
			result="fail";
			}
		return result;
	}
	
	@RequestMapping(value = "/guest_detail_html", produces = "text/html;charset=UTF-8")
	public String guest_detail_html(@RequestParam int guest_no) throws Exception{
		Guest guest = guestService.selectByNo(guest_no);
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"guest_detail\">");
		sb.append("<div class=\"guest_date\">");
		sb.append("	날짜:"+guest.getGuest_date());
		sb.append("</div>");
		sb.append("<div class=\"guest_name\">");
		sb.append("	이름:"+guest.getGuest_name());
		sb.append("</div>");
		sb.append("<div class=\"guest_email\">");
		sb.append("	이메일:"+guest.getGuest_email());
		sb.append("</div>");
		sb.append("<div class=\"guest_homepage\">");
		sb.append("	홈페이지:"+guest.getGuest_homepage());
		sb.append("</div>");
		sb.append("<div class=\"guest_content\">");
		sb.append("	내용:"+guest.getGuest_content());
		sb.append("</div>");
		sb.append("	<div class=\"guest_delete\">");
		sb.append("		<input type=\"button\" value=\"삭제\" guest_no=\""+guest.getGuest_no()+"\">");
		sb.append("		<input type=\"button\" value=\"수정\" guest_no=\""+guest.getGuest_no()+"\">");
		sb.append("	</div>");
		sb.append("</div>");
		return sb.toString();
	}
	
	@RequestMapping(value = "guest_list_xml", produces = "text/xml;charset=UTF-8")
	public GuestResultList guest_list_xml() throws Exception{
		GuestResultList guestResultList=new GuestResultList();
		List<Guest> guestList=guestService.selectAll();
		guestResultList.setGuestList(guestList);
		return guestResultList;
		/*
		 * <guest_list>
				<guest>
					<guest_no>10</guest_no>
					<guest_name>김경호</guest_name>
					<guest_date>2020-10-23 10:20:09</guest_date>
					<guest_email>guard@gmail.com</guest_email>
					<guest_homepage>http://www.itwill.co.kr</guest_homepage>
					<guest_title>오늘은 금요일 내일은토요일</guest_title>
					<guest_content>주말입니다</guest_content>
				</guest>
				...
			</guest_list>
		 */
	}
	
	@RequestMapping(value = "guest_list_json", produces = "application/json;charset=UTF-8")
	public List<Guest> guest_list_json() throws Exception{
		return guestService.selectAll();
	}
	
	@RequestMapping(value = "guest_list_html", produces = "text/html;charset=UTF-8")
	public String guest_list_html() throws Exception{
		StringBuffer htmlSb = new StringBuffer();
		List<Guest> guestList = (List<Guest>) guestService.selectAll();
		for (Guest guest : guestList) {
			htmlSb.append("<div class=\"guest_item\">");
			htmlSb.append("<h3 class=\"guest_title\"  guest_no=\"" + guest.getGuest_no() + "\"><a href=\"\">"
					+ guest.getGuest_title() + "[HTML]</a></h3>");
			htmlSb.append("</div>");
		}
		return htmlSb.toString();
	}
	
}
