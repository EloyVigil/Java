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
<title>${product.name}</title>
</head>
<body>
	<h1 class="text-center">
		<c:out value="${product.name}" />
	</h1>
	<a href="/"><button>Home</button></a>

	<h2 class="text-center">Categories:</h2>
	<ul>
		<c:forEach var="category" items="${assignedCategories}">
			<li><c:out value="${category.name }"></c:out></li>
		</c:forEach>
	</ul>

	<form action="/product/${id}" method="post" class="form-control">
	<h4>Add Category</h4>
	<select name="categoryId" id="categoryId" class="input">
		<c:forEach var="category" items="${unassignedCategories }">
			<option value="${category.id}" class="form-control">
				<c:out value="${category.name}" />
			</option>
		</c:forEach>
	</select>
	<input class="input" class="button" type="submit" value="Add Category" />
	</form>
	<div>
</body>
</html>