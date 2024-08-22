<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--JSP를 컴파일 할 때 태그가 정의된 위치로 가서 반복해주는 정의문--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3>도시 추가</h3>
<form action="/city/add" method="post">
name: <input type="text" id="name" name="name"> <br />
countryCode: <select name="countryCode">
<%--    items는 모델로부터 반복자로 값을 가져오고 var="code"는 이 값들을 저장한다.--%>
    <c:forEach var="code" items="${list}">
        <option>${code}</option>
    </c:forEach>

</select><br/>
district:  <input type="text" id="district" name="district"><br/>
population: <input type="number" id="population" name="population"> <br/>
<input type="submit"></input>
</form>
</body>
</html>