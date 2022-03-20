<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Poll</title>
</head>
<body>
<table border="1" style="border-collapse: collapse">
	<tr>
		<td><b>Language</b></td>
		<td><b># of People Who Know The Language</b></td>
	</tr>
	<c:forEach items="${languageList}" var="list">
		<tr>
			<td>${list.languageName}</td>
			<td>${list.responseCounter}</td>
		</tr>
	</c:forEach>
</table>
<p><a href="Language">Back to Poll</a></p>
</body>
</html>