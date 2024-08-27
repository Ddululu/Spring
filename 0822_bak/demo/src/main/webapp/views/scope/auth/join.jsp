<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 22.
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        const a = () =>{
            /* 비동기 요청 객체 생성 */
            let req = new XMLHttpRequest();
            /* 서버로부터 응답이 오면 호출 될 핸들러 구성.
            받은 응답은 XMLHttpRequest 객체의 responseText 속성으로 넘겨준다. */
            req.onload = () => {
                console.log(req.responseText);
                let res = document.getElementById("res");
                    res.innerHTML = req.responseText;
            };

            // 페이지 내에서 입력 값을 받아 변수에 저장
            let id = document.getElementById("id").value;
            let params = 'id='+id;

            //open()로 요청 정보를 설정, true는 비동기 요청을 의미
            req.open('GET', 'check?' + params, true);

            // 요청을 보내기
            req.send();            // GET 방식
        }
    </script>
</head>
<body>
<h2>Weekly Coding Challenge #1: Sign up Form</h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="./join" method="post" name="f">
            <h1>Create Account</h1>
            <p><input type="text" id="id" placeholder="ID" name="id"/>
                <input type="button" value="중복체크" onClick="a()">
                <span id="res"></span></p>
            <p><input type="password" placeholder="PASSWORD" name="pwd"/></p>
            <p><input type="text" placeholder="Name" name="name"/></p>
            <p><input type="email" placeholder="Email" name="email" /></p>
           <p><select name="type">
                <option>구매자</option>
                <option>판매자</option>
            </select>
           </p>
            <input type="submit" value="SignUp"/>
        </form>
    </div>
</div>
</body>
</html>
