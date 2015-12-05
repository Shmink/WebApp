<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Error</title>
<!-- Link the css -->
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<!-- Some text for the user -->
	<h2>We weren't able to send your message</h2>
	<p>You can go back to try again or log out. Make sure your recipient has a valid email address.</p>
	<!-- div tag including form with a button -->
	<div class="errorSending">
		<form action="successfulLogin.jsp">
			<input type="submit" value="Try again">
		</form>
	</div>
</body>
</html>