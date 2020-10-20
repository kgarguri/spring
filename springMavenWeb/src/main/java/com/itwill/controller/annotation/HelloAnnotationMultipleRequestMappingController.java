package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationMultipleRequestMappingController {
	
	// 1개 controller 에 여러개 mapping 이 가능하다
	
	/*
	 * servlet --> jsp 로 forward 임
	 */
	
	@RequestMapping("/hello3.do")
	public String hello3() {
		return "forward:/WEB-INF/views/hello3.jsp";
	}
	@RequestMapping("/hello4.do")
	public String hello4() {
		return "forward:/WEB-INF/views/hello4.jsp";
	}
	@RequestMapping("/hello5.do")
	public String hello5() {
		return "forward:/WEB-INF/views/hello5.jsp";
	}
	/*
	 *  servlet --> redirect --> jsp
	 */
	@RequestMapping("/hello_redirect_jsp.do")
	public String hello_redirect_jsp( ) {
		return "redirect:hello_redirected.jsp";  //redirect (hello_redirected.jsp) root 위치에 있어야 한다
	}
	/*
	 *  servlet --> redirect --> servlet(jsp)
	 */
	@RequestMapping("/hello_redirect_servlet.do")
    public String hello_redirect_servlet() {
    	return "redirect:hello_redirected_servlet.do";
    }
    @RequestMapping("/hello_redirected_servlet.do")
    public String hello_redirected_servlet() {
    	return "forward:/WEB-INF/views/hello_redirected_servlet.jsp";
    }
    /*
	 * Servlet(*.do) ----forward----> Servlet(*.do)
	 */
    @RequestMapping("/hello_servlet_forward.do")
    public String hello_servlet_forward() {
    	return "forward:hello_servlet_forwarded.do";
    }
    @RequestMapping("/hello_servlet_forwarded.do")
    public String hello_servlet_forwarded() {
    	return "forward:/WEB-INF/views/hello_servlet_forwarded.jsp";
    }
	
	
}
