<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="codes.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
	<h1>Welcome ${param.un}</h1>
	<h3>Your Details:</h3>
	Username: ${user.username}<br>
	Firstname: ${user.firstName}<br>
	Lastname: ${user.lastName}<br>
	
</body>
</html>