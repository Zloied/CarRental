<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<fmt:setLocale value="${theLocale}" />
<html>
<head>
<title>New order</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/relatTable.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/fixedTable.js"></script>
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
				<li class="active"><a href="userNewOrder">New order</a></li>
				<li><a href="userView">My Orders</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</div>
	</nav>

	<div align="center">
		<form class="inputs">
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-search"></span>
				</div>
				<input type="text" class="form-control" id="search"
					onkeyup="tableSearch()" placeholder="Search for car... ">
			</div>
		</form>

		<form action="orders" method="post">
			<table class="table-bordered" id="layOutTable">
				<tr>
					<th>Model</th>
					<th>Mark</th>
					<th>Class</th>
					<th>Price</th>
					<th></th>
				</tr>
				<c:forEach var="car" items="${CARS_LIST}">
					<tr>
						<td>${car.model}</td>
						<td>${car.mark}</td>
						<td>${car.carClass}</td>
						<td>${car.cost}</td>
						<td><input type="checkbox" name="carId" id="carId"
							value="${car.id}" /></td>
					</tr>
				</c:forEach>
			</table>
			<br> <label>With_driver</label>
			<div class="checkbox-inline">
				<label class="radio-inline"> <input type="radio"
					name="driver" value="yes"> Yes
				</label> <label class="radio-inline"> <input type="radio"
					name="driver" value="no">No
				</label>
			</div>
			<div class="form-group">

				<label for="emailInput">From</label>
				<div class="input-group">
					<input type="date" class="form-control" name="startDate"
						id="startDate"> <label for="emailInput">To</label> <input
						type="date" class="form-control" name="endDate" id="endDate">
				</div>
			</div>
			<div class="form-group" class="center">
				<button type="submit" name="command" value="Add"
					class="btn btn-primary">Proceed with payment</button>
				<button type="submit" name="command" value="Add"
					class="btn btn-primary">Proceed without payment</button>
			</div>

		</form>
	</div>
	<script src="js/dateCheck.js"></script>
	<script src="js/tableSearch.js"></script>
</body>
</html>