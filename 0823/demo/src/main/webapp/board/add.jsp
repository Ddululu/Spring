<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 23.
  Time: 오후 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Board</title>
</head>
<body>
<H2>Create Board Contents</H2>
<form action="add" method="post">
    <legend> 게시글 작성 </legend>
    <p>writer: <input type="text" name="writer" value="${sessionScope.loginId}" readonly/></p>
    <p>title: <input type="text" name="title" /></p>
    <p>contents: <input type="text" name="content"/></p>
    <p><input type="submit" value="Commit"/></p>
</form>
</body>
</html>
