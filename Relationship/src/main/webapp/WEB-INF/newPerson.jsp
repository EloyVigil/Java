<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>New Person</h1>

<form:form action="person/add" method="POST" modelAttribute="newPerson">

	<form:label path="firstName">First Name:</form:label>
	<form:input type="text" path="firstName"></form:input>
	
	<form:label path="lastName">Last name:</form:label>
	<form:input type="text" path="lastName"></form:input>
	
	<button type="submit">Create!</button>
	
</form:form>


</body>
</html>