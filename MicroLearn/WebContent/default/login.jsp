<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/foundation/css/foundation.css">
<link rel="stylesheet" href="${root}/foundation/css/app.css">
</head>
<body>

<style type="text/css">

  body { 
    background: url(${root}/foundation/img/login_background.jpg) no-repeat center center fixed; 
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
  }

.log-in-form 
{
  	border: 1px solid #948c8c;
  	border-radius: 3px;
  	padding:1rem; 
  	background-color: #fff;
  	margin-bottom: 10px; 
  	margin-top: 10px;
}

</style>

	<div class="row">
		<div class="medium-6 medium-centered large-4 large-centered columns">
			
			<div class="row column log-in-form"
				style="padding: 1rem; margin-bottom: 10px; margin-top: 20%;">
				<form action="DefaultController">
				<h4 class="text-center">MicroLearn Log In</h4>
				
				<div class="input text"><label for="username">Username</label><input type="text" name="login" value="Login" /></div>
				<div class="input password"><label for="password">Password</label><input
						type="password" name="password" value="Password" /></div>
						
        		  <button class="button expanded" type="submit" name="todo" value="log_in">log in</button>
				

				</form>
			</div>
		</div>
	</div>

	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>

</body>
</html>