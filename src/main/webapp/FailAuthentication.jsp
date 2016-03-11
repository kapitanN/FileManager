<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="css/buttonStyle.css" rel="stylesheet">
</head>
<body>
<form action = "${toServlet}" method = "post">
	<p style="color: gold; font-size: 1.5em;">Please,sign up or enter login and password again.</p>
</form>
<a href="RegistrationForm.jsp" class = "button">Sign up</a>
<a href="AuthenticationForm.jsp" class = "button">Log In</a>
</body>
</html>