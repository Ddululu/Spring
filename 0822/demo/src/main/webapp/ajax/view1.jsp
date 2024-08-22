<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 22.
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script type="text/javascript">
    const a = () =>{
      /* 비동기 요청 객체 생성 */
      let req = new XMLHttpRequest();
      /* 서버로부터 응답이 오면 호출 될 핸들러 구성.
      받은 응답은 XMLHttpRequest 객체의 responseText 속성으로 넘겨준다. */
      req.onload = () => {
        let res = document.getElementById("res");
        res.innerHTML = req.responseText;
      };

    // 페이지 내에서 입력 값을 받아 변수에 저장
    let num = document.getElementById("num").value;
    let name = document.getElementById("name").value;
    let params = 'num='+encodeURIComponent(num)+'&name='+encodeURIComponent(name);

    //open()로 요청 정보를 설정, true는 비동기 요청을 의미
    req.open('GET', 'test1?' + params, true);

    // 요청을 보내기
    req.send();            // GET 방식
    }
    const b = () =>{
        /* 비동기 요청 객체 생성 */
        let req = new XMLHttpRequest();
        /* 서버로부터 응답이 오면 호출 될 핸들러 구성.
        받은 응답은 XMLHttpRequest 객체의 responseText 속성으로 넘겨준다. */
        req.onload = () => {
            let res = document.getElementById("res");
            res.innerHTML = req.responseText;
        };

        // 페이지 내에서 입력 값을 받아 변수에 저장
        let num = document.getElementById("num").value;
        let name = document.getElementById("name").value;
        let params = 'num='+num+'&name='+name;

        //open()로 요청 정보를 설정, true는 비동기 요청을 의미
        req.open('post', 'test2', true);
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 요청을 보내기
        req.send(params);            // POST 방식
    }
    const c = () =>{
        /* 비동기 요청 객체 생성 */
        let req = new XMLHttpRequest();
        /* 서버로부터 응답이 오면 호출 될 핸들러 구성.
        받은 응답은 XMLHttpRequest 객체의 responseText 속성으로 넘겨준다. */
        req.onload = () => {
            let res = document.getElementById("res");
            console.log(req.responseText);
            let obj = JSON.parse(req.responseText);
            console.log(obj)
            let num = obj.num;
            let name = obj.name;
            res.innerHTML = "num: " + num + "name: " +name
        };

        // 페이지 내에서 입력 값을 받아 변수에 저장
        let num = document.getElementById("num").value;
        let name = document.getElementById("name").value;
        let params = 'num='+encodeURIComponent(num)+'&name='+encodeURIComponent(name);

        //open()로 요청 정보를 설정, true는 비동기 요청을 의미
        req.open('post', 'test3', true);
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 요청을 보내기
        req.send(params);            // POST 방식
    }
    const d = () =>{
        /* 비동기 요청 객체 생성 */
        let req = new XMLHttpRequest();
        /* 서버로부터 응답이 오면 호출 될 핸들러 구성.
        받은 응답은 XMLHttpRequest 객체의 responseText 속성으로 넘겨준다. */
        req.onload = () => {
            let res = document.getElementById("res");
            console.log(req.responseText);
            let obj = JSON.parse(req.responseText);
            console.log(obj)
            let name = obj[0];
            let num = obj[1];
            res.innerHTML = "num: " + num + "name: " +name
        };

        // 페이지 내에서 입력 값을 받아 변수에 저장
        let num = document.getElementById("num").value;
        let name = document.getElementById("name").value;
        let params = 'num='+encodeURIComponent(num)+'&name='+encodeURIComponent(name);

        //open()로 요청 정보를 설정, true는 비동기 요청을 의미
        req.open('post', 'test4', true);
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 요청을 보내기
        req.send(params);            // POST 방식
    }
  </script>
</head>
<body>
<h3>ajax get 요청</h3>
num:<input type="number" id="num"><br/>
name:<input type="text" id="name"> <br/>
<input type="button" value="get/string" onclick="a()">
<input type="button" value="post/string" onclick="b()">
<input type="button" value="post/json" onclick="c()">
<input type="button" value="post/json" onclick="d()">
<div id="res">

</div>
</body>
</html>
