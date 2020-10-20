<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("a", new String("속성객체"));
	request.setAttribute("b", new Integer(2));
	
	request.setAttribute("c", new Boolean(true));
	request.setAttribute("d", new Guest(1,"KIM","2020","guard@gmail.com","http://www.naver.com","타이틀","콘텐트"));
	ArrayList list=new ArrayList();
	request.setAttribute("e",list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
속성이름  a---> ${a}<br>
속성이름  b---> ${b}<br>
속성이름  c---> ${c}<br>
속성이름  d---> ${d.getGuest_name()}<br>
속성이름  d---> ${d.guest_name}<br>
속성이름  e---> ${e}<br>
속성이름  f---> ${f}<br>
</body>
</html>