<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email client</title>
<!-- Link the css -->
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<!-- div class with image in -->
	<div class="img">
		<img src="images/banner.png" alt="Banner">
	</div>
	<!-- div class with text fields and a button in -->
	<div class="login">
		<form action="Controller" method="POST">
			<br>
			<input type="text" placeholder="E-mail" name="username"> <br/> <br/>
			<input type="password" placeholder="Password" name="password"> <br/>	<br/>
			<input type="submit" value="Log in">
		</form>
	</div>
</body>
</html>
