<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container mt-3">
	<form action="/loginPro" method="post">
		<div class="mb-3 mt-3">
			<label for="username">아이디:</label> <input type="text"
				class="form-control" id="username" placeholder="Enter id" name="username">
		</div>

		<div class="mb-3">
			<label for="password">비밀번호:</label> <input type="password"
				class="form-control" id="password" placeholder="Enter password"
				name="password">
		</div>
		<button type="submit" class="btn btn-secondary">로그인</button>
	</form>
</div>
</body>
</html>
