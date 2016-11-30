<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MicroLearn Test Page</title>
</head>
<body>

<h1>Teacher Page</h1>

<ul>
	<c:forEach items="${moduleList}" var="module">
		<li>${module.title}</li>
		<li>${module.content}</li>
	</c:forEach>
</ul>

</body>
</html>