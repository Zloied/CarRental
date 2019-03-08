<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Leave feedback</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
				<li><a href="userView">My Orders</a></li>
				<li class="active"><a href="userFeedback">Leave feedback</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</div>
	</nav>

	<div class="container" align="center">
		<form action="feedback" method="post">

			<div class="form-group" align="left">
				<label><input type="radio" name="rate" value="1">
					Very bad</label>
			</div>
			<div class="form-group" align="left">
				<label><input type="radio" name="rate" value="2">
					Bad</label>
			</div>
			<div class="form-group" align="left">

				<label><input type="radio" name="rate" value="3">
					Normal</label>
			</div>
			<div class="form-group" align="left">
				<label><input type="radio" name="rate" value="4">
					Good</label>
			</div>
			<div class="form-group" align="left">
				<label><input type="radio" name="rate" value="5" checked>
					Very Good</label>
			</div>
			<div class="form-group" align="left">
				<label for="comment">Leave a feedback</label><br>
				<textarea rows="5" cols="50" maxlength="128" name="comment"></textarea>
			</div>
			<div class="form-group" align="left">
				<input type="submit" class="btn btn-primary" value="submit">
			</div>

		</form>
	</div>
</body>
</html>