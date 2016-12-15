<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Module ${module.title} - MicroLearn</title>
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
          <li><a class="alert button float-right" href="${root}/DefaultController?&todo=log_out">Disconnect</a></li>
        </ul>
      </div>
    </div>
 
 	<div class="row">
 	
	<h1>Module ${module.title}</h1>
	<p class="text-center">${module.content}</p>
	
	<div class="row">
		<div class="large-8 large-offset-2 columns">
			<ul>
				<c:forEach items="${module.chapters}" var="chapter">
					<c:choose>
					    <c:when test="${chapter.position <= lastSuccess}">
					       	<div class="row callout success">
						       <div class="large-12 medium-12 columns clearfix">
				                    <a href="${root}/StudentController?&todo=navigate&entity=chapter&action=view&id=${chapter.id}">${chapter.title}</a>
				                    
			                  </div>
			            	</div>
					    </c:when>
					    <c:when test="${chapter.position == lastSuccess + 1}">
					    	<div class="row callout">
						       <div class="large-6 medium-6 columns clearfix">
				                    <a href="${root}/StudentController?&todo=navigate&entity=chapter&action=view&id=${chapter.id}">${chapter.title}</a>
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