<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
	request.setAttribute("price0", 345345435);
	request.setAttribute("name0", "kim eun hi");
	
	request.setAttribute("price1", 231151);
	request.setAttribute("name1", "LEE HYO LEE");
	request.setAttribute("married1", true);
	
	request.setAttribute("price2", 12345456);
	request.setAttribute("name2", "김태희");
	request.setAttribute("married2", true);
	
	request.setAttribute("guest", 
				new Guest(1, "김수미", new Date().toLocaleString(),
						"guard@naver.com", "http://www.google.com",
						"오늘은목요일", "Spring EL에대해 공부합니다."));
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Spring CustomTag ,SPEL</h1><hr/>
<p>
	- Spring Custom Tag : Spring에서 정의한태그<br/>
	- SPEL(Spring Expression Language)
	     Spring CustomTag(eval) 의 속성(expression)의 표현식
</p>
<ul>
	<!-- SLEL 과 EL 차이점 : SPEl 은 생성(new )이된다 -->
	<li>문자열리터럴(SPEL):<s:eval expression="'KIM'.substring(1)"/></li>
	<!--  <li>문자열리터럴(EL):${'KIM'.substring(1)}</li>  -->
	<li>숫자리터럴(SPEL):<s:eval expression="12345+6789"/></li>
	<li>숫자리터럴(EL):${123+456 }</li>
	<li>논리리터럴(SPEL):<s:eval expression="true"/></li>
	<li>논리리터럴(EL):${true }</li>
	<li>변수1(EL):${price0}${name0}${price10}${married1}</li>
	<li>변수2(EL Bean):${guest}</li>
	<li>변수3(EL Bean):${guest.guest_name}</li>
	<li>변수(SPEL):<s:eval expression="price1"/></li>
	<li>변수(SPEL):<s:eval expression="name1"/></li>
	<li>변수(SPEL):<s:eval expression="married1"/></li>
	
	<li>변수2(SPEL Bean):
		<s:eval expression="guest.guest_name"/>,
		<s:eval expression="guest.getGuest_name()"/>
	</li>
	<li>SPEL + EL(문자열리터럴):
		<s:eval expression="'${name0}'.substring(1)"/>==
		<s:eval expression="name0.substring(1)"/>
	</li>
	<li>SPEL + EL(숫자리터럴):
		<s:eval expression="${price0}+34435"/> ==
		<s:eval expression="price0+34453"/>
	</li>
	<li>SPEL(SCOPE객체에등록된 문자열변수):
		<s:eval expression="name0.replace('kim','hong').substring(4)"/>
	</li>
	<li>EL(SCOPE객체에등록된 숫자변수):
		${price0/9} != <s:eval expression="price0/9"/>
	</li>
	<li>SPEL(SCOPE객체에등록된 숫자변수):
		${price0/9} != <s:eval expression="price0/9"/>
	</li>
	<li>
		EL(SCOPE객체에등록된 빈객체(DTO)):
		${guest.guest_date.substring(0,11)}
	</li>
	<li>
		SPEL(SCOPE객체에등록된 빈객체(DTO)):
		<s:eval expression="guest.guest_date.substring(0,11)"/>
	</li>
	<li>
		클래스생성자호출(EL에서는 생성자호출 불가능):
		<br>
		&dollar;{new java.text.DecimalFormat('###,###.0').format(price1)}(X)
		<br>
		&dollar;{new java.util.Date().toLocaleString()}(X)
	</li>
	<li>
		클래스생성자호출(SPEL에서는 생성자호출 가능):
		<br/>
		 <s:eval expression="new java.text.DecimalFormat('###,###.0').format(price1)"/>
		<br>
		 <s:eval expression="new java.util.Date().toLocaleString()"/>
		
	</li>
	<li>
		@를 이용하여 SpringContainer에등록된 Bean 사용가능(SPEL)
		- @elBean:<s:eval expression="@elBean.toString()"/><br/>
		- @elBean.member1:<s:eval expression="@elBean.member1"/><br/>
		- @elBean.printMembers():<s:eval expression="@elBean.printMembers()"/>
		<br/>
		<br/>
	</li>
	
	
	
</ul>

</body>
</html>





