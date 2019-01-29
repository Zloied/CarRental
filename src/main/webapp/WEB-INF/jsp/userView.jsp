<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>My orders</title>
<link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="css/relatTable.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<style type="text/css">
body {
	background-image: url("images/blur.jpg");
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="userHome"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="userNewOrder">New_order</a></li>
				<li class="active"><a href="userView">My_Orders</a></li>
				<li><a href="userFeedback">Leave feedback</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>

			</ul>
		</div>
	</nav>
	<div class="center">
		<table>
			<tr>
				<th scope="col">OrderId</th>
				<th>With_driver</th>
				<th>Price</th>
				<th>Status</th>
				<th>Start_date</th>
				<th>Final_date</th>


			</tr>

			<c:forEach var="order" items="${listOrders}">
				<tr>
					<td>${order.id}</td>
					<td>${order.driver}</td>
					<td>${order.bill}</td>
					<td>${order.status}</td>
					<td>${order.start_date}</td>
					<td>${order.finish_date }</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>