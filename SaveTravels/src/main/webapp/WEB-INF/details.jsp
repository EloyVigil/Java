<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>  
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Details</title>
</head>
<body>

<a href="/travel">Home Page</a>
<h3>Expense Name: ${travel.expenseName}</h3>
<h3>Expense Description: ${travel.description}</h3>
<h3>Vendor: ${travel.vendor}</h3>
<h3>Amount Spent: ${travel.amount}</h3>


</body>
</html>