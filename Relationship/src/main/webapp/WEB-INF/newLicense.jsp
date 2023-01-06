<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>New License</h1>

<form:form action="licenses" method="POST" modelAttribute="license">

	<form:label path="person">Person:</form:label>
	 <form:select path="person">
        <c:forEach var="onePerson" items="${persons}">
            <!--- Each option VALUE is the id of the person --->
            <form:option value="${onePerson.id}" path="person">
            <!--- This is what shows to the user as the option --->
                <c:out value="${onePerson.firstName}"/>
                <c:out value="${onePerson.lastName}"/>
            </form:option>
        </c:forEach>
    </form:select>
	
	<form:label path="state">State:</form:label>
	<form:input type="text" path="state"></form:input>
	
	<form:label path="experationDate">Exp Date:</form:label>
	<form:input type="date" path="experationDate"></form:input>
	
	<button type="submit">Create!</button>
	
</form:form>


</body>
</html>