<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Review</title>
</head>
<body>

<p><a href="DisplayGames">Games</a> > <a href="#">Game name here</a> > Review</p>
<input type="hidden" name="game" value="Cyberpunk 2077">
<form action="AddReview" method="post">

	Your name:
	<input type="text" name="name" /><br>
	Your rating (1-10):
	<input type="number" name="rating" min="1" max="10" /><br>
	<textarea name="review" placeholder="Your comments"></textarea><br>
	<button>Save</button>
	
</form>

</body>
</html>