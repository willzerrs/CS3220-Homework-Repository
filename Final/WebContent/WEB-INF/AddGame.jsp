<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Game</title>
</head>
<body>

<p><a href="DisplayGames">Games</a> > Add Game</p>

<form action="AddGame" method="post">
	<input type="text" name="game">
	<button>Add</button>
</form>

</body>
</html>