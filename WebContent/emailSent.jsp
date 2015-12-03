<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Sent</title>
</head>
<body>
	<h3>Thank you, your mail has been sent.</h3>
	<form action="index.jsp">
		<input type="submit" value="Go home">
	</form>
	
	<form action="LogoutController" method="POST">
		<input type="submit" value="Log out">
	</form>
	
	<form action="successfulLogin.jsp">
		<input type="submit" value="Send another email">
	</form>
</body>
</html>