<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index - MicroLearn</title>
<link rel="stylesheet" href="${root}/foundation/css/foundation.css">
<link rel="stylesheet" href="${root}/foundation/css/app.css">
<link rel="stylesheet" href="${root}/foundation/font-awesome/css/font-awesome.css">
</head>
<body>

<div class="top-bar">
      <div class="top-bar-left">
        <ul class="menu" data-dropdown-menu>
          <li class="menu-text">MicroLearn</li>
          <li>
          <a href="${root}"><i class="fa fa-home fa-lg"></i></a>	
		</li>
        </ul>
      </div>
      <div class="top-bar-right">
        <ul class="menu">
          <li>Hello ${account.firstName}  ${account.lastName}</li>
          <li><a href="#">(manage)</a></li>
          <li> <a class="alert button float-right" href="${root}/DefaultController?&todo=log_out">Disconnect</a></li>
        </ul>
      </div>
    </div>

    <br>


		<div class="row">
	<div class="medium-6 medium-centered large-6 large-centered columns">
			<div class="row column">
				<form action="AdminController">
				<h4 class="text-center">Add Account</h4>

				<label>
 				 Login:
 				 <input type="text" name="login" placeholder="login...">
				</label>
				
				<label>
 				 Password:
 				 <input type="password" name="password" >
				</label>
				
				<label>
 				 Firstname:
 				 <input type="text" name="firstname" placeholder="firstname...">
				</label>
				
				<label>
 				 Lastname:
 				 <input type="text" name="lastname" placeholder="lastname...">
				</label>
				
				<fieldset class="fieldset">
  <legend>Account Type</legend>
  <input type="radio" value="TEACHER" name="acc_type"> Teacher
  <input type="radio" value="ADMIN" name="acc_type"> Admin
  <input type="radio" value="STUDENT" name="acc_type"> Student
</fieldset>
				
          		   <button class="button expanded" type="submit" name="todo" value="account_add">Create</button>

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