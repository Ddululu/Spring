<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원목록</h3>
<table border="1">
<tr><th>ID</th><th>NAME</th><th>EMAIL</th></tr>
<c:forEach var="m" items="${list }">
<tr>
	<td><a href="/member/edit?id=${m.id }">${m.id }</a></td>
	<td>${m.name }</td><td>${m.email }</td>
</tr>
</c:forEach>
</table>
</body>
</html>