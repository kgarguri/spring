package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public HelloController() {
		System.out.println("#### 111111. hello Controller() 기본생성자 호출");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("#### 22222. hello Controller.handlerequest() 메쏘드 호출");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/WEB-INF/views/hello.jsp");
		request.setAttribute("msg", "안녕하세요!!!");
		
		return mv;
	}

}
