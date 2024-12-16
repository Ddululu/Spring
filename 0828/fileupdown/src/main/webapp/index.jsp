<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일 업/다운 로드</h3>
<c:if test="${empty sessionScope.loginId }">
<a href="/member/join">회원가입</a><br/>
<a href="/member/login">로그인</a><br/>
${sessionScope.msg }<br/>
</c:if>
<c:if test="${not empty sessionScope.loginId }">
<a href="/member/logout">로그아웃</a><br/>
<a href="/imgboard/list">글목록</a><br/>
</c:if>
</body>
</html>