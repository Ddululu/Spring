<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSP를 컴파일 할 때 태그가 정의된 위치로 가서 반복해주는 정의문--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3>도시 목록</h3>
<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>countryCode</th>
    <th>population</th>
</tr>
<%--    items는 모델로부터 반복자로 값을 가져오고 var="code"는 이 값들을 저장한다.--%>
<c:forEach var="c" items="${list}">
    <tr>
        <td>${c.id}</td>
        <td><a href="/city/detail?id=${c.id}">${c.name}</a></td>
        <td>${c.district}</td>
        <td>${c.countryCode}</td>
        <td>${c.population}</td>
    </tr>
</c:forEach>
</table>
<script>console.log(${code})</script>
</body>
</html>