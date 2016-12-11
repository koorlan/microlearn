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
 
 <div class="row">
	<br>


	<h1>Module View</h1>
	<h2>${module.title}</h2>
	<h3>${module.content}</h3>

	<div class="row">
	<a class="button float-right" href="${root}/TeacherController?&todo=navigate&entity=module&action=edit&id=${module.id}">Edit</a>
     <a class="alert button float-right" href="${root}/TeacherController?&todo=navigate&entity=module&action=edit&id=${module.id}">Delete</a>
	</div>
	
	<div class="row">
		<div class="large-8 large-offset-2 columns">
			<ul>
				<c:forEach items="${module.chapters}" var="chapter">
					<c:choose>
					    <c:when test="${chapter.position <= lastSuccess}">
					       	<div class="row callout success">
						       <div class="large-12 medium-12 columns clearfix">
				                    <a href="${root}/StudentController?&todo=navigate&entity=chapter&action=view&id=${chapter.id}">${chapter.title}</a>
				                    <br>
				                    Description : ${chapter.content}
			                  </div>
			            	</div>
					    </c:when>
					    <c:when test="${chapter.position == lastSuccess + 1}">
					    	<div class="row callout">
						       <div class="large-6 medium-6 columns clearfix">
				                    <a href="${root}/StudentController?&todo=navigate&entity=chapter&action=view&id=${chapter.id}">${chapter.title}</a>
				                    <br>
				                    Description : ${chapter.content}
			                  </div>
			                  <div class="large-6 medium-6 columns clearfix">
				                    <a class="button" href="${root}/StudentController?&todo=navigate&entity=chapter&action=view&id=${chapter.id}">Read</a>
			                  </div>
		            		</div>
					    </c:when>
					    <c:otherwise>
					        <div class="row callout alert">
						        <div class="large-12 medium-12 columns clearfix">
				                    <p>${chapter.title}</p>
				                    <br>
				                    Description : ${chapter.content}
			                  </div>
		            		</div>
					    </c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>

</div>
	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>


</body>
</html>