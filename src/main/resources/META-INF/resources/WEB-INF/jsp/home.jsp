<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<fmt:bundle basename="i18n.resources" />
<html>
<head>
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap-3.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<head>
<style>
.carousel-inner>.item>img {
	width: 100%;
	height: 800px;
}
</style>
</head>
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
				<li><a href="contacts">Contacts</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="registration"><span
						class="glyphicon glyphicon-user"></span> Sign_up</a></li>
				<li><a href="login"><span
						class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">

				<div class="item active">
					<img src="images/car_1.jpg" alt="Clients">
					<div class="carousel-caption">
						<h1>Clients</h1>
						<p class="lead">We take care about our clients,so we have some
							bonuses for new clients and for old ones too.</p>
						<a class="btn btn-lg btn-primary" href="registration">Sign up
							today</a>
					</div>
				</div>

				<div class="item">
					<img src="images/car_2.jpg" alt="Company">
					<div class="carousel-caption">
						<h1>Company</h1>
						<p class="lead">Our company have been providing services about
							20 years.</p>
						<a class="btn btn-lg btn-primary" href="about">About</a>
					</div>
				</div>

				<div class="item">
					<img src="images/car_3.jpg" alt="Cars">
					<div class="carousel-caption">
						<h1>Cars</h1>
						<p class="lead">Everyone can get car he wants,so don't waste
							the time and make an order.</p>
						<a class="btn btn-lg btn-primary" href="login">SignIn</a>
					</div>
				</div>

			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

</body>
</html>