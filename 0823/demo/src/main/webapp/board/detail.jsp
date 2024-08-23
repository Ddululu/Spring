<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 23.
  Time: 오후 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script>
        const a = () =>{console.log("hello World!")}
    </script>
</head>
<body>
<h3> 상세 페이지 </h3>
<form action="edit" method="post">
    <c:if test="${sessionScope.loginId !=board.writer}">
        <c:set var="str">readonly</c:set> <!-- let str = "readonly" -->
    </c:if>
    <p>작성번호: <input type="text" name="index" value="${board.index}" readonly/></p>
    <p>작성자: <input type="text" name="writer"value="${board.writer}" readonly/></p>
    <p>작성일: <input type="date" name="wdate" value="${board.wdate}" readonly/> </p>
    <p>Title: <input type="text" name="title" value="${board.title}" ${str}/></p>
    <p>Contents: <input type="text" name="content" value="${board.content}" ${str}/></p>
<%-- SessionID를 받아서 자신의 글이면 수정 및 삭제 버튼이 보임.
자신의 ID가 아니면 안보여줌
 <p><input type="submit" value="Commit"/></p>--%>
    <c:if test="${sessionScope.loginId==board.writer}">
        <p><input type="submit" value="Commit"/></p>
        <p><a href="./delete?index=${board.index}"><input type="button" value="Drop"></a></p>
    </c:if>
</form>
</body>
</html>
