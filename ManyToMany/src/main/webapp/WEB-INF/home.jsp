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
<title>Home</title>
</head>
<body>

	<h1>----Home Page----</h1>
	<a href="/new/product"><button>New Product</button></a>
	<a href="/new/category"><button>New Category</button></a>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Products</th>
				<th>Categories</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<ul>
						<c:forEach var="product" items="${products }">
							<li>
							<a href="/view/product/${product.id}"><c:out value="${product.name }" /></a>
							</li>
						</c:forEach>
					</ul>
				</td>
				<td>
					<ul>
						<c:forEach var="category" items="${categories }">
							<li>
							<a href="/view/${category.id}/category"><c:out value="${category.name }" /></a>
							</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>


</body>
</html>