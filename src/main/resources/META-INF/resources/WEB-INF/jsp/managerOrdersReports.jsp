<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Manage orders</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/sitestyle.css">
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
				<a class="navbar-brand" href="managerHome"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="managerHome">Main_Page</a></li>
				<li><a href="managerOrders">Manage_orders</a></li>
				<li><a href="managerCars">Manage_cars</a></li>
				<li><a href="managerCarsStat">Cars Statistic</a></li>
				<li class="active"><a href="managerReports">Daily Reports</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</div>
	</nav>
	<div class="container" align="center">
		<table class="table table-striped" id="layOutTable">
			<thead class="thead-dark">
				<tr>
					<th>Money amount</th>
					<th>Number of orders</th>
					<th>Start_date</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${listOrderReports}">
					<tr>
						<td scope="row">${order.summ}</td>
						<td>${order.count}</td>
						<td>${order.start_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>