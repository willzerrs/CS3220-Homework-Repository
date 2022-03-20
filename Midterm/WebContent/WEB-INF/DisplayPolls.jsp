<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Poll Display</title>
</head>
<body>
<form>
	<p>${filteredList.question}</p>
	<c:forEach items="pollsList" var="list">
		<input type="checkbox" id="${list.answer}" name="checkedAnswer">
		<label for="${list.answer}">${list.answer}</label><br>
	</c:forEach>
</form>
</body>
</html>