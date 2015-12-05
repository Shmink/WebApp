<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Sent</title>
<!-- Link css -->
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<!-- Some text for the user -->
	<h2>Thank you, your mail has been sent.</h2>
	<!-- Create a div for styling and a load of forms for buttons to work -->
	<div class="menu">
		<form action="index.jsp">
			<input type="submit" value="Go home">
		</form>
		<br/>
		<form action="LogoutController" method="POST">
			<input type="submit" value="Log out">
		</form>
		<br/>
		<form action="successfulLogin.jsp">
			<input type="submit" value="Send another email">
		</form>
	</div>
</body>
</html>