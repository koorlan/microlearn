<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ student.firstName } ${ student.lastName } results</title>
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
          <li>Hello ${account.firstName}  ${account.lastName} </li>
          <li><a class="alert button float-right" href="${root}/DefaultController?&todo=log_out">Disconnect</a></li>
        </ul>
      </div>
    </div>
	<div class="row">
		<div class="large-8 large-offset-2 columns">
			<h4>${ student.firstName } ${ student.lastName } results</h4>
			<ul>
				<c:forEach items="${ student.results }" var="result">
					<li>
						Chapter #${ result.chapterId }<br/>
						Attempt number: ${ result.attemptNumber }<br/>
						<c:if test="${ result.successAttempt != null }">
							Success on ${ result.successAttempt.date } with a score of ${ result.successAttempt.score } 
						</c:if>
					</li>
					<hr/>
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