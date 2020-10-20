<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello.jsp</h1><hr/>
<ol>
	<li>1. 클라이언트(web.xml)을 통해 /hello.do 실행요청함.</li>
	<li>2. DispatcherServlet이 HandlerMapping객체(web-application-context.xml)로부터 <br>
	       요청받은 url(/hello.do)에 해당하는 Controller객체(helloController) 얻기</li>
	<li>3. DispatcherServlet이 Controller(HelloController.java)객체인
	             handleRequest(request,response)메쏘드 호출</li>
	<li>4. DispatcherServlet이 HelloController.java 객체의 handleRequest()메쏘드 호출후 <br>
	             반환된 path(forward:/WEB-INF/views/hello.jsp)로 forwarding...</li>   
	<li>5. /WEB-INF/views/hello.jsp 응답 <br><br>  </li>
	
	<li>msg: ${msg}</li>
	
</ol>
</body>
</html>