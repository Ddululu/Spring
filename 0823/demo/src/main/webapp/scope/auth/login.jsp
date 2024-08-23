<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 22.
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>로그인 폼</h1>
    <form action="./login" method="post">
        <table border =1>
            <tr><th>ID</th><td><input type="text" name="id"></td></tr>
            <tr><th>PWD</th><td><input type="text" name="pwd"></td></tr>
        </table>
        <input type="submit" value="로그인">
        <button type="button"><a href="./join">계정 생성</a></button>
    </form>
</body>
</html>
