<%@page import="com.itwill.shop.jumun.Jumun"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.jumun.JumunService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>    
<%
	JumunService jumunService=new JumunService();
    ArrayList<Jumun> jumunList =jumunService.list(sUserId);
    
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">

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
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											주문 목록</b></td>
								</tr>
							</table> <!--form-->
							<form name="f" method="post">
								<table align=center border=1 width=80% cellspacing=0
									bordercolordark=#FFFFFF bordercolorlight=#4682b4>
									<tr>
										<td width=145 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>주문번호</font></td>
										<td width=145 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>주문이름</font></td>
										<td width=112 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>주문날짜</font></td>
										<td width=136 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF>주문가격</font></td>
										<td width=80 height=25 bgcolor=#4682b4 align=center class=t1><font
											color=#FFFFFF></font></td>
									</tr>
									<%for(Jumun jumun:jumunList){ %>
									<!-- jumun item start -->
									<tr>
										<td width=145 height=26 align=center class=t1><%=jumun.getJ_no()%></td>
										<td width=145 height=26 align=center class=t1><%=jumun.getJ_desc()%></td>
										<td width=112 height=26 align=center class=t1><%=jumun.getJ_date()%></td>
										<td width=136 height=26 align=center class=t1><%=jumun.getJ_price()%></td>
										<td width=80 height=26 align=center class=t1><a
											href="shop_jumun_detail.jsp?j_no=<%=jumun.getJ_no()%>" class=m1>주문상세</a></td>
									</tr>
									<!-- jumun item end -->
									<%} %>
									
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp;<a href=shop_product_list.jsp
										class=m1>계속 구경하기</a> 

									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>