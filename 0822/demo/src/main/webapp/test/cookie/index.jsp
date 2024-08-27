<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 23.
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> 쿠키 테스트 </h3>
<p><a href="add?num=1&name=aaa">쿠키 추가버튼 </a></p>
<p><a href="list">쿠키 목록</a></p>
<p>cookie.num.name : ${cookie.num.name}</p>
<p>cookie.num.value : ${cookie.num.value}</p>
<p>cookie.JSESSIONID.name : ${cookie.JSESSIONID.name}</p>
<p>cookie.JSESSIONID.value : ${cookie.JSESSIONID.value}</p>
</body>
</html>
