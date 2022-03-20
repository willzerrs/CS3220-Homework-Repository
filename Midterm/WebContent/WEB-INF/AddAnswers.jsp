<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Answers</title>
</head>
<body>
	<!-- why is this a number format exception? :( -->
	${pollsList.question}
	<form action="AddAnswers" method="post">

		<c:if test="${pollsList.answers != null}">
			<c:forEach items="${pollsList.answers}" var="answer">
				${answer}<br>
			</c:forEach>
		</c:if>
		<p>
			<input type="text" name="newAnswer">
			<button>Add</button>
		</p>
	</form>
</body>
</html>