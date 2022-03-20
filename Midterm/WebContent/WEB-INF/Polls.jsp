<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Polls</title>
</head>
<body>
<p><a href="CreatePoll">Create Poll</a></p>
<form action="Polls" method="post">
	<table border="1" style="border-collapse: collapse">
		<c:forEach items="${pollsList}" var="list">
			<tr>
			<td><a href="DisplayPolls?id=${list.id}">${list.question}</a></td>
			<td><a href="AddAnswers?id=${list.id}">Add Answers</a></td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>