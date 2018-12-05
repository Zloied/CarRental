<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<fmt:setLocale value="${theLocale}" />
<html>
<head>
<title>mangerCars</title>
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
				<li class="active"><a href="managerCars">Manage_cars</a></li>
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
				<th>Mark</th>
				<th>Class</th>
				<th>Price</th>
				<th>action</th>
			</tr>

			<c:forEach var="car" items="${CARS_LIST}">
				<c:url var="updateLink" value="/cars/${car.id}">
					<c:param name="command" value="Load" />
					<c:param name="carId" value="${car.id}" />
				</c:url>
				<c:url var="deleteLink" value="/cars/delete/${car.id}">
					<c:param name="command" value="Delete" />
					<c:param name="carId" value="${car.id}" />
				</c:url>
				<tr>
					<td>${car.id }</td>
					<td>${car.model}</td>
					<td>${car.mark}</td>
					<td>${car.carClass}</td>
					<td>${car.cost}</td>
					<td>
						<div class="btn-group">
							<a href="${updateLink}" class="btn btn-primary"> <i
								class="glyphicon glyphicon-pencil" aria-hidden="true"></i>
								Update
							</a> <a href="${deleteLink}" class="btn btn-danger"
								onclick="if(!(confirm('Are you sure you want to delete this car'))) return false">
								<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
								Delete
							</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<h1>Add a new car</h1>
		<form class="form-inline" action="/cars" method="post">
			<div class="form-group">
				<label for="carName">Model</label><br> <input type="text"
					class="form-control" pattern="^\w+$" maxLength="20" name="carName"
					id="carName" title="Only letters,numbers and signs ">
			</div>
			<div class="form-group">
				<label for="mark">Mark</label><br> <input type="text"
					class="form-control" pattern="^[a-zA-Z]+$" maxLength="20"
					name="mark" id="mark" title="Only letters ">
			</div>

			<div class="form-group">
				<label for="mark">Price </label><br> <input type="text"
					class="form-control" pattern="^[0-9]+$" maxLength="6"
					name="carCost" id="mark" title="Only numbers ">
			</div>
			<div class="form-group">
				<label for="carClass">Class</label><br> <select
					class="form-control" id="carClass" name="carClass">
					<option>sedan</option>
					<option>miniven</option>
					<option>crossover</option>
					<option>hatchback</option>
				</select>
			</div>
			<br>
			<div class="input-group">
				<button type="submit" class="btn btn-primary" name="command"
					value="Add">
					<span class="glyphicon glyphicon-save">Add</span>
				</button>
			</div>
		</form>
	</div>
	<script src="js/tableSearch.js"></script>
<body>
</body>
</html>