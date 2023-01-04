<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dojo.name}</title>
</head>
<body>
<h1><c:out value="${dojo.name}"/>'s  Ninjas!</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${ninja }">
				<tr>
					<td><c:out value="${ninja.firstName}" /></td>
					<td><c:out value="${ninja.lastName}" /></td>
					<td><c:out value="${ninja.age}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/dojo">Add Dojo</a>
	<a href="/ninja">Add Ninja</a>

</body>
</html>