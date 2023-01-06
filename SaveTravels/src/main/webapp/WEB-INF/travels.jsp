<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>


	<h1>Save Travels</h1>
	<table  class="table table-striped">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items="${travels}">

				<tr>
					<td><a href="/travel/${travel.id}"><c:out value="${travel.expenseName}"></c:out></a></td>
					<td><c:out value="${travel.vendor}"></c:out></td>
					<td><c:out value="${travel.amount}"></c:out></td>
					<td><a href="/travel/${travel.id}/edit">Edit</a> ||
						<form action="/travel/${travel.id}/delete" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <button type="submit">Delete</button>
						</form>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<h3>Add an expense:</h3>
	<form:form action="/travel/add" method="post"
		modelAttribute="newTravel">
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
			<form:errors path="amount" />
			<form:input type="number" path='amount' class="form-control"></form:input>
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:textarea path="description" class="form-control"></form:textarea>
		</div>
		<input type="submit" value="Submit!" />
	</form:form>


</body>
</html>