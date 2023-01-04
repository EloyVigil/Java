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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Dashboard</title>
</head>
<body>

	<h1>Welcome,<c:out value="${userName}"></c:out>!</h1>
	<p>Books from everyone's shelves!</p>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Authors Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books }">
				<tr>
					<td><c:out value="${book.id }"></c:out></td>
					<td><a href="/viewbook/${book.id}"><c:out value="${book.title}" /></a></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.user.userName }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	
	<a href="/book/form">Add Book!</a>
	<a href="/logout"><button>Logout !</button></a>


</body>
</html>