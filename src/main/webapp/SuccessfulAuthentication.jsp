<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>Insert title here</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/storage.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.3.2.js" ></script>
	<script type="text/javascript" src="js/ajaxupload.3.5.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/styles.css" />
	<link rel="stylesheet" type="text/css" href="js/ITHitWebDAVClient.js">
	<%--<script type="text/javascript" >--%>
		<%--$(function(){--%>
			<%--var btnUpload=$('#upload');--%>
			<%--var status=$('#status');--%>
			<%--new AjaxUpload(btnUpload, {--%>
				<%--action: '/storage',--%>
				<%--name: 'uploadfile',--%>
				<%--onComplete: function(file, response){--%>
					<%--//On completion clear the status--%>
					<%--status.text('');--%>
					<%--//Add uploaded file to list--%>
					<%--if(response==="success"){--%>
						<%--$('<li></li>').appendTo('#files').html('<img src="./uploads/'+file+'" alt="" /><br />'+file).addClass('success');--%>
					<%--} else{--%>
						<%--$('<li></li>').appendTo('#files').text(file).addClass('error');--%>
					<%--}--%>
				<%--}--%>
			<%--});--%>

		<%--});--%>
	<%--</script>--%>
</head>
<body>
<form action="/UploadServlet" method="post" enctype="multipart/form-data">
	<input name="data" type="file"><br>
	<input type="submit"><br>
</form>
<%--<div id="mainbody" >--%>
	<%--<!-- Upload Button, use any id you wish-->--%>
	<%--<div id="upload" ><span>Upload File</span></div><span id="status" ></span>--%>
	<%--<ul id="files" ></ul>--%>
<%--</div>--%>
<div>${user.login }</div>
<form id="storage" action="storage">
	<div class="container-fluid"><c:forEach var="file" items = "${lst}">
		<c:if test="${file.directory == true}">
			<input id="${file.name}" type="hidden" name="path" />
			<div class="col-md-3 col-xs-10 file-block" onclick="redirect('${currentPath}','${file.name}')">
				<span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
				<div class="folder-name">${file.name}</div>
			</div>
		</c:if>
		<c:if test="${file.file eq true}">
			<div class="col-md-3 col-xs-10 file-block ">
				<span class="glyphicon glyphicon-file" aria-hidden="true"></span>
				<div class="folder-name">${file.name}</div>
			</div>
		</c:if>
	</c:forEach></div>
</form>

<script type="application/javascript">
	function redirect(current, future) {
		var storageForm = document.getElementById("storage");
		var storageInput = document.getElementById(future);
		storageInput.value = current + future;
		storageForm.submit();
	}
</script>
</body>
</html>