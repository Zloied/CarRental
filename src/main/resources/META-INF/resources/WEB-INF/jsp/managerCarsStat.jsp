<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>mangerCarsStatistics</title>
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
				<li class="active"><a href="managerCarsStat">Cars Statistic</a></li>
				<li><a href="managerReports">Daily Reports</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</div>
	</nav>
	<div class="container" align="left">
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-search"></i></span> <input type="text"
				class="form-control" id="search" onkeyup="tableSearch()"
				placeholder="Search in table... ">
		</div>
		<table class="table table-bordered" id="layOutTable">
			<tr>
				<th>Id</th>
				<th>Model</th>
				<th>Times used</th>
			</tr>

			<c:forEach var="car" items="${CARS_STAT}">
				<tr>
					<td>${car.carId}</td>
					<td>${car.model}</td>
					<td>${car.useCount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="js/tableSearch.js"></script>
<body>
</body>
</html>