<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>

<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daikichi</title>
</head>
<body>
	
	<h1>The world is yours!</h1>
	
	<% for(int i = 0; i < 5; i++ ) { %>
		<h1><%= i %></h1>
		<% } %>
		
		<h1>The time is: <%= new Date() %></h1>
		
		<h1>Two plus two is: <h1>
		<h2><c:out value="${name}"/></h2>
		
	
	
</body>
</html>