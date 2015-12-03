<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compose email</title>
</head>
<body>
	<!--
		enter recipient address,
		email subject,
		email body in web page using text fields and text areas,
		sending email based on above input from the user using javamail api
		displaying a notification if the message was sent successfully also allow the user to go back to sending page after successfully sending.
	-->
	
	<h2>Compose</h2><br/>
	<input type="submit" value="Log out">	<br/><br/>
	<form action="SendMailController" method="POST">
		Recipient: <input type="text" name="recipient"><br/><br/>
		Subject: <input type="text" name="subject"><br/><br/>
		Body: <textarea rows="8" cols="50" name="messageBody"></textarea><br/><br/>	
		<input type="submit" value="Send">
	</form>
</body>
</html>