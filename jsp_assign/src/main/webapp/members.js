function infoConfirm() {
	if(document.reg_frm.id.value.length == 0) {
		alert("아이디는 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.id.value.length < 4) {
		alert("아이디는 4글자 이상으로 만들어야 됩니다");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.pw.value.length == 0) {
		alert("비밀번호는 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value.length < 4) {
		alert("비밀번호는 4글자 이상으로 만들어야 됩니다");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
	
	var pattern1 = /[0-9]/;
	var pattern2 = /[a-zA-Z]/;

	if (!pattern1.test(document.reg_frm.pw.value) || !pattern2.test(document.reg_frm.pw.value)) {
    	alert("비밀번호는 영문과 숫자로 구성되어야 합니다.");
    	reg_frm.pw.focus();
    	return;
	}
	
	if(document.reg_frm.name.value.length == 0) {
		alert("이름은 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.name.focus();
		return;
	}
	
	if(document.reg_frm.cp.value.length == 0) {
		alert("전화번호는 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.cp.focus();
		return;
	}
			
	document.reg_frm.submit();
	
}

function updateInfoConfirm() {
	if(document.reg_frm.name.value.length == 0) {
		alert("이름은 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.name.focus();
		return;
	}
	
	if(document.reg_frm.mail.value.length == 0) {
		alert("이메일은 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.mail.focus();
		return;
	}
	if(document.reg_frm.status.value.length == 0) {
		alert("회원상태는 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.status.focus();
		return;
	}
	if(document.reg_frm.authority.value.length == 0) {
		alert("회원권한은 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.authority.focus();
		return;
	}
  			
	document.reg_frm.submit();
}	

function updateUserInfoConfirm() {

	if(document.reg_frm.name.value.length == 0) {
		alert("이름은 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.name.focus();
		return;
	}
	if(document.reg_frm.pw.value.length == 0) {
		alert("비밀번호는 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value.length < 4) {
		alert("비밀번호는 4글자 이상으로 만들어야 됩니다");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
	
	var pattern1 = /[0-9]/;
	var pattern2 = /[a-zA-Z]/;

	if (!pattern1.test(document.reg_frm.pw.value) || !pattern2.test(document.reg_frm.pw.value)) {
    	alert("비밀번호는 영문과 숫자로 구성되어야 합니다.");
    	reg_frm.pw.focus();
    	return;
	}
	
	if(document.reg_frm.mail.value.length == 0) {
		alert("이메일은 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.mail.focus();
		return;
	}
	if(document.reg_frm.cp.value.length == 0) {
		alert("전화번호는 필수사항입니다. 좋은말로 할때 채워넣으십시오");
		reg_frm.cp.focus();
		return;
	}
	document.reg_frm.submit();
}		
