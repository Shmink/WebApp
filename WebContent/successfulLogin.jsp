<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compose email</title>
<!-- Link the css -->
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>	
	<!-- Some text so the user knows what page they are on -->
	<h2>Compose</h2><br/>
	<!-- Form for logout button -->
	<div class="logout">
		<form action="LogoutController" method="POST">
			<input type="submit" value="Log out">	
		</form>
	</div>
	<br/><br/>
	<!-- After some breaks we have the main form sending the emails -->
	<div class="enter">
		<form action="SendMailController" method="POST">
			<input type="text" placeholder="To" name="recipient"><br/><br/>
			<input type="text" placeholder="Subject" name="subject"><br/><br/>
			<textarea rows="8" cols="50" placeholder="Enter message..." name="messageBody"></textarea><br/><br/>	
			<input type="submit" value="Send">
		</form>
	</div>
</body>
</html>