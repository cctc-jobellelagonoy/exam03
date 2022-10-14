<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
	</head>

	<body>
		<form action="LoginServlet" method="POST">
			Username 		
			<input type="text" name="un"/><br>		
			Password
			<input type="text" name="pw"/><br>
			<input type="submit" value="Login">			
		</form>

		<form action="signup.jsp">
			<input type="submit" value="Sign Up">
		</form>
	</body>
</html>