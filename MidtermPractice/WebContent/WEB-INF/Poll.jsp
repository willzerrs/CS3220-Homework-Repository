<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Poll</title>
</head>
<body>
<p>Please select the programming langauge(s) you know:</p>
<form action="Language" method="post">
		<!-- Display poll and sends results back to controller -->
		<ul>
			<c:forEach items="${languageList}" var="list">
				<li>
					<input type="checkbox" id="${list.languageName}" name="checkedLanguage" value="${list.id}">
  					<label for="${list.languageName}">${list.languageName}</label><br>
  				</li>
			</c:forEach>
		</ul>
		<button>Submit</button>
</form>
<p><a href="AddLanguage"> Add New Language</a></p>
</body>
</html>