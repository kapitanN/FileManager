<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="css/buttonStyle.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/additional-methods.min.js"></script>
    <script type="text/javascript" src="js/loginvalidation.js"></script>
</head>
<body>
<div id="logform">
    <form action="authentication" method="post" id="loginform">
        <p class="title">Login</p>
        <input type="text" name="login">
        <p class="title">Password</p>
        <input type="password" name="password" class="login">
        <p>
            <button class="button">Log in</button>
        </p>
        <a href="RegistrationForm.jsp" class="button">Sign up</a>
    </form>
</div>
</body>
</html>