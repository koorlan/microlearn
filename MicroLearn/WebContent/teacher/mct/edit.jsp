<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit MCT - MicroLearn</title>
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


	<br>

	<div class="row">

<c:forEach items="${mct.questions}" var="question">
	<div class="row">
		<div class="callout">
			${question.questionText}
			<ul>
			<c:forEach items="${question.answers}" var="answer">
				<li>
					<c:choose>
						<c:when test="${answer.isTrue}">
							<div class="callout success">${answer.text}</div>
						</c:when>
						<c:otherwise>
							<div class="callout alert">${answer.text}</div>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>

</c:forEach>


<form action="TeacherController" id="form">
	<label> Minimum validated question to pass this test? 
	<input type="number" value="1" name="sucess_condition">
	</label> 
	<input type="hidden" value="0" name="question_counter">
	
	<button class="button expanded" type="submit" name="todo"
						value="question_add">Save MCT</button>

	<button class="button expanded" type="button" 
						onClick="add_question();")>Add Question</button>
	<div class="callout">
		<label>Enter the question here.
			<input type="text" placeholder="Question.." name="q0">
		</label>
		<ul>
		  	<li>
			<input type="text" placeholder="Answer" name="q0-a0">
			 <input type="checkbox" name="q0-a0-t"> True?<br>
			</li>
			  	<li>
			<input type="text" placeholder="Answer" name="q0-a1">
			<input type="checkbox" name="q0-a1-t"> True?<br>
			</li>
			  	<li>
			<input type="text" placeholder="Answer" name="q0-a2">
			<input type="checkbox" name="q0-a2-t"> True?<br>
			</li>
		</ul>
			
	</div>

			
	</div>
</form>	
	
	
	</div>


	<script src="${root}/foundation/js/vendor/jquery.js"></script>
	<script src="${root}/foundation/js/vendor/what-input.js"></script>
	<script src="${root}/foundation/js/vendor/foundation.js"></script>
	<script src="${root}/foundation/js/app.js"></script>
	<script type="text/javascript">
	function add_question(){
		$('#form').append('<input type="text" name="myfieldname" value="myvalue" />');

			var prev = $('input[name="question_counter"]').val();
			$('input[name="question_counter"]').val(parseInt(prev)+1);
	
			
		}
	</script>

</body>
</html>