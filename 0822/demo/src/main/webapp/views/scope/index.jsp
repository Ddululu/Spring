<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 22.
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Scope</title>
</head>
<body>
<c:if test="${sessionScope.loginId==null}">
    <script>window.location.href = './auth/';</script>
  <a href="./auth/">로그인</a>
</c:if>
<c:if test="${sessionScope.loginId!=null}">
  ${sessionScope.loginId}님의 타입은 ${sessionScope.type}입니다.<br/>
    <a href="">내정보 확인</a>
    <a href="">탈퇴</a>
    <a href="">게시판</a>
    <a href="./logout">로그아웃</a>
</c:if>
<br/>


</body>
</html>
