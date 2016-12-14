<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${account.login } dashboard - MicroLearn</title>
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
          <li><p>Hello ${account.firstName}  ${account.lastName}</p></li>
          <li> <a class="alert button float-right" href="${root}/DefaultController?&todo=log_out">Disconnect</a></li>
        </ul>
      </div>
    </div>
	<div class="row">
		<div class="large-8 columns large-offset-2 text-center">
			<h1>${account.login } dashboard</h1>
		</div>
		<div class="large-6 columns">
			<h2>All modules</h2>
			<ul>
				<c:forEach items="${modules}" var="module">
					<div class="row callout">
	                  <div class="large-4 medium-4 columns clearfix">
	                    <a href="${root}/TeacherController?&todo=navigate&entity=module&action=view&id=${module.id}">${module.title}</a>
	                    <br>
	                    Description : ${module.content}
	                  </div>
	                   <div class="large-4 medium-4 columns clearfix">
	                  </div>
	                  <div class="large-4 medium-4 columns">
	                    <a class="button float-right" href="${root}/StudentController?&todo=navigate&entity=module&action=subscribe&id=${module.id}">Subscribe</a>
	                  </div>
	            	</div>
				</c:forEach>
			</ul>
		</div>
		<div class="large-6 columns">
			<h2>My modules</h2>
			<ul>
				<c:forEach items="${student.modules}" var="module">
					<div class="row callout">
	                  <div class="large-4 medium-4 columns clearfix">
	                    <a href="${root}/StudentController?&todo=navigate&entity=module&action=view&id=${module.id}">${module.title}</a>
	                    <br>
	                    Description : ${module.content}
	                  </div>
	                   <div class="large-4 medium-4 columns clearfix">
	                  </div>
	                  <div class="large-4 medium-4 columns">
	                    <a class="button float-right" href="${root}/StudentController?&todo=navigate&entity=module&action=view&id=${module.id}">Work on it!</a>
	                  </div>
	            	</div>
				</c:forEach>
			</ul>
		</div>
	</div>

    <script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>

</body>
</html>