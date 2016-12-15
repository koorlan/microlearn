<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Module - MicroLearn</title>
<link rel="stylesheet" href="${root}/foundation/css/foundation.css">
<link rel="stylesheet" href="${root}/foundation/css/app.css">
<link rel="stylesheet"
	href="${root}/foundation/font-awesome/css/font-awesome.css">
</head>
<body>

	<div class="top-bar">
		<div class="top-bar-left">
			<ul class="menu" data-dropdown-menu>
				<li class="menu-text">MicroLearn</li>
				<li><a href="${root}"><i class="fa fa-home fa-lg"></i></a></li>
			</ul>
		</div>
		<div class="top-bar-right">
			<ul class="menu">
				<li>Hello ${account.firstName} ${account.lastName}</li>
				<li><a href="#">(manage)</a></li>
				<li><a class="alert button float-right"
					href=${root}/DefaultController?&todo=log_out">Disconnect</a></li>
			</ul>
		</div>
	</div>

	<br>

	<div class="row">
		<div class="large-8 columns large-offset-2 medium-8 medium-offset-2">
		<h2>${module.title}</h2>
		<h3>${module.content}</h3>
		<a class="button float-right"
			href="${root}/TeacherController?&todo=navigate&entity=module&action=edit&id=${module.id}">Edit</a>
		<a class="alert button float-right"
			href="${root}/TeacherController?&todo=module_delete&id=${module.id}">Delete</a>

		</div>
	</div>

	

	<div class="row">
		<div class="large-8 columns large-offset-2 medium-8 medium-offset-2">
			<a class="button"
				href="${root}/TeacherController?&todo=navigate&entity=chapter&action=add&module_id=${module.id}">New
				Chapter</a>

			<c:forEach items="${module.chapters}" var="chapter">

				<div class="row callout">
					<div class="large-4 medium-4 columns clearfix">
						<a
							href="${root}/TeacherController?&todo=navigate&entity=chapter&action=view&id=${chapter.id}">${chapter.title}</a>
					</div>

					<div class="large-4 medium-4 columns">
						<a class="button float-right"
							href="${root}/TeacherController?&todo=navigate&entity=chapter&action=edit&id=${chapter.id}">Edit</a>
						<a class="alert button float-right"
							href="${root}/TeacherController?&todo=chapter_delete&id=${chapter.id}">Delete</a>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>

	<div class="row">
		<h4>Enrolled students</h4>
			<c:forEach items="${ students }" var="student">
					<div class="row callout">
	                  <div class="large-4 columns clearfix">
	                    <a href="${root}/TeacherController?&todo=navigate&entity=student&action=view&id=${ module.id }&login=${student.login}">${student.firstName} ${ student.lastName }</a>
	                  </div>
	                  <div class="large-4 columns clearfix">
	                  	<strong>Current chapter: #${ student.lastSuccess + 1}</strong>
	                  </div>
            		</div>
			</c:forEach>
	</div>




	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>


</body>
</html>