<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container mt-3">
	<h3>${board.writer }의글보기</h3>
	<div class="mb-3 mt-3">
		<label for="num">Num:</label> <input type="text" class="form-control"
			id="num" value="${board.num }" readonly="readonly">
	</div>
	<div class="mb-3 mt-3">
		<label for="title">Title:</label> <input type="text"
			class="form-control" id="title" value="${board.title }"
			readonly="readonly">
	</div>
	<div class="mb-3">
		<label for="writer">Writer:</label> <input type="text"
			class="form-control" id="writer" value="${board.writer }"
			readonly="readonly" name="writer">
	</div>
	<div class="mb-3 mt-3">
		<label for="content">Content:</label>
		<textarea class="form-control" rows="5" id="content" name="content"
			readonly="readonly">${board.content }</textarea>
	</div>
	<sec:authorize access="isAuthenticated()">
		<c:if test="${pinfo.username == board.writer }">
			<div class="text-end">
				<button type="button" class="btn btn-secondary btn-sm"
					id="btnUpdate">수정</button>
				<button type="button" class="btn btn-danger btn-sm" id="btnDelete">삭제</button>
				<a href="/delete/${board.num }">삭제111</a> <a
					href="/delete?num=${board.num }">삭제222</a>
			</div>
		</c:if>
	</sec:authorize>
	<div class="mb-3 mt-3">
		<label for="msg">Comment:</label>
		<textarea class="form-control" rows="3" id="msg" name="msg"></textarea>
	</div>
	<button class="btn btn-success btn-sm" id="commentBtn">Comment
		Write</button>
	<div id="replyResult" class="mt-3"></div>

</div>
<script>
var init = function() {
		$.ajax({
			type : "get",
			url : "/app09/reply/commentList/${board.num}"
		}).done(function(resp) {
		/* 	let str = "댓글개수(" + resp.replyCnt + ")<br/>"; */
		    let str= ""
			$.each(resp, function(key, val) {
				str += val.userid + "  "
				str += val.content + "  "
				str += val.regdate + "  "
			   if($("#prin").val() == val.userid){
					str += "<a href='javascript:fdel(" + val.cnum + ")'>삭제</a>"  
			   }
     			str += "<br/>"
			}) //each
			$("#replyResult").html(str);
		}).fail(function() {
			alert("실패");
		})
}
$("#commentBtn").click(function(){
	  if($("#prin").val()=="null"){
		alert("로그인하세요")
		location.href="/app09/customLogin"
		 return;
	}  
		if( $("#msg").val()==""){
			alert("댓글을 입력하세요")
			return;
		}
		let data = {
				"bnum" : $("#num").val(),
				"content" : $("#msg").val(),
				 /* "userid" : $("#prin").val()  */
			}
		$.ajax({
			type : "POST",
			url : "/app09/reply/commentInsert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data)
		})
	    .done(function(){
	    	alert("댓글 추가 성공")
	    })
	    .fail(function(){
	    	alert("댓글 추가 실패")
	    })
	  
})

	//댓글 삭제
	function fdel(cnum) {
		$.ajax({
			type : "delete",
			url : '/app09/reply/delete/' + cnum
		}).done(function(resp) {
			alert(resp + "번 삭제 성공")
			init()
		}).fail(function(e) {
			alert("삭제 실패 : " + e);
		})
	}

init();

</script>
</body>
</html>

