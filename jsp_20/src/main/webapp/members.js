function infoConfirm() {
	if(document.reg_frm.id.value.length == 0) {
		alert("아이디는 필수사항입니다.좋은말로 할때 채워넣으십시오");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.id.value.length < 4) {
		alert("아이디는 4글자 이상임");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.pw.value.length == 0) {
		alert("비밀번호는 필수사항입니다.좋은말로 할때 채워넣으십시오");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.name.value.length == 0) {
		alert("이름은 필수사항입니다.좋은말로 할때 채워넣으십시오");
		reg_frm.name.focus();
		return;
	}
	
	if(document.reg_frm.phonenumber.value.length == 0) {
		alert("전화번호는 필수사항입니다.좋은말로 할때 채워넣으십시오");
		reg_frm.phonenumber.focus();
		return;
	}
	
	if(document.reg_frm.phonenumber.value.length == 0) {
		alert("생물학적 성별로 체크해주세요, 여기는 한국입니다");
		reg_frm.gender.focus();
		return;
	}
	
	document.reg_frm.submit();
	
}