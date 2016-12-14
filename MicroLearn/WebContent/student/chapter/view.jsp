<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter ${ chapter.title } - MicroLearn</title>
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
		<div class="large-8 large-offset-2 columns">
			<div class="row">
				<h1 class="large-6 medium-6 columns">Chapter ${chapter.title}</h1>
				<div class="large-6 medium-6 columns">
					<br/>
					<a href="${root}/StudentController?&todo=navigate&entity=module&action=view&id=${ chapter.moduleId }" class="button">Module summary</a>
				</div>
			</div>
			<p class="text-center">${chapter.content}</p>
			<c:if test="${chapter.hasMCT }">
				<em>Good answers required to success the test: ${chapter.mct.successCondition}</em>
				<c:if test="${ score > -1 }">
					<br/>
					Your score for this test is: ${ score }
				</c:if>
				<c:if test="${ score == -1 || chapter.mct.showAnswers }">
				<form action="StudentController">
					<ul>
						<c:forEach items="${chapter.mct.questions}" var="question">
							<li>
							<p>${question.questionText}</p>
							<c:forEach items="${question.answers}" var="answer">
								<c:choose>
									<c:when test="${ score > -1 }">
										<input <c:if test="${answer.isTrue }">checked</c:if> disabled type="checkbox" name="answer-${answer.id}" id="answer-${answer.id}" /> ${answer.text}
									</c:when>
									<c:otherwise>
										<input type="checkbox" name="answer-${answer.id}" id="answer-${answer.id}" /> ${answer.text}
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</li>
						</c:forEach>
					</ul>
					<input type="hidden" name="chapter_id" value="${ chapter.id }" />
					<c:if test="${ score == -1 }">
						<button type="submit" name="todo" value="answer" class="button expanded">Validate answers</button>
					</c:if>
				</form>
				</c:if>
			</c:if>
		</div>
	</div>

	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>

</body>
</html>