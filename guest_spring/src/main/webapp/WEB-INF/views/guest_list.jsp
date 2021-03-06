<%@page import="com.itwill.guest.Guest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.guest.GuestServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${pageContext.request.locale.language}"/>
<fmt:setBundle basename="messages/guest"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><fmt:message key="title.main"/></title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">
<script	src="js/guest.js"></script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
		<!-- include_common_top.jsp start-->
		<jsp:include page="include_common_top.jsp"/>
		<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper content start -->
		<div id="wrapper">

<div id="content">	
<table border=0 cellpadding=0 cellspacing=0>
	<tr>
		<td><br />
			<table style="padding-left: 10px" border=0 cellpadding=0
				cellspacing=0>
				<tr>
					<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b><fmt:message key="title.list"/></b></td>
				</tr>
			</table>
			<form name="f" method="post">

				<table border="0" cellpadding="0" cellspacing="1" width="590"
					bgcolor="BBBBBB">
					<tr>
						<td width=50 align=center bgcolor="E6ECDE" height="22"><fmt:message key="list.label.no"/></td>
						<td width=300 align=center bgcolor="E6ECDE"><fmt:message key="list.label.title"/></td>
						<td width=120 align=center bgcolor="E6ECDE"><fmt:message key="list.label.name"/></td>
						<td width=120 align=center bgcolor="E6ECDE"><fmt:message key="list.label.date"/></td>
					</tr>
					<!-- guest list loop start -->
					
					<c:forEach items="${guestList}" var="guest">
					<tr>
						<td width=50 align=center bgcolor="ffffff" height="20">${guest.guest_no}</td>
						<td width=300 bgcolor="ffffff" style="padding-left: 10"><a
							href="guest_view.do?guest_no=${guest.guest_no}" class="user">
								${guest.guest_title}
						</a></td>
						<td width=120 align=center bgcolor="ffffff">${guest.guest_name}</td>
						<td width=120 align=center bgcolor="ffffff">${guest.guest_date.substring(0,10)}</td>
					</tr>
					</c:forEach>
					<!--guest list loop end  -->
					
					
				</table>
			</form> <br> <!-- button -->
			<table border="0" cellpadding="0" cellspacing="1" width="590">
				<tr>
					<td align="right">
					<input type="button"
					    onclick="guestWriteForm();" value="<fmt:message key="menu.write"/>" />
					<!--  
					<input type="button"
					    onclick="location.href='guest_write_form.jsp';" value="방명록 쓰기" />
					-->    
					</td>
				</tr>
			</table></td>
	</tr>
</table>
</div>

		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<%@include file="include_common_bottom.jspf" %>
			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>
