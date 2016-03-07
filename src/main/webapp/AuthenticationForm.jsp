<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="css/buttonStyle.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <form action="authentication" method="post">
        <p class="title">Login</p>
        <input type="text" name="login">
        <p class="title">Password</p>
        <input type="password" name="password" class="login">
        <p><button class="button">Log in</button></p>
        <a href="RegistrationForm.jsp" class="button">Sign up</a>
    </form>
</body>
</html>