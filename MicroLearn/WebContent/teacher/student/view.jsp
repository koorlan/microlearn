<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ student.firstName } ${ student.lastName } results</title>
</head>
<body>

	<div class="row">
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
			</c:forEach>
		</ul>
	</div>

</body>
</html>