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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>

	<h3>Add Ninja :</h3>
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}">
				<form:option value="${dojo.id}" path="dojo">
					<c:out value="${dojo.name}" />
				</form:option>
			</c:forEach>
		</form:select>
		<div>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName" class="text-danger" />
			<form:input path="firstName" type="text" class="form-control"></form:input>
		</div>
		<div>
			<form:label path="LastName">Last Name:</form:label>
			<form:errors path="LastName" class="text-danger" />
			<form:input path="LastName" type="text" class="form-control"></form:input>
		</div>
		<div>
			<form:label path="age">Age:</form:label>
			<form:errors path="age" class=" text-danger" />
			<form:input path="age" type="number" class="form-control"></form:input>
		</div>
		<input type="submit" value="Submit!" />
	</form:form>

<a href="/dojo">Back</a>

</body>
</html>