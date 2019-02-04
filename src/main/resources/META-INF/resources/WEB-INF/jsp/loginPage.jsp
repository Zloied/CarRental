<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Sign in</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<script src="js/jquery.js"></script>
<script src="js/validation.js"></script>
<script src="js/bootstrap.min.js"></script>
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
				<a class="navbar-brand" href="home"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="login">Sign In</a></li>
				<li><a href="registration">Sign_up</a></li>
				<li><a href="about">About </a></li>
				<li><a href="contacts">Contacts </a></li>
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
	<div align="center">
		<form action="login" method="post" onsubmit="return checkForm(this)">
			<div class="loginInp">
				<div class="form-group">
					<label for="login">Login</label> <br> <input type="text"
						class="form-control" name="login" placeholder="Login"
						maxlength="30">
				</div>
				<div class="form-group">
					<label for="passw">Password</label> <br> <input
						type="password" class="form-control" name="passw"
						placeholder="Password" maxlength="30">
				</div>
				<button type="submit" class="btn btn-primary" name="command"
					value="Authentification">Sign In</button>
			</div>

		</form>
	</div>
</body>
</html>