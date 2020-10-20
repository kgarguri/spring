<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function login_message(){
		alert('로그인하세요');
		location.href='user_login_form.jsp';
	}
</script>    
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	
	<%if(session.getAttribute("sUserId")==null){ %>
		<li><a href="user_write_form.jsp">회원가입</a></li>
		<li><a href="user_login_form.jsp">로그인</a></li>
		
	<%}else{ %>
		<li><a href="user_view.jsp"><%=session.getAttribute("sUserId")%>님</a>&nbsp;<a href="user_logout_action.jsp">로그아웃</a></li>
		<li><a href="shop_jumun_list.jsp">주문목록</a></li>
	<%} %>
	<li><a href="shop_product_list.jsp">쇼핑몰</a></li>
	
	<%if(session.getAttribute("sUserId")==null){ %>
		<li><a href="javascript:login_message();">장바구니</a></li>
	<%}else{ %>
		<li><a href="shop_view_cart.jsp">장바구니</a></li>
	<%} %>	
</ul>
