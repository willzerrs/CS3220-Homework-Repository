<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classes</title>
</head>
<body>
	<form action="Meetings" method="post">
		<select name="selectedClass">
			<c:forEach items="${classList}" var="entry">
				<option value="${entry.id}"
					${entry.className == currentName ? 'selected':''}>${entry.className}</option>
			</c:forEach>
		</select>
		<!-- <button>Select</button> -->
		<input type="submit" value="Select"> <a href="AddClass"
			style="text-decoration: none">Add Class</a>
	</form>

	<form action="AddLink" method="get">
		<table border="1" style="border-collapse: collapse">
			<c:forEach items="${classList}" var="entry">
				<c:if test="${entry.id == id}">
					<c:forEach items="${entry.zoomLinks}" var="classes">
						<!-- check if selected id == class id -->

						<tr>
							<td>${classes.sectionName}</td>
							<td><a href="${classes.zoomLink}"
								style="text-decoration: none">${classes.zoomLink}</a></td>
							<td><a href="DeleteLink?id=${entry.id}"
								style="text-decoration: none">Delete</a></td>
						</tr>

					</c:forEach>
				</c:if>
			</c:forEach>
			<tr>
				<td><input name="sectionName" type="text"></td>
				<td><input name="zoomLink" type="text"></td>
				<td><button>Add</button></td>
			</tr>
		</table>
	</form>


</body>
</html>