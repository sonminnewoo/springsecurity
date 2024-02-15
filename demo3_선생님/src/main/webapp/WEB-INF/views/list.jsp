<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h3>List</h3>
	<div id="memberDiv">
		<c:forEach items="${arr }" var="member">
			아이디 : ${member.id } <br />
			이름 :  ${member.name } <br />
			이메일 :  ${member.email } <br />
			주소 :  ${member.addr } <br />
			메모 :  ${member.memo }  <br />
			<a href="view/${member.id }">상세보기</a>
			<button type="button" onclick="fdelete(${member.id })">fdelete삭제</button>
			<button type="button" id="btnDel" data-mid="${member.id }">삭제</button>
			<br />
			<br />
		</c:forEach>
	</div>
	<script>
	delfun = function(){
		$.ajax({
			type:'DELETE',
			url : 'delete/'+$(this).data("mid")
		})
		.done(function(resp){
			alert(resp + "번 삭제성공")
			location.href="/list"
		})
		.fail(function(){
			alert("삭제 실패")
		})
	}
	$("#memberDiv").on("click", "#btnDel", delfun);
/* 	$("#memberDiv").on("click", "#btnDel",function(){
		//alert($(this).attr('data-mid'));
		//alert($(this).data('mid'))
				$.ajax({
				type:'DELETE',
				url : 'delete/'+$(this).data("mid")
			})
			.done(function(resp){
				alert(resp + "번 삭제성공")
				location.href="/list"
			})
			.fail(function(){
				alert("삭제 실패")
			})
	}) */
function fdelete(id){
	$.ajax({
		type:'DELETE',
		url : 'delete/'+id
	})
	.done(function(resp){
		alert(resp + "번 삭제성공")
		location.href="/list"
	})
	.fail(function(){
		alert("삭제 실패")
	})
	
}

</script>

</body>
</html>





