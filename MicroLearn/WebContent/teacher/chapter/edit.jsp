<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Chapter - MicroLearn</title>
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
          <a href="${pageContext.request.contextPath}"><i class="fa fa-home fa-lg"></i></a>	
		</li>
        </ul>
      </div>
      <div class="top-bar-right">
        <ul class="menu">
          <li>Hello ${account.firstName}  ${account.lastName}</li>
          <li><a href="#">(manage)</a></li>
          <li> <a class="alert button float-right" href="${pageContext.request.contextPath}/DefaultController?&todo=log_out">Disconnect</a></li>
        </ul>
      </div>
    </div>


	<br>


<div class="row">
		<div class="medium-6 medium-centered large-6 large-centered columns">
			<div class="row column">
				<form action="TeacherController">
					<h4 class="text-center">Edit Chapter</h4>
					 <a class="alert button "
				href="${root}/TeacherController?&todo=chapter_delete&id=${chapter.id}">Delete Chapter</a> 
					<div class="large-12 columns">
						<div class="input text">
							<label for="username">Title</label> <input placeholder="title..."
								type="text" name="title" value="${chapter.title}" />
						</div>
					</div>
					<div class="large-12 columns">
						<label>Description</label>
						<textarea name="content" placeholder="short description..."
							>${chapter.content}</textarea>
					</div>
					<input type="hidden" name="id" value="${chapter.id}">
					<div class="large-12 columns">
						<button class="button expanded" type="submit" name="todo"
							value="chapter_edit">Edit</button>
					</div>
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