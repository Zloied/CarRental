<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<fmt:setLocale value="${theLocale}" />
<html>
<head>
<title>Update Car</title>
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
				<li><a href="managerReports">Daily Reports</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span>LogOut</a></li>
			</ul>
		</div>
	</nav>
	<form action="/cars/${theCar.id}" method="post">
		<table>
			<tbody>

				<tr>
					<td><label>Model</label></td>
					<td><input type="text" pattern="^\w+$" maxLength="20"
						name="model" value="${theCar.model}"
						title="Only letters,numbers and signs " /> <input type="hidden"
						name="carId" value="${theCar.id}"></td>
				</tr>
				<tr>
					<td><label>Mark</label></td>
					<td><input type="text" pattern="^[a-zA-Z]+$" maxLength="20"
						name="mark" value="${theCar.mark}" title="Only letters " /></td>
				</tr>
				<tr>
					<td><label>Class</label></td>
					<td><div class="form-group">
							<label for="carClass">Current class is ${theCar.carClass}</label>
							<select class="form-control" name="carClass">
								<option>crossover</option>
								<option>sedan</option>
								<option>minivan</option>
								<option>hatchback</option>

							</select>
						</div></td>
				</tr>
				<tr>
					<td><label>Price</label></td>
					<td><input type="text" pattern="^[0-9]+$" maxLength="6"
						name="carCost" value="${theCar.cost}" title="Only numbers " /></td>
				</tr>
				<tr>
					<td class="hidenR"><label></label></td>
					<td class="hidenL"><button type="submit" class="btn btn-info"
							name="command" value="Update">
							<span class="glyphicon glyphicon-floppy-save"></span> Save
						</button></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>