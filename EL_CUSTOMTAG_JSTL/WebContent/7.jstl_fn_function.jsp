<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itwill.util.StaticFunction" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String title="오늘은 수요일 넷플릭스 보고가요!!!";
	request.setAttribute("title", title);
	request.setAttribute("name", "JAMES");
	request.setAttribute("price", 1234567);
	request.setAttribute("weight", 74.5681);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL function[EL 안에서 사용가능한]</h1><hr/>
	<ol>
		<li>${fn:substring(title,4,7)}</li>
		<li>${fn:toLowerCase(name)}</li>
		
		<li>${title.substring(4,7)}</li>
		<li>${name.toLowerCase()}</li>
		<br>
		<li>표준EL static method호출가능<br>
		<li>${Integer.parseInt('45')+50}</li>
		<li>${StaticFunction.number(price,'###,###,###')}</li>
		<li>표준EL생성기능이없어요ㅠㅠㅠ<br>
			&dollar;{new DecimalFormat('###,###,###').format(price)}-->안되요
		</li>
	</ol>
</body>
</html>