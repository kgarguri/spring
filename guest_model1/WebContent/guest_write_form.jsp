<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@page import="com.itwill.guest.GuestSQL"%>
<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="com.sun.javafx.scene.traversal.Hueristic2D"%>
<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
    GuestService guestService = new GuestService();
	//Guest guest = new Guest();
	//guestService.insertGuest(new Guest(String name, String email, String homepage, String title, String content));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="css/styles.css">
<link rel="stylesheet"
	href="css/guest.css">
 
<script	src="js/guest.js"></script>

<script type="text/javascript">
	function guestWriteAction(){
		if(document.f.guest_name.value==''){
			alert('이름을 입력하세요');
			document.f.guest_name.focus();
			return;
		}
		
		document.f.action='guest_write_action.jsp';
		document.f.method='POST';
		document.f.submit();
	}
	
	//var f = document.getElementById('f');
	var name = document.f.guest_name.value;
	var email = document.f.guest_email.value;
	var homepage = document.f.guest_homepage.value;
	var title = document.f.guest_title.value;
	var content = document.f.guest_content.value;
</script>	



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
	<table width=0 border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td>
				<!--contents--> <br />
				<table style="padding-left: 10px" border=0 cellpadding=0
					cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
								방명록 쓰기</b></td>
					</tr>
				</table> <!-- guest write Form  -->
				<form name="f" method="post">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="guest_name"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="guest_email"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">홈페이지</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 150" name="guest_homepage"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">타이틀</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px"><input type="text"
								style="width: 240" name="guest_title"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td width=490 align="left" bgcolor="ffffff"
								style="padding-left: 10px">
								<textarea wrap="soft" style="width:240px" rows="10" name="guest_content"></textarea>
							</td>
						</tr>
					</table>
				</form> <br />
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center>
						<input type="button" value="방명록쓰기" onclick="guestWriteAction()"> &nbsp; 
						<input type="button" value="방명록목록" onclick="guestList()"></td>
					</tr>
				</table>
			</td>
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
	</div>
	<!--container end-->
</body>
</html>
