<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>join</h3>
  <form action="/join" method="post">
		Name:<input type="text" id="name" name="name" > <br/>
		Password:<input type="password" id="password" name="password" ><br/>
		Email: <input type="email" id="email" name="email" ><br/>
		Address:<input type="text" id="addr" name="addr"><br/>
		Memo:<textarea id="memo" name="memo"></textarea><br/>
		<button type="submit">Submit</button>
    </form>
</body>
</html>