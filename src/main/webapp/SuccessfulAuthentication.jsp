<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/storage.css" rel="stylesheet">
</head>
<body>
<div>${user.login }</div>
<%--<div class="container-fluid">--%>
	<div class="container"><c:forEach var="file" items = "${lst}">
		<c:if test="${file.directory == true}">
			<div class="col-md-4 col-xs-10 file-block ">
				<span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
				<div class="folder-name">${file.name}</div>
			</div>
		</c:if>
		<c:if test="${file.file eq true}">
			<div class="col-md-4 col-xs-10 file-block ">
				<span class="glyphicon glyphicon-file" aria-hidden="true"></span>
				<div class="folder-name">${file.name}</div>
			</div>
		</c:if>
	</c:forEach></div>
<%--</div>--%>
<%--<div class="container-fluid">--%>
	<%--<div class="file-block col-xs-2">--%>
		<%--<span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>--%>
		<%--<div class="folder-name">folder 1</div>--%>
	<%--</div>--%>
	<%--<div class="file-block col-xs-2">--%>
		<%--<span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>--%>
		<%--<div class="folder-name">folder 2</div>--%>
	<%--</div>--%>
	<%--<div class="file-block col-xs-2">--%>
		<%--<span class="glyphicon glyphicon-file" aria-hidden="true"></span>--%>
		<%--<div class="folder-name">file 2</div>--%>
	<%--</div>--%>
<%--</div>--%>
</body>
</html>