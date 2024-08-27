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
    <title>게시판</title>
    <script>
        const a = (index) => {
            /* 비동기 요청 객체 생성 */
            let req = new XMLHttpRequest();
            /* 서버로부터 응답이 오면 호출 될 핸들러 구성.
            받은 응답은 XMLHttpRequest 객체의 responseText 속성으로 넘겨준다. */
            req.onload = () => {
                console.log(req.responseText);
                let res = document.getElementById("res");
                let obj = JSON.parse(req.responseText);
                console.log(obj);
                let txt = "글 상세 내용<br/>";
                txt += "index: " + obj.index + "<br/>";
                txt += "writer: " + obj.writer + " <br/>";
                txt += "date: " + obj.wdate + " <br/>";
                txt += "title: " + obj.title + " <br/>";
                txt += "content: " + obj.content + " <br/>";
                res.innerHTML = txt;
            };

            // 페이지 내에서 입력 값을 받아 변수에 저장
            let params = 'index=' + index;

            //open()로 요청 정보를 설정, true는 비동기 요청을 의미
            req.open('GET', './getAjax?' + params, true);

            // 요청을 보내기
            req.send();            // GET 방식
        }
        const b = () => {
            let res = document.getElementById("res");
            res.innerHTML = "";
        }
    </script>
</head>
<body>
<h3>Board</h3>
//
<a href="">오늘 읽은 글목록</a>
<a type="button" href="add" value="글쓰기">글쓰기</a><br/>
<form action="/search">
    <select class="choice" id="gettype">
        <option>작성자</option>
        <option>제목</option>
    </select>
    <input type="search" id="gsearch" name="gsearch">
    <a href="search?${gettype}"><input type="button" value="검색"></a>
</form>
<div>
    <table border="1">
        <tr>
            <th>Index</th>
            <th>Title</th>
            <th>Writer</th>
        </tr>
        <c:forEach var="b" items="${list}">
            <tr>
                <td><a href="detail?index=${b.index}">${b.index}</a></td>
                <td><span id="index" onmouseover="a(${b.index})" onmouseout="b()">${b.title}</span></td>
                <td>${b.writer}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="res" style="position:absolute; top:100px;left:300px;">

</div>
</body>
</html>
