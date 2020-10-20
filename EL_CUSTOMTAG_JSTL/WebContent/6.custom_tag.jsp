<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ taglib uri="http://www.itwill.co.kr/jsp/simpleTag"  prefix="simple" --%> 
<%@ taglib  uri="/WEB-INF/simpleTag.tld" prefix="simple"%>
<%
	//session.setAttribute("sUserId", "guard");
	session.setAttribute("irum", "고소미");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>custom tag[사용자 정의 태그]</h1><hr/>
<%-- 
<jsp:forward/>
--%>
-------------hello tag-----------<br>
<simple:hello/>
<simple:hello/>
-------------helloAttr tag -----------<br>
<simple:helloAttr/>
<simple:helloAttr name="김경호"/>
<simple:helloAttr name="장동건"/>
<simple:helloAttr name="${irum}"/>
-------------if tag[body] -----------<br>
<simple:if test="true">
	반드시실행<br>
</simple:if>

<simple:if test="false">
	반드시안실행<br>
</simple:if>

<simple:if test="${sUserId!=null}">
	${sUserId} 님 안녕하세요!!!<br>
</simple:if>
<simple:if test="${sUserId==null}">
	GUEST 님 안녕하세요!!!<br>
</simple:if>

<simple:if test="${sUserId!=null}">
	<a href='logout.jsp'>${sUserId} 님 로그아웃</a>
</simple:if>
<simple:if test="${sUserId==null}">
	<a href='login_form.jsp'>로그인</a>
</simple:if>

</body>

</html>













