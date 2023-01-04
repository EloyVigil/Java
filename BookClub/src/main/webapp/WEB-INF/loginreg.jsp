<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Login or Register</title>
</head>
<body>
	<h1>Book Club'n!</h1>
	<p>A place for friends to share thoughts on books!</p>
	<div>
		<h1>Register</h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<div>
				<form:label path="userName">User Name:</form:label>
				<form:errors path="userName" class="text-danger" />
				<form:input path='userName' type="text" class="form-control"></form:input>
			</div>
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="text-danger" />
				<form:input path='email' type="email" class="form-control"></form:input>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" class="text-danger" />
				<form:input path='password' type="password" class="form-control"></form:input>
			</div>
			<div>
				<form:label path="confirm">Confirm Password:</form:label>
				<form:errors path="confirm" class="text-danger" />
				<form:input path='confirm' type="password" class="form-control"></form:input>
			</div>
			<input type="submit" value="Register!" />
		</form:form>
	</div>
	<div>
		<h1>Login</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="text-danger" />
				<form:input path='email' type="email" class="form-control"></form:input>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" class="text-danger" />
				<form:input path='password' type="password" class="form-control"></form:input>
			</div>
			<input type="submit" value="Login!" />
		</form:form>
	</div>

</body>
</html>