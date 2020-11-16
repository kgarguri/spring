function MemberService(){
	
	this.member_init();
}
MemberService.prototype = {
	"member_init":function(){
		//초기화
		alert($);
	},
	"member_event_register":function(){
		//멤버이벤트등록
		var memberService = this;
		$('#joinB').click(function(e){
			memberService.member_join(e);
			e.preventDefault();
		});
	},
	"member_login" : function() {
		
	},
	"member_join" : function() {
		alert("회원가입");
	},
	"member_list" : function() {
		
	},
	"member_view" : function() {
		
	}
	
}