<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
    <%--pageEncoding="UTF-8"%>--%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="registration" method="post">
	<input type = "text" name = "firstName">
	<input type = "text" name = "lastName">
	<input type = "text" name = "login">
	<input type = "password" name = "password">
	<input type="submit" value = "Sign up"/>
</form>
<br/>
<form action="AuthenticationForm.jsp" method="post">
	<input type = "submit" value = "Sign in">
</form>
</body>
</html>