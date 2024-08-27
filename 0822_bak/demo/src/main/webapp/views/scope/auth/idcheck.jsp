<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 22.
  Time: 오후 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ID Duplication Check</title>
    <script type="text/javascript">
        window.onload = () => {
            /* 현재 페이지의 "f(form)의 입력박스 중 이름이 id인 박스의 value"를
               opener(이 페이지를 실행한 주체)의 document(페이지) 중 "f(form)의 입력박스 중 이름이 id인 박스의 value"를 가져와라
             */
            f.id.value = opener.document.f.id.value;
        }
        const b =() =>{
            close();
        }
    </script>
</head>
<body>
<h3>ID 중복 체크</h3>
<form action="./idcheck" method="post" name="f">
    <p><input type="text" name="id"></p>
    <p><input type="submit" value="중복체크"></p>
</form>
</body>
</html>
