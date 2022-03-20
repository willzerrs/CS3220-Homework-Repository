<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Reservations</title>
</head>

<body>

	<p>
		<b>Room Reservations for B10</b>
	</p>

	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th></th>
			<th><b>MON</b></th>
			<th><b>TUE</b></th>
			<th><b>WED</b></th>
			<th><b>THR</b></th>
			<th><b>FRI</b></th>
		</tr>
		<tr>
			<td>08:00-09:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '08:00-09:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>09:00-10:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '09:00-10:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>10:00-11:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '10:00-11:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>11:00-12:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '11:00-12:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>12:00-13:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '12:00-13:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>13:00-14:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '13:00-14:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>14:00-15:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '14:00-15:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>15:00-16:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '15:00-16:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>16:00-17:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '16:00-17:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>
		<tr>
			<td>17:00-18:00</td>
			<c:forEach items="${entries}" var="reservation">
				<c:if test="${reservation.time == '17:00-18:00'}">
					<td><a href="DeleteReservation?id=${reservation.id}">${reservation.name}</a>
					</td>
				</c:if>
			</c:forEach>
		</tr>

	</table>

	<form name="newReservation" method="post" action="#">

		<select name="date">
			<option value="MON">MON</option>
			<option value="TUE">TUE</option>
			<option value="WED">WED</option>
			<option value="THR">THR</option>
			<option value="FRI">FRI</option>
		</select> 
		<select name="time">
			<option value="08:00-09:00">08:00-09:00</option>
			<option value="09:00-10:00">09:00-10:00</option>
			<option value="10:00-11:00">10:00-11:00</option>
			<option value="11:00-12:00">11:00-12:00</option>
			<option value="12:00-13:00">12:00-13:00</option>
			<option value="13:00-14:00">13:00-14:00</option>
			<option value="14:00-15:00">14:00-15:00</option>
			<option value="15:00-16:00">15:00-16:00</option>
			<option value="16:00-17:00">16:00-17:00</option>
			<option value="17:00-18:00">17:00-18:00</option>
		</select> <input type="text" name="name">
		<button>Reserve</button>
	</form>


</body>
</html>