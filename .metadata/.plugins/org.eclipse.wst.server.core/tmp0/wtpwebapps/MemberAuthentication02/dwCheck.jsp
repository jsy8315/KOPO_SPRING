<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ü�� ���������� üũ�ϴ� ������</title>
</head>
<body>
	<h1>��üȮ�� ������ dwCheck.jsp</h1>
	<h2>�׽�Ʈ ������</h2>
	<h2>dw.jps���� ��� ��ȸ ������ ���ļ�, �Ķ���ͷ� �޾ƿԴٰ� �����ϰ� ����</h2>
<% 
	String wBankCode = "01"; //request.getParameter("wBankCode"); ���߿� �Ķ���ͷ� �޾ƿð�� �ּ� ����
	//���(withd)�Ǵ� (����) ����� ���� �ڵ�
    String wAccountNumber = "3333-01-4985836"; //request.getParameter("wAccountNumber");  ���߿� �Ķ���ͷ� �޾ƿð�� �ּ� ����
  	//���(withd)�Ǵ� (����) ����� ���¹�ȣ
    String wName = "������"; //request.getParameter("wName"); ���߿� �Ķ���ͷ� �޾ƿð�� �ּ� ����
  	//���(withd)�Ǵ� (����) ����� �̸�
    String TransferAmount = "10000"; //request.getParameter("TransferAmount"); ���߿� �Ķ���ͷ� �޾ƿð�� �ּ� ����
  	//���(withd)�Ǵ� ���¿��� ���� �� (�Ա��� ��)
  
  	String dBankCode = "02"; //request.getParameter("dBankCode"); ���߿� �Ķ���ͷ� �޾ƿð�� �ּ� ����
	//�Ա�(deposit)�޴� (������) ����� ���� �ڵ�
    String dAccountNumber = "3333-02-5265010"; //request.getParameter("dAccountNumber");  ���߿� �Ķ���ͷ� �޾ƿð�� �ּ� ����
  	//�Ա�(deposit)�޴� (������) ����� ���¹�ȣ
    String dName = "���±�"; //request.getParameter("dName"); ���߿� �Ķ���ͷ� �޾ƿð�� �ּ� ����
  	//�Ա�(deposit)�޴� (������) ����� �̸�
%>
	���(withd)�Ǵ� (����) ����� ���� �ڵ� : <%= wBankCode %><br>
	���(withd)�Ǵ� (����) ����� ���¹�ȣ : <%= wAccountNumber %><br>
	���(withd)�Ǵ� (����) ����� �̸� : <%= wName %><br>
	<br>
	���(withd)�ϴ� ���¿��� ���� �� (�Ա��� ��): <%= TransferAmount %><br>
	<br>
	�Ա�(deposit)�޴� (������) ����� ���� �ڵ� : <%= dBankCode %><br>
	�Ա�(deposit)�޴� (������) ����� ���¹�ȣ : <%= dAccountNumber %><br>
	�Ա�(deposit)�޴� (������) ����� �̸� : <%= dName %><br>
	<br>
	<button id="transferBtn">��ü�ϱ�</button>
	
	<script>
		document.getElementById("transferBtn").addEventListener("click", function() {
			location.href = "transfer.bank";
		});
	</script>
</body>
</html>