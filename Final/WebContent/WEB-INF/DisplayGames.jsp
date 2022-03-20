<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final</title>
</head>
<body>

<p><a href="AddGame">Add Game</a></p>

<table border="1" style="border-collapse: collapse;">

	<tr>
		<th>Game</th>
		<th>Rating</th>
		<th> </th>
	</tr>
	
	<c:forEach items="${games}" var="game">
		<tr>
			<td><a href="DisplayReviews">${ game.game }</a></td>
			<td>${ game.rating }</td>
			<td><a href="AddReview">Review</a>
		</tr>
	</c:forEach>
	
</table>

</body>
</html>