<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일 업로드 폼</h3>
<form action="/up" method="post" enctype="multipart/form-data">
파일:<input type="file" name="f"><br/>
제목:<input type="text" name="title"><br/>
<input type="submit" value="업로드">
</form>
</body>
</html>