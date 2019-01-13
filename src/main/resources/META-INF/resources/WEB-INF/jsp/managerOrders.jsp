<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<fmt:setLocale value="${theLocale}" />
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
				<li class="active"><a href="managerOrders">Manage_orders</a></li>
				<li><a href="managerCars">Manage_cars</a></li>
				<li><a href="managerCarsStat">Cars Statistic</a></li>
				<li><a href="managerReports">Daily Reports</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</div>
	</nav>
	<div class="container" align="center">

		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-search"></i></span> <input type="text"
				class="form-control" id="search" onkeyup="tableSearch()"
				placeholder="Search in table... ">
		</div>
		<table class="table table-striped" id="layOutTable">
			<thead class="thead-dark">
				<tr>
					<th scope="col">OrderId</th>
					<th scope="col">UserId</th>
					<th>With_driver</th>
					<th>Start_date</th>
					<th>Final_date</th>
					<th>Price</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${listOrders}">
					<c:url var="statusReq" value="/orders/change/${order.id}">
						<c:param name="command" value="ChangeStatus" />
						<c:param name="setStatus" value="requested" />
					</c:url>
					<c:url var="statusProc" value="/orders/change/${order.id}">
						<c:param name="command" value="ChangeStatus" />
						<c:param name="setStatus" value="proceeding" />
					</c:url>
					<c:url var="statusComp" value="/orders/change/${order.id}">
						<c:param name="command" value="ChangeStatus" />
						<c:param name="setStatus" value="completed" />
					</c:url>
					<tr>
						<td scope="row">${order.id}</td>
						<td>${order.userId}</td>
						<td>${order.driver}</td>
						<td>${order.start_date}</td>
						<td>${order.finish_date}</td>
						<td>${order.bill}</td>
						<td>${order.status}</td>
						<td>
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									Set Status <span class="caret"></span>
								</button>
								<ul class="dropdown-menu"
									onclick="if(!(confirm('are you sure you want to change status?'))) return false">
									<li><a type="submit" href="${statusReq}">requested</a></li>
									<li><a type="submit" href="${statusProc}">proceeding</a></li>
									<li><a type="submit" href="${statusComp}">completed</a></li>
								</ul>
							</div>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="js/tableSearch.js"></script>
</body>
</html>