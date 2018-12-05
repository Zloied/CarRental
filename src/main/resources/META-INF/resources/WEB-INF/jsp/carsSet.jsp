<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="css/sitestyle.css">
</head>
<body>
	<div align="center">
		<table>
			
			<tr>
				<th>Model</th>
				<th>Mark</th>
				<th>Class</th>
				<th>Cost</th>
			</tr>
	
				<c:forEach var="tempCar" items="${CARS_LIST}">
					<tr>
						<td>${tempCar.model}</td>
						<td>${tempCar.mark}</td>
						<td>${tempCar.carClass}</td>
						<td>${tempCar.cost}</td>
					</tr>				
				</c:forEach>
			
		</table>
	</div>
</body>
</html>