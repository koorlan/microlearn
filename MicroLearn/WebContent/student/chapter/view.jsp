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

	<div class="row">
		<div class="large-8 large-offset-2 columns">
			<h1>${chapter.title}</h1>
			<p>${chapter.content}</p>
			<c:if test="${chapter.hasMCT }">
				<h5>${chapter.mct.successCondition}</h5>
				<form action="StudentController">
					<ul>
						<c:forEach items="${chapter.mct.questions}" var="question">
							<li>
							<p>${question.questionText}</p>
							<c:forEach items="${question.answers}" var="answer">
								<input type="checkbox" name="answer-${answer.id}" id="answer-${answer.id}" /> ${answer.text}
							</c:forEach>
							</li>
						</c:forEach>
					</ul>
					<input type="hidden" name="chapter_id" value="${ chapter.id }" />
					<button type="submit" name="todo" value="answer" class="button expanded">Validate answers</button>
				</form>
			</c:if>
		</div>
	</div>

	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>

</body>
</html>