<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 21.
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Title here</title>
</head>
<body>
<h1>글작성폼</h1>
<form action="/guest/add" method="post">
<table>
  <tr>
    <th>작성자</th>
    <td><input type="text" name="writer"></td>
  </tr>
  <tr>
    <th>비밀번호</th>
    <td><input type="password" name="pwd"></td>
  </tr>
  <tr>
    <th>내용</th>
    <td><input type="text" name="content"></td>
  </tr>
  <tr>
    <th>작성</th>
    <td><input type="submit" value="작성"></td>
  </tr>
</table>
</form>
</body>
</html>
