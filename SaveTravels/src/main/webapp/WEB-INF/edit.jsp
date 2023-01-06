<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>  
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Edit Expenses</title>
</head>
<body>

<h3>Edit Expense</h3>
	<form:form action="/travel/${id}" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="put">
		<div>
			<form:label path="expenseName">Expense Name:</form:label>
			<form:errors path="expenseName" class="text-danger" />
			<form:input type="text" path='expenseName' class="form-control"></form:input>
		</div>
		<div>
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor" class="text-danger" />
			<form:input type="text" path='vendor' class="form-control"></form:input>
		</div>
		<div>
			<form:label path="amount">Amount:</form:label>
			<form:errors path="amount" class="text-danger" />
			<form:input type="number" path='amount' class="form-control"></form:input>
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:textarea path="description" class="form-control"></form:textarea>
		</div>
		<input type="submit" value="Submit!"/>
	</form:form>
	<a href="/travel">Home!</a>

</body>
</html>