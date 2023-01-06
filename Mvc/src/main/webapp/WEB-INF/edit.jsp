<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>


	<h3>Edit The Book Here!</h3>
	<form:form action="/books/${id}" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
		<div>
			<form:label path="title">Title:</form:label> 
			<form:errors path="title" class="text-danger"/>
			<form:input type="text" path='title'></form:input>
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description"></form:textarea>
		</div>
		<div>
			<form:label path="language">Language:</form:label> 
			 <form:errors path="language" class="text-danger"/>
			<form:input type="text" path='language'></form:input>
		</div>
		<div>
			<form:label path="numberOfPages">Pages:</form:label> 
			<form:errors path="numberOfPages" class="text-danger"/>
			<form:input type="text" path='numberOfPages'></form:input>
		</div>
		<input type="submit" value="Submit!"/>
	</form:form>
	<a href="/books">See Books!</a>


</body>
</html>