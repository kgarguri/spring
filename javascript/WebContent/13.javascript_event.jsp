<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function displayMessage(msg){
		document.getElementById('result').innerHTML += msg+"<br>"; 
	}
	function inlineEventHandler(e){
		var msg='inlineEventHandler:'+e.target+","+e.type+", this:"+this;
		displayMessage(msg);
	}
	function button2EventHandler(e){
		var msg='button2EventHandler:'+e.target+","+e.type+", this:"+this+","+this.value;
		displayMessage(msg);
	}
	function button3EventHandler1(e){
		var msg='button3EventHandler1:'+e.target+","+e.type+", this:"+this+","+this.value;
		displayMessage(msg);
	}
	function button3EventHandler2(e){
		var msg='button3EventHandler2:'+e.target+","+e.type+", this:"+this+","+this.value;
		displayMessage(msg);
	}
	function event_regist(){
		/***DOM LEVEL-0****/
		/**********case1**************/
		var button2E = document.f.button2;
		/**********case2**************
		var button2E = document.getElementById('button2');
		*/
		/**********case3**************
		var button2ENodeList = document.getElementsByName('button2');
		var button2E = button2ENodeList.item(0);
		*/
		button2E.onclick = button2EventHandler;
		/*******************DOM LEVEL-2*****************/
		var buttonE3 = document.f.button3;
		buttonE3.addEventListener('click',button3EventHandler1);
	
		buttonE3.addEventListener('click',button3EventHandler2,false);
		buttonE3.addEventListener('mouseover',function(e){
			var msg='button3익명EventHandler1:'+e.target+","+e.type+", this:"+this+","+this.value;
			displayMessage(msg);
		});
		
		buttonE3.addEventListener('mouseout',function(e){
			var msg='button3익명EventHandler2:'+e.target+","+e.type+", this:"+this+","+this.value;
			displayMessage(msg);
		});
		document.f.button4.addEventListener('click',function(e){
				document.f.button1.onclick=null;
				document.f.button2.onclick=null;
				document.f.button3.removeEventListener('click',button3EventHandler1);
				document.f.button3.removeEventListener('click',button3EventHandler2);
		});
		var olistE = document.getElementById("movie_rank");
		var liNodeList = olistE.getElementsByTagName("li");
		for(var i=0;i<liNodeList.length;i++){
			liNodeList.item(i).addEventListener('click',function(e){
					var clickMovieName = e.target.innerHTML;
					displayMessage("click한영화:"+clickMovieName)
			});
		}
	}
	/*
	 window.onload 이벤트발생시점
	  - DOM트리로딩직후 랜더링(image)전에호출
	*/
	//window.onload = event_regist; 
	window.onload = function(){
			event_regist();
			//ui_init();
	};
</head>
<body>
<h1>javascript event</h1><hr/>
<form name="f">
	<input onclick="inlineEventHandler(event)" 
			name="button1" 
			type="button" 
			value="event model[inline]"/>
	<input id="button2" name="button2" type="button" value="event model[DOM level0]"/>
	<input name="button3" type="button" value="event model[DOM level2]"/>
	<input name="button4" type="button" value="event remove"/>
</form>
<ol id='movie_rank'>
	<li>조커</li>
	<li>람보</li>
	<li>AI</li>
	<li>알라딘</li>
	<li>체르노빌</li>
</ol>
<div id="result">
	
</div>
<script type="text/javascript">
	//event_regist();
</script>
</body>
</html>














