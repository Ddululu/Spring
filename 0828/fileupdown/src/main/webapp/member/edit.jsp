<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원정보</h3>
<form action="/member/edit" method="post">
id:<input type="text" name="id" value="${m.id }" readonly><br/>
pwd:<input type="text" value="${m.pwd }" readonly><br/>
new pwd:<input type="password" name="pwd"><br/>
name:<input type="text" name="name" value="${m.name }" readonly><br/>
email:<input type="text" name="email" value="${m.email }" readonly><br/>
type:<input type="text" name="type" value="${m.type }" readonly><br/>
<input type="submit" value="변경">
<a href="/member/list">멤버 목록으로</a>
</form>
</body>
</html>