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
<title>${userName} add a book</title>
</head>
<body>

<a href="/dashboard">Dashboard</a>
<h3>Add another book :</h3>
	<form:form action="/add/book" method="post" modelAttribute="book">
	<form:input type="hidden"  path="user" value="${id}"/>
		<div>
			<form:label path="title">Title:</form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input path="title" type="text" class="form-control"></form:input>
		</div>
		<div>
			<form:label path="author">Author:</form:label>
			<form:errors path="author" class="text-danger"/>
			<form:input path="author" type="text" class="form-control"></form:input>
		</div>
		<div>
		<form:label path="thoughts">My thoughts:</form:label>
		<form:errors path="thoughts" class="text-danger"/>
			<form:textarea path="thoughts" class="form-control" ></form:textarea>
		</div>
		<input type="submit" value="Add the book!" />
	</form:form>

</body>
</html>