<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Main page</title>
<link rel="stylesheet" href="css/custom.css">
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
				<li><a href="userNewOrder">New order</a></li>
				<li><a href="userView"> My Orders</a></li>
				<li><a href="userFeedback">Leave feedback</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"> <span
						class="glyphicon glyphicon-log-out"></span> LogOut
				</a></li>
			</ul>
		</div>
	</nav>

	<p class="conf">${Message}</p>
	<div align="center">
		<div class="btn-group">
			<a href="userNewOrder" class="btn btn-info"> New_order </a> <a
				href="userView" class="btn btn-info"> My_Orders </a> <a href="userFeedback"
				class="btn btn-info"> Leave feedback </a>
		</div>
	</div>
</body>
</html>