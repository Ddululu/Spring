<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
const check = () => {
	if(f.id.value.length<=0){
		alert("id는 필수 입력 사항");
		f.id.focus();
		return;
	}
	if(f.pwd.value.length<=0){
		alert("pwd는 필수 입력 사항");
		f.pwd.focus();
		return;
	}
	if(!flag){
		alert("id 중복체크 해야함");
		return;
	}
	f.submit();//폼을 action에 지정된 서버로 제출
}

//id 중복체크 결과 저장
let flag = false;

const a = () => {
	flag = false;
	const req = new XMLHttpRequest();
	req.onload = () => {
		let obj = JSON.parse(req.responseText);//req.responseText => {flag:true}
		let txt = '중복된 아이디';
		if(obj.flag){
			txt = '사용가능 아이디';
			flag = true;
		}
		document.getElementById('res').innerHTML = txt;
	}
	let id = document.getElementById('id').value;
	req.open('get', '/member/idcheck?id='+id);
	req.send();
}

</script>
</head>
<body>
<h3>회원가입</h3>
<form action="/member/join" method="post" name="f">
<table border="1">
	<tr>
		<th>ID</th>
		<td>
			<input type="text" name="id" id="id">
			<input type="button" value="중복체크" onclick="a()"><br/>
			<span id="res"></span>
		</td>
	</tr>
	<tr>
		<th>PWD</th><td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<th>NAME</th><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>EMAIL</th><td><input type="text" name="email"></td>
	</tr>
	<tr>
		<th>TYPE</th>
		<td>
			<input type="radio" name="type" value="2" checked>구매자 
			<input type="radio" name="type" value="1">판매자  
			<input type="radio" name="type" value="3">관리자 
		</td>
	</tr>
	<tr>
		<th>JOIN</th><td><input type="submit" value="가입"></td>
	</tr>
</table>
</form>
</body>
</html>