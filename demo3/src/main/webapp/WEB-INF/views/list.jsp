<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<h3>list</h3>
<div id="memberDiv">
	<c:forEach items="${arr}" var="member">
		아이디:${member.id}<br/>
		이름:${member.name}<br/>
		이메일:${member.email}<br/>
		주소:${member.addr}<br/>
		메모:${member.memo}<br/>
		<a href="view/${member.id}">상세보기</a>
		<button type="button" onclick="fdelete(${member.id})">fdelete삭제</button><br/>
		<button type="button" id="btnDel" data-mid="${member.id }">삭제</button><br/>
		<!-- data-mid="${member.id }" 이부분으로 무엇을 정해서 삭제하는지 알수 있다 .
		그리고 data- 는 동일하게 뒤에는 마음대로 선생님은 mid 를 멤버아이디 라서 저렇게 정하셨다 -->
		<!-- <a href="">삭제</a> -->
		
	</c:forEach>
</div>
<script>
	$("#memberDiv").on("click","#btnDel",function() {
		//alert($(this).attr('data-mid')); 불러올때 아예 이렇게attr 로  'data-mid' 지정할수있다
		//alert($(this).data('mid')) // data 라는것중에서 mid 를 불러오는것
		$.ajax({
			type:"DELETE",
			url:'delete/'+$(this).data('mid')
		})
			.done(function(resp){
			alert(resp + "번 삭제성공")
			location.href="/list"
		})
			.fail(function(){
			alert("삭제 실패")
		})
	})
$("#btnDel").click(function(){
    var memberId = $(this).data("member-id");
}
function fdelete(id) {
	$.ajax({
		type:"DELETE",
		url:'delete/'+id
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