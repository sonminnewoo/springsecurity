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
<h3>update</h3>
ID:<input type="text" name="id" value="${member.id}" readonly="readonly"/>
Name:<input type="text" id="name" name="name" > <br/>
Password:<input type="password" id="password" name="password" ><br/>
Email: <input type="email" id="email" name="email" ><br/>
Address:<input type="text" id="addr" name="addr"><br/>
Memo:<textarea id="memo" name="memo"></textarea><br/>
<button type="button">수정하기</button>
</body>
</html>