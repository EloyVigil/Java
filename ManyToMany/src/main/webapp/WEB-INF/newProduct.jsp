<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>New Product</title>
</head>
<body>

	<a href="/"><button>Home</button></a>
<h1>The World Is Yours!</h1>
<h1>New Product</h1>

	<form:form action="/new/product" method="post" modelAttribute="product">
		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name" type="text" class="form-control"></form:input>
		</div>
		<div>
		<form:label path="description">Description:</form:label>
			<form:textarea path="description" class="form-control" ></form:textarea>
		</div>
		<div>
			<form:label path="price">Price:</form:label>
			<form:input path="price" type="number" class="form-control"></form:input>
		</div>
		<input type="submit" class="btn btn-primary" value="Add New Product!" />
	</form:form>


</body>
</html>