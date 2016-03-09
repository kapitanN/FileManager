<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>Insert title here</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/storage.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
	<script type="text/javascript" src="js/ajaxupload.3.5.js" ></script>
	<link rel = "stylesheet" type="text/css" href="css/blocks.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css" />
	<link rel="stylesheet" type="text/css" href="css/buttonStyle.css" />
	<script type="text/javascript" src = "js/Ajax.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript" src="http://scriptjava.net/source/scriptjava/scriptjava.js"></script>
</head>
<body>
<div id="container">
	<div id="header">
		<div >
			${user.login }
		</div>
		<div style= "float: right">
			<form action = "/LogOutServlet" method="post">
				<button type="submit" name="logOut">Log out</button>
			</form>
		</div>
		<div style="float: right; margin-right: 5px ">
			<form action="/DeleteUser" method="post">
				<button type="submit" name="delete">Delete account</button>
			</form>
		</div>
		<div style=" width:100%; height:1px; clear:both;"></div>
	</div>
	<div id="sidebar">
		<form action="/UploadServlet" method="post" enctype="multipart/form-data">
			<input name="data" type="file" value="Select file" style="width: 100%"><br>
			<input type="submit" value="Upload"><br>
		</form>
		<br>
		<button>Create folder</button>
		<form action="/CreateServlet" method="post">
				<p style="display: none"><input id ="folderName" type="text" name="folderName" style="width: 100%"></p>
				<p style="display: none"><button id="btn" type="submit">Create</button></p>
		</form>
	</div>
	<div id="content">
		<c:forEach var="file" items="${lst}">
			${file.name}
		</c:forEach>
		<div id="container-fluid" class="container-fluid"><c:forEach var="file" items="${lst}">
			<c:if test="${file.directory == true}">
				<form id="storage${file.name}" action="storage">
					<input id="${file.name}" type="hidden" name="path"/>
					<div class="col-md-3 col-xs-10 file-block" onclick="redirect('${currentPath}','${file.name}')">
						<span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
						<h2 class="folder-name">${file.name}</h2>
					</div>
				</form>
			</c:if>
			<c:if test="${file.file eq true}">
				<div class="col-md-3 col-xs-10 file-block ">
					<span class="glyphicon glyphicon-file" aria-hidden="true"></span>
					<div class="folder-name">${file.name}</div>
				</div>
			</c:if>
		</c:forEach></div>
	</div>
</div>
</div>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function(){
		$("button").click(function () {
			$("p").toggle('normal');
		});
	});
</script>
<script type="application/javascript">
	function redirect(current, future) {
		var storageForm = document.getElementById("storage" + future);
		var storageInput = document.getElementById(future);
		storageInput.value = current + future;
		storageForm.submit();
	}
</script>
</body>
</html>