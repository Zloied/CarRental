<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<fmt:setLocale value="${theLocale}" />
<html>
<head>
<title>Add user</title>
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
				<a class="navbar-brand" href="adminHome"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="adminHome">Main_Page</a></li>
				<li class="active"><a href="adminAdd">Add_User</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logOut"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</div>
	</nav>
	<div align="center">
		<form action="/users" method="post"
			onsubmit="return checkForm(this)">


			<div class="media-left">
				<img src="images/avatar2.png" class="media-object"
					style="width: 60px">
			</div>
			<div class="loginInp">
				<div class="form-group">
					<label for="login">Login</label> <br> <input id="login"
						type="text" class="form-control" pattern="[a-zA-Z]+" name="login"
						placeholder="Login" maxlength="30"
						title="Only letters,numbers and signs ">
				</div>
				<div class="form-group">
					<label for="emailInput">Email</label> <br> <input type="email"
						class="form-control" name="email" id="emailInput"
						placeholder="@email" maxlength="30">
				</div>
				<div class="form-group">
					<label for="passwordInput">Password</label> <br> <input
						type="password" class="form-control" pattern="^[0-9a-zA-Z]+$"
						name="password1" id="password1" placeholder="Password"
						maxlength="30" title="Only letters and numbers ">
				</div>
				<div class="form-group">
					<label for="password2">Password</label> <br> <input
						type="password" class="form-control" pattern="^[0-9a-zA-Z]+$"
						name="password2" id="password2" placeholder="Password"
						maxlength="30" title="Only letters and numbers ">
				</div>
				<div class="form-group">
					<label for="setRole">Role</label> <br> <input type="radio"
						name="setRole" value="manager" checked> Manager <input
						type="radio" name="setRole" value="admin" /> Admin
				</div>
				<button type="submit" class="btn btn-primary" name="command"
					value="Add">Add user</button>
			</div>
			<p style="color: red;">${msg}</p>
		</form>
	</div>
	<script src="js/loginvalidation.js"></script>
</body>
</html>