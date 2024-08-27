<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 23.
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--  <script>--%>
<%--    window.onload=()=>{--%>
<%--      if("${m.type}"=="구매자")--%>
<%--      document.getElementById("op1").selected=true;--%>
<%--    }else--%>
<%--      document.getElementById("op2").selected=true;--%>
<%--  </script>--%>
</head>
<body>
<h2>Weekly Coding Challenge #2: Display User info</h2>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="./edit" method="post" name="f">
      <h1>User Info</h1>
      <p><input type="text" name="id" value="${account.id}" readonly ></p>
      <p><input type="text" name="name" value="${account.name}"/></p>
      <p><input type="email" name="email" value="${account.email}"/></p>
      <p><select name="type">
        <option id="op1">구매자</option>
        <option id="op2">판매자</option>
      </select>
      </p>
      <input type="submit" value="수정"/>
    </form>
  </div>
</div>
</body>
</html>
