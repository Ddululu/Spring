<%--
  Created by IntelliJ IDEA.
  User: MZC-USER
  Date: 24. 8. 21.
  Time: 오후 4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세 페이지</title>
  <script>
    const a=() =>{
    console.log("수정");
    let pwd = prompt("글 비밀번호","");
    if(pwd==${book.pwd}){
      let cont = prompt("새 글내용,");
      location.href="/guest/edit?index=${book.index}&content="+cont;
    }else{
      alert('글 비밀번호 불일치');
    }
    }
    const b=()=>{
      let pwd = prompt("글 비밀번호","");
      if(pwd==${book.pwd}){
        location.href="/guest/del?index=${book.index}"
      }else{
        alert('글 비밀번호 불일치');
      }
    }
  </script>
</head>
<body>
<h1>상세 페이지</h1>
  <table>
    <tr>
      <th>글번호</th>
      <td>${book.index}</td>
    </tr>
    <tr>
      <th>작성자</th>
      <td>${book.writer}</td>
    </tr>
    <tr>
      <th>작성일</th>
      <td>${book.wdate}</td>
    </tr>
    <tr>
      <th>내용</th>
      <td>${book.content}</td>
    </tr>
    <tr>
      <th>변경</th>
      <td>
        <input type="button" value="수정" onclick="a()">
        <input type="button" value="삭제" onclick="b()">
      </td>
    </tr>
  </table>
</body>
</html>
