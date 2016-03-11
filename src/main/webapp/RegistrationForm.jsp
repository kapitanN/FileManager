<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/buttonStyle.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/additional-methods.min.js"></script>
	<script type="text/javascript" src="js/signupvalidation.js"></script>
</head>
<body>
<div  class="registration">
	<form action="registration" method="post" id="registrationform">
		<p class="title">Name</p>
		<input type="text" name="firstName">
		<p class="title">Last name</p>
		<input type="text" name="lastName">
		<p class="title">Login</p>
		<input type="text" name="login">
		<p class="title">Password</p>
		<input type="password" name="password">
		<p></p>
		<button class="button">Sign up</button>
	</form>
</div>
<br>
<div class="registration">
	<form>
		<a href="AuthenticationForm.jsp" class="button">Log In</a>
	</form>
</div>
</body>
</html>