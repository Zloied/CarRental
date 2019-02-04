<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<fmt:setLocale value="${theLocale}" />
<html>
<head>
<title>Contacts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image: url("images/contacts.jpg");
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
				<li><a href="about">About</a></li>
				<li class="active"><a href="contacts">Contacts</a></li>
				<li><a href="feedback">Feedback</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="registration"><span
						class="glyphicon glyphicon-user"></span> Sign_up</a></li>
				<li><a href="login"><span
						class="glyphicon glyphicon-log-in"></span> Sign In</a></li>

			</ul>
		</div>
	</nav>
	<div class="container" align="center">
		<h1>Our Work schedule</h1>
		<p>...</p>
	</div>
	<div class="footer">
		<p>Telephone number : +421 908 375861</p>
		<p>Email: zloied11@gmail.com</p>
	</div>
</body>
</html>