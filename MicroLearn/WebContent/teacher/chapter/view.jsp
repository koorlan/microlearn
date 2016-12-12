<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Chapter - MicroLearn</title>
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
				<li><a href="${pageContext.request.contextPath}"><i
						class="fa fa-home fa-lg"></i></a></li>
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
	<div class="row">
		<div class="callout">
			<div id='titleOUT'></div>
		</div>
	</div>
	<div class="row">
		<a class="button"
			href="${root}/TeacherController?&todo=navigate&entity=chapter&action=edit&id=${chapter.id}">Edit
			Chapter</a>
		<c:choose>
			<c:when test="${not empty chapter.mct.id}">
				<a class="button"
					href="${root}/TeacherController?&todo=navigate&entity=mct&action=edit&id=${chapter.mct.id}">Edit
					MCT</a>
			</c:when>
			<c:otherwise>
				<a class="button success" href="${root}/TeacherController?&todo=navigate&entity=mct&action=add&chapter_id=${chapter.id}">Add MCT</a>
			</c:otherwise>
		</c:choose>
	</div>


	<div class="row">
		<div id='contentOUT'></div>
	</div>





<div id='titleMD'>
<!--
# ${chapter.title}
 -->
</div>

<div id='contentMD'>
<!--
${chapter.content}
 -->
</div>

	


	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>
	<script src="${root}/foundation/micromarkdown.min.js"></script>
	<script type="text/javascript">
		window.onload = function() {
 		otitle = document.getElementById('titleOUT');
  		ititle = document.getElementById('titleMD').innerHTML.split('<!--')[1].split('-->')[0];
  		otitle.innerHTML = micromarkdown.parse(ititle);

  		ocont = document.getElementById('contentOUT');
  		icont = document.getElementById('contentMD').innerHTML.split('<!--')[1].split('-->')[0];
  		ocont.innerHTML = micromarkdown.parse(icont);
	}

	</script>
</body>
</html>