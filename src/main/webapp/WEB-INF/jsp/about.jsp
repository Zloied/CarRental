<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<fmt:setLocale value="${theLocale}" />
<html>
<head>
<title>About company</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
body {
	background-image: url("images/aboutImg.jpg");
}

p {
	color: #0000ff
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="home"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="login">Sign In</a></li>
				<li><a href="registration">Sign_up</a></li>
				<li class="active"><a href="about">About</a></li>
				<li><a href="contacts">Contacts</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="registration"><span
						class="glyphicon glyphicon-user"></span> Sign_up </a></li>
				<li><a href="login"><span
						class="glyphicon glyphicon-log-in"></span> Sign In </a></li>

			</ul>
		</div>
	</nav>
	<div align="center">
		<h1>About author</h1>
		<p>This website was created by Eduard Vaisman.</p>
	</div>
</body>
</html>