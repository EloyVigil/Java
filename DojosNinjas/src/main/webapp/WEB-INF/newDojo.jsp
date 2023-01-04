<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> 
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>

<a href="/ninja">Register a New Ninja</a>
<h3>Add an expense:</h3>
	<form:form action="dojos" method="post"
		modelAttribute="dojo">
		<div>
			<form:label path="name">Dojo Name:</form:label>
			<form:errors path="name" class="text-danger" />
			<form:input path='name' type="text" class="form-control"></form:input>
		</div>
		<input type="submit" value="Submit!" />
	</form:form>

<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Dojo Name</th>
				<th>View</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${dojos }">
				<tr>
					<td><c:out value="${dojo.name}" /></td>
					<td><a href="/display/${dojo.id}">See Ninjas</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>