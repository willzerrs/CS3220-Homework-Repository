<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Reviews</title>
</head>
<body>

<p><a href="DisplayGames">Games</a> > Game name here</p>

<c:forEach items="${reviews}" var="review">
	<p>${ review.username } (${ review.rating }): ${ review.comments }</p>
</c:forEach>

</body>
</html>