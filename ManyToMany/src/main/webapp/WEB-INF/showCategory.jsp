<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>${category.name }</title>
</head>
<body>

	<a href="/"><button>Home</button></a>
	<h1>${category.name }</h1>
	<h3>Products</h3>
	<ul>
		<c:forEach var="product" items="${assignedProducts }">
			<li><c:out value="${product.name }" /></li>
		</c:forEach>
	</ul>

	<form action="/view/${id}/category" method="POST">
		<h4>Add Product</h4>
		<select name="productId" id="productId">
			<c:forEach var="product" items="${unassignedProducts }">
				<option value="${product.id }">${product.name}</option>
			</c:forEach>
		</select> 
		<input class="input" class="button" type="submit" value="Add Product" />
	</form>

</body>
</html>