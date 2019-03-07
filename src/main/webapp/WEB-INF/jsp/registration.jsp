<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
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
				<a class="navbar-brand" href="home"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="login">Sign In</a></li>
				<li class="active"><a href="registration">Sign_up</a></li>
				<li><a href="about">About</a></li>
				<li><a href="contacts">Contacts</a></li>
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
		<form action="/registration" method="post"
			onsubmit="return checkForm(this)">
			<div class="media-left">
				<img src="images/avatar2.png" class="media-object"
					style="width: 60px">
			</div>

			<div class="form-group">
				<label for="login">Login</label> <br> <input type="text"
					class="form-control" pattern="[a-zA-Z]+" name="login" required
					maxlength="30" placeholder="Login"
					title="Only letters,numbers and signs ">
			</div>
			<div class="form-group">
				<label for="mail">Email</label> <br> <input type="email"
					class="form-control" name="email" required placeholder="@email">
			</div>
			<div class="form-group">
				<label for="password1">Password</label> <br> <input
					type="password" class="form-control" pattern="^[0-9a-zA-Z]+$"
					name="password1" maxlength="30" required placeholder="Password"
					title="Only letters and numbers ">
			</div>
			<div class="form-group">
				<label for="password2">Password</label> <br> <input
					type="password" class="form-control" pattern="^[0-9a-zA-Z]+$"
					name="password2" maxlength="30" required placeholder="Password"
					title="Only letters and numbers ">
			</div>
			<button type="submit" class="btn btn-primary" name="command"
				value="Registration">Sign_up</button>

			<p>${msg}
			</p>
		</form>
	</div>
	<script src="js/loginvalidation.js"></script>
</body>
</html>