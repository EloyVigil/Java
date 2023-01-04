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
<title>${book.title}</title>
</head>
<body>

	<a href="/dashboard">Dashboard</a>
	<h1>${book.title}</h1>


	<h2>${books.userName}read ${book.title} by ${book.author }</h2>
	<h4>Here Are ${books.userName }'s thoughts on the book.</h4>

	<h4>${book.thoughts }</h4>

	<c:if test="${sessionScope.userId == book.user.id}">
		<a href="/editbook/${book.id }">Edit Book!</a>
		<form action="/delete/${book.id}" method="post">
			    <input type="hidden" name="_method" value="delete">     
			<button type="submit">Delete</button>
		</form>
	</c:if>


</body>
</html>