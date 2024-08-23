<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>메인 페이지</title>
</head>
<body>
<h1>방명록</h1>
<c:if test="${list.size()==0}">
    작성된 글이 없습니다.
</c:if>
<%--if 태그에 else가 없어서 다시 if문 사용.--%>
<c:if test="${list != null}">
    <table border="1">
        <tr>
            <th>글 번호</th>
            <th>작성자</th>
        </tr>
        <c:forEach var="g" items="${list}">
        <tr>
            <th>${g.index}</th>
            <th><a href="/guest/detail?index=${g.index}">${g.writer}</a></th>
            <th>${g.wdate}</th>
        </tr>
        </c:forEach>
</c:if>
<ol>
    <li><a href="/guest/add">글작성</a></li>
    <li><a href="/guest/edit">글 수정</a></li>
</ol>
</body>
</html>
