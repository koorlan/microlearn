<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Module</title>
<link rel="stylesheet" href="${root}/foundation/css/foundation.css">
<link rel="stylesheet" href="${root}/foundation/css/app.css">
</head>
<body>

	<div class="top-bar">
		<div class="top-bar-left">
			<ul class="menu" data-dropdown-menu>
				<li class="menu-text">MicroLearn</li>

			</ul>
		</div>
		<div class="top-bar-right">
			<ul class="menu">
				<li>Hello ${account.firstName} ${account.lastName}</li>
				<li><a href="#">(manage)</a></li>
				<li><a class="alert button float-right"
					href="${pageContext.request.contextPath}/DefaultController?&todo=log_out">Disconnect</a></li>
			</ul>
		</div>
	</div>

	<br>


	<h1>Module View</h1>
	<h2>${module.title}</h2>
	<h3>${module.content}</h3>

	<div class="row"></div>


	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>


</body>
</html>