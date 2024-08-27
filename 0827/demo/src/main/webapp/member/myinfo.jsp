<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = () => {
		if('${m.type}'=='구매자'){
			document.getElementById("op1").selected = true;
		} else {
			document.getElementById("op2").selected = true;
		}
	}
</script>
</head>
<body>
<h3>내 정보</h3>
<form action="/member/edit" method="post">
<table border="1">
<tr><th>ID</th>
	<td>
		<input type="text" name="id" value="${m.id }" readonly>
	</td>
</tr>
<tr><th>NAME</th><td><input type="text" name="name" value="${m.name }" ></td></tr>
<tr><th>EMAIL</th><td><input type="email" name="email" value="${m.email }" ></td></tr>
<tr><th>TYPE</th>
	<td>
		<select name="type">
			<option id="op1">구매자</option>
			<option id="op2">판매자</option>
		</select>
	</td>
</tr>
<tr><th>JOIN</th><td><input type="submit" value="수정"></td></tr>
</table>
</form>
</body>
</html>