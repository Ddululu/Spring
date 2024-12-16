<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = (num) => {
	f.num.value = num;
	f.title.value = document.getElementById('t_'+num).value;
	f.content.value = document.getElementById('c_'+num).value;
	f.style.display = '';
}
const b = (num) => {
	location.href = "/imgboard/del?num="+num;
}
const c = (parent) => {
	let content = document.getElementById('repval_'+parent).value;
	let params = 'writer=${sessionScope.loginId}';
	params += '&parent='+parent;
	params += '&content='+content;
	const req = new XMLHttpRequest();
	req.onload = () => {
		//alert(req.responseText);
		let obj = JSON.parse(req.responseText);//req.responseText => {flag:true}
		let arr = obj.reps;
		let txt = '';
		for(let r of arr){
			txt += 'num:'+r.num+' / content:'+r.content+' / writer:'+r.writer.id+'<br/>';
		}
		document.getElementById('res_'+parent).innerHTML = txt;
	}
	req.open('post', '/imgboard/addrep');
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	req.send(params);	
}
const d = (num) => {
	location.href="/imgboard/editcnt?num="+num;
}
</script>
</head>
<body>
<h3>이미지 게시판</h3>
<form id="editf" name="f" action="/imgboard/edit" method="post" style="background-color:gray;display:none;position:absolute;top:150px;left:150px">
	글번호:<input type="text" name="num" readonly><br/>
	제목:<input type="text" name="title" ><br/>
	내용:<textarea name="content"></textarea><br/>
	<input type="submit" value="수정완료">
	<input type="button" value="취소" onclick="javascript:f.style.display='none'">
</form>
<a href="/imgboard/add">글작성</a><br/>
<c:forEach var="i" items="${list }">
<table border="1">
<tr><th>글번호</th>
	<td>
		<input type="text" value="${i.num }" readonly>
		<c:if test="${sessionScope.loginId == i.writer.id }">
			<input type="button" value="수정" onclick="a(${i.num })">
			<input type="button" value="삭제" onclick="b(${i.num })">
		</c:if>
	</td>
</tr>
<tr><th>작성자</th><td><input type="text" value="${i.writer.id }" readonly></td></tr>
<tr><th>작성일</th><td><input type="text" value="${i.wdate }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" id="t_${i.num }" value="${i.title }" readonly></td></tr>
<tr><th>이미지</th><td><img src="/imgboard/read-img?fname=${i.fname }" style="width:150px;height:150px"></td></tr>
<tr><th>내용</th><td><textarea id="c_${i.num }" readonly>${i.content }</textarea></td></tr>
<tr><th>좋아요</th><td>좋아요:${i.cnt }<input type="button" value="좋아요" onclick="d(${i.num })"></td></tr>
<tr><th>댓글작성</th>
	<td>
		댓글: <input type="text" id="repval_${i.num }" >
		<input type="button" value="작성" onclick="c(${i.num })">
	</td>
</tr>
<tr><th>댓글목록</th>
	<td id="res_${i.num }">
		<c:forEach var="r" items="${i.reps }">
		num:${r.num } / content:${r.content } / writer:${r.writer.id }<br/>
		</c:forEach>
	</td>
</tr>
</table>
</c:forEach>
</body>
</html>