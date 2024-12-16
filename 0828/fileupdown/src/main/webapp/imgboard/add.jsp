<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글작성</h3>
<form action="/imgboard/add" method="post" enctype="multipart/form-data">
작성자:<input type="text" name="writer" value="${sessionScope.loginId }" readonly><br/>
title: <input type="text" name="title"><br/>
content:<textarea rows="10" cols="15" name="content"></textarea><br/>
img:<input type="file" name="f"><br/>
<input type="submit" value="작성">
<a href="/imgboard/list">글목록으로</a>
</form>
</body>
</html>