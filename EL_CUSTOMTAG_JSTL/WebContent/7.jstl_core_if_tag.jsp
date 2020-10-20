<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	session.setAttribute("sUserId", "guard");
	session.setAttribute("level", 5);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core if tag</h1><hr>
<c:if test="true">
	1.반드시실행<br>
</c:if>
<c:if test="false">
	2.반드시안실행<br>
</c:if>
<c:if test="${sUserId==null}">
	<a href='user_login_form.jsp'>로그인</a>
</c:if>
<c:if test="${sUserId!=null}">
	<a href='user_logout_action.jsp'>${sUserId}님로그아웃</a><br>
</c:if>
<c:if test="${!empty sUserId}">
	<a href='user_logout_action.jsp'>${sUserId}님로그아웃</a><br>
</c:if>
<c:if test="${!empty level}">
		<c:if test="${level>=5}">
			${level} 레벨이라니 부러워요 고수시군요!<br>
		</c:if>
</c:if>
<c:if test="${(!empty level)&& level>=5}">
			${level} 레벨이라니 부러워요 고수시군요!<br>
</c:if>


</body>
</html>