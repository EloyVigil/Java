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
<title>New Category</title>
</head>
<body>

<h1>New Category</h1>
<p><a href="/">Home</a></p>
<hr>

<form:form action="/new/category" method="post" modelAttribute="category">

	<table>
	    <thead>
	    	<tr>
	            <td >Name:</td>
	            <td >
					<form:input class="input" path="name"/>
	            </td>
	        </tr>
	        <tr>
	        	<td ><input class="input" class="button" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>
</body>
</html>