<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MicroLearn Test Page</title>
    <link rel="stylesheet" href="${root}/foundation/css/foundation.css">
	<link rel="stylesheet" href="${root}/foundation/css/app.css">
	<link rel="stylesheet" href="${root}/foundation/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="row">
		<div class="large-8 columns large-offset-2 text-center">
			<h1>Student Page</h1>
		</div>
		<div class="large-6 columns">
			<h2>All modules</h2>
			<ul>
				<c:forEach items="${moduleList}" var="module">
					<li>${module.title}</li>
					<li>${module.content}</li>
				</c:forEach>
			</ul>
		</div>
		<div class="large-6 columns">
			<h2>My modules</h2>
			<!-- <ul>
				<c:forEach items="${myModules}" var="module">
					<li>${module.title}</li>
					<li>${module.content}</li>
				</c:forEach>
			</ul> -->
		</div>
	</div>

    <script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>

</body>
</html>