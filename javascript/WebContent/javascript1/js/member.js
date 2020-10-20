/**
 * 
 */
function load_focus() {
	//window.document.joinFrm.id.focus();
	document.getElementById('id').focus();
}
function join_form_submit_button() {

	var f = document.getElementById('joinFrm');

	if (is_null(f.id.value)) {
		alert('아이디를 입력하세요');
		f.id.focus();
		return false;
	}

	if (f.password.value == null || f.password.value == '') {
		alert('패쓰워드를 입력하세요');
		f.password.focus();
		return false;
	}
	if (f.repassword.value == null || f.repassword.value == '') {
		alert('패쓰워드확인을 입력하세요');
		f.repassword.focus();
		return false;
	}

	if (f.name.value == null || f.name.value == '') {
		alert('이름을 입력하세요');
		f.repassword.focus();
		return false;
	}
	if (f.address.value == null || f.address.value == '') {
		alert('주소를 입력하세요');
		f.address.focus();
		return false;
	}
	if (!isSame(f.password.value,f.repassword.value)) {
		alert("패쓰워드와 패쓰워드확인은 일치 하여야합니다.");
		f.repassword.select();
		return false;
	}
	return true;
}
function join_form_button() {

	var id = document.getElementById('id').value;
	if (id == null || id == '') {
		alert('아이디를 입력하세요');
		document.getElementById('id').focus();
		return;
	}
	var password = document.getElementById('password').value;
	if (password == null || password == '') {
		alert('패쓰워드를 입력하세요');
		document.getElementById('password').focus();
		return;
	}
	var repassword = document.getElementById('repassword').value;
	if (repassword == null || repassword == '') {
		alert('패쓰워드확인을 입력하세요');
		document.getElementById('repassword').focus();
		return;
	}
	var name = document.getElementById('name').value;
	if (name == null || name == '') {
		alert('이름을 입력하세요');
		document.getElementById('name').focus();
		return;
	}
	var address = document.getElementById('address').value;
	if (address == null || address == '') {
		alert('주소를 입력하세요');
		document.getElementById('address').focus();
		return;
	}
	if (password != repassword) {
		alert("패쓰워드와 패쓰워드확인은 일치 하여야합니다.");
		document.getElementById('repassword').select();
		return;
	}
	/*
	1.아이디는 5~10자여야한다
	2.영문알파벳대문자,소문자,숫자만 가능
	3.숫자로 시작할수없다
	*/
	document.getElementById('joinFrm').action = '../4.join.jsp';
	document.getElementById('joinFrm').method = 'post';
	document.getElementById('joinFrm').submit();
	return;
}