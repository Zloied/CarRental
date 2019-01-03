<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Main</title>
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
				<li class="active"><a href="managerHome">Main_Page</a></li>
				<li><a href="managerOrders">Manage_orders</a></li>
				<li><a href="managerCars">Manage_cars</a></li>
				<li class="active"><a href="managerCars">Manage_cars</a></li>
				<li ><a href="managerCarsStat">Cars Statistic</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span class="glyphicon glyphicon-log-out"></span>
						LogOut</a></li>

			</ul>
		</div>
	</nav>
	<div align="center">
		<div class="btn-group">
			<a href="managerOrders" class="btn btn-info">Manage_orders </a> <a
				href="managerCars" class="btn btn-info">Manage_cars </a>
		</div>
	</div>
</body>
</html>