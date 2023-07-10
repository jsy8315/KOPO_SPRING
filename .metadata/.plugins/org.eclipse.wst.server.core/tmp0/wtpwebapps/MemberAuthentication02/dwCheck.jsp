<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>이체전 마지막으로 체크하는 페이지</title>
</head>
<body>
	<h1>이체확인 페이지 dwCheck.jsp</h1>
	<h2>테스트 페이지</h2>
	<h2>dw.jps에서 모든 조회 과정을 거쳐서, 파라미터로 받아왔다고 가정하고 시작</h2>
<% 
	String wBankCode = "01"; //request.getParameter("wBankCode"); 나중에 파라미터로 받아올경우 주석 해제
	//출금(withd)되는 (돈뺄) 사람의 은행 코드
    String wAccountNumber = "3333-01-4985836"; //request.getParameter("wAccountNumber");  나중에 파라미터로 받아올경우 주석 해제
  	//출금(withd)되는 (돈뺄) 사람의 계좌번호
    String wName = "정수영"; //request.getParameter("wName"); 나중에 파라미터로 받아올경우 주석 해제
  	//출금(withd)되는 (돈뺄) 사람의 이름
    String TransferAmount = "10000"; //request.getParameter("TransferAmount"); 나중에 파라미터로 받아올경우 주석 해제
  	//출금(withd)되는 계좌에서 빼낼 돈 (입금할 돈)
  
  	String dBankCode = "02"; //request.getParameter("dBankCode"); 나중에 파라미터로 받아올경우 주석 해제
	//입금(deposit)받는 (돈받을) 사람의 은행 코드
    String dAccountNumber = "3333-02-5265010"; //request.getParameter("dAccountNumber");  나중에 파라미터로 받아올경우 주석 해제
  	//입금(deposit)받는 (돈받을) 사람의 계좌번호
    String dName = "강태근"; //request.getParameter("dName"); 나중에 파라미터로 받아올경우 주석 해제
  	//입금(deposit)받는 (돈받을) 사람의 이름
%>
	출금(withd)되는 (돈뺄) 사람의 은행 코드 : <%= wBankCode %><br>
	출금(withd)되는 (돈뺄) 사람의 계좌번호 : <%= wAccountNumber %><br>
	출금(withd)되는 (돈뺄) 사람의 이름 : <%= wName %><br>
	<br>
	출금(withd)하는 계좌에서 빼낼 돈 (입금할 돈): <%= TransferAmount %><br>
	<br>
	입금(deposit)받는 (돈받을) 사람의 은행 코드 : <%= dBankCode %><br>
	입금(deposit)받는 (돈받을) 사람의 계좌번호 : <%= dAccountNumber %><br>
	입금(deposit)받는 (돈받을) 사람의 이름 : <%= dName %><br>
	<br>
	<button id="transferBtn">이체하기</button>
	
	<script>
    document.getElementById("transferBtn").addEventListener("click", function() {
        const params = new URLSearchParams();
        params.append('wBankCode', "<%= wBankCode %>");
        params.append('wAccountNumber', "<%= wAccountNumber %>");
        params.append('wName', "<%= wName %>");
        params.append('TransferAmount', "<%= TransferAmount %>");
        params.append('dBankCode', "<%= dBankCode %>");
        params.append('dAccountNumber', "<%= dAccountNumber %>");
        params.append('dName', "<%= dName %>");

        fetch('http://localhost:8080/openapi/transfer', { // OpenAPI URL에 json형태로 계좌 이체 정보를 전송
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                'wBankCode': "<%= wBankCode %>",
                'wAccountNumber': "<%= wAccountNumber %>",
                'wName': "<%= wName %>",
                'TransferAmount': "<%= TransferAmount %>",
                'dBankCode': "<%= dBankCode %>",
                'dAccountNumber': "<%= dAccountNumber %>",
                'dName': "<%= dName %>"
            })
        }).then(function(response) {
            return response.json();
        }).then(function(data) {
            console.log(data);
            // Handle response data...
        });

    });
	</script>

</body>
</html>