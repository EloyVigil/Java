<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/showstyle.css">
<meta charset="ISO-8859-1">
<title>Your Fortune</title>
</head>
<body>

<h1>Here's Your Omikuji!</h1>
	<div id="container">
	<h1>In ${number} years, you will live in ${city} with ${person} as your roommate, ${hobby} for a living. The next time you see a ${thing}, you will have good luck. Also, ${quote}!</h1>
	</div>
	<a href="/omikuji">Go Back!</a>

</body>
</html>