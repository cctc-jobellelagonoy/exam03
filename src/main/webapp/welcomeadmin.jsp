<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="codes.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${user.username}</h2>
<h3>List of Users</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Type</th>
		</tr>
	  <c:forEach items="${users}" var="u">
	   <tr>
	   	 <td>${u.id}</td>
	     <td>${u.username}</td>
	     <td>${u.firstName}</td>
	     <td>${u.lastName}</td>
	     <td>${u.userType}</td>
	   </tr>
	  </c:forEach>
	</table>
</body>
</html>