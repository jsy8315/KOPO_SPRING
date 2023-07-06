<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Manage My Info</title>
    <style>
        body {
            font-family: 'Hana', Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
        }

        table td:first-child {
            width: 120px;
            font-weight: bold;
            vertical-align: top;
        }

        input[type="password"],
        input[type="text"],
        input[type="email"] {
            width: 100%;
            padding: 6px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-family: 'Hana', Arial, sans-serif;
        }

        input[type="password"]::placeholder,
        input[type="text"]::placeholder,
        input[type="email"]::placeholder {
            font-family: 'Hana', Arial, sans-serif;
            font-style: italic;
        }

        input[type="submit"] {
            width: 100%;
            padding: 8px;
            border: none;
            background-color: pink;
            color: #fff;
            cursor: pointer;
            border-radius: 4px;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #ff6b9b;
        }

        .error-message {
            color: red;
            margin-top: 5px;
            display: none;
        }
    </style>
</head>
<body>
<script>
    // ��ȭ��ȣ �Է� �ʵ忡�� �Է� ������ ����� ������ �ڵ����� �������� �߰��ϴ� �Լ�
    function formatPhoneNumber() {
        var phoneNumberInput = document.querySelector('input[name="phone_number"]');
        var phoneNumber = phoneNumberInput.value.replace(/[^0-9]/g, ''); // ���� �̿��� ���ڴ� ����
        var formattedPhoneNumber = '';

        if (phoneNumber.length > 3) {
            formattedPhoneNumber += phoneNumber.substr(0, 3) + '-';
            if (phoneNumber.length > 7) {
                formattedPhoneNumber += phoneNumber.substr(3, 4) + '-' + phoneNumber.substr(7);
            } else {
                formattedPhoneNumber += phoneNumber.substr(3);
            }
        } else {
            formattedPhoneNumber = phoneNumber;
        }

        phoneNumberInput.value = formattedPhoneNumber;
    }

    // ��ȭ��ȣ �Է� �ʵ忡�� Ű �Է� �̺�Ʈ�� �����Ͽ� �ڵ����� �������� �߰�
    var phoneNumberInput = document.querySelector('input[name="phone_number"]');
    phoneNumberInput.addEventListener('keyup', formatPhoneNumber);

    document.querySelector('form').addEventListener('submit', function(event) {
        var passwordInput = document.querySelector('input[name="password"]');
        var password = passwordInput.value;

        if (!isPasswordValid(password)) {
            event.preventDefault(); // �� ���� ����
            document.getElementById('passwordError').style.display = 'block';
            passwordInput.focus();
        }
    });

    function isPasswordValid(password) {
        // ������ ������ �������� 4�ڸ� �̻����� �˻�
        var pattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$/;
        return pattern.test(password);
    }

    function isEmailValid(email) {
        // �̸��� �������� �˻�
        var pattern = /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/;
        return pattern.test(email);
    }
</script>
<% String memberId = (String) session.getAttribute("loggedInId"); %>
<h1>�� ���� ���� - <%=memberId%></h1>
<form action="manageMyInfo.jsp" method="post">
    <table>
        <tr>
            <td><b>��й�ȣ:</b></td>
            <td>
                <input type="password" name="password" placeholder="����+���� 4�ڸ� �̻�" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$" required>
                <div id="passwordError" class="error-message">��й�ȣ�� ������ ������ �������� 4�ڸ� �̻��̾�� �մϴ�.</div>
            </td>
        </tr>
        <tr>
            <td><b>�̸�:</b></td>
            <td><input type="text" name="name" placeholder="�̸�" required></td>
        </tr>
        <tr>
            <td><b>��ȭ��ȣ:</b></td>
            <td>
                <input type="text" name="phone_number" pattern="\d{3}-\d{4}-\d{4}" placeholder="��ȭ��ȣ (��: 010-1234-5678)" required>
                <div class="error-message">��ȭ��ȣ�� �������� �����Ͽ� �Է����ּ���.</div>
            </td>
        </tr>
        <tr>
            <td><b>�̸���:</b></td>
            <td><input type="email" name="email" placeholder="�̸��� (��: example@example.com)" required></td>
        </tr>
    </table>
    <input type="hidden" name="id" id="id" value="<%= request.getParameter("id") %>">
    <input type="submit" value="����">
</form>
</body>
</html>
