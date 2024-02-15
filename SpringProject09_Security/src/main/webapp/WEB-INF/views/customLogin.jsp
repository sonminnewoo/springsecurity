<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<div class="container mt-3">
	<form action="login" method="post">
		<div class="mb-3 mt-3">
			<label for="id">아이디:</label> <input type="text"
				class="form-control" id="id" placeholder="Enter id" name="id">
		</div>

		<div class="mb-3">
			<label for="password">비밀번호:</label> <input type="password"
				class="form-control" id="password" placeholder="Enter password"
				name="password">
		</div>
		<button type="button" class="btn btn-secondary" id="btnLogin">로그인</button>
	</form>
</div>
<script>
$("#btnLogin").click(function(){
	$.ajax({
		type : "post",
		url : '/member/login',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify({
			id : $("#id").val(),
			password : $("#password").val()
		})
	})  //ajax
	.done(function(resp){
		//alert(resp);  //no , success, fail
		if(resp== "no"){
			alert("회원이 아닙니다. 회원가입하세요")
			location.href="/member/join"
		}else if(resp=="success"){
			alert("로그인성공")
			location.href="/list"
		}else{  //fail
			alert("비밀번호를 확인하세요")	
		}
	})
	.fail(function(){
		alert("로그인실패")
	})
}) //btnLogin

</script>

</head>
<body>