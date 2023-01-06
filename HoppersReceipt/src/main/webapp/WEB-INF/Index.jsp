<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<meta charset="UTF=8">
<title>Receipt</title>
</head>
<body>

<h1>The World Is Yours!</h1>

<h1>Customer Name: <c:out value="${fullName}"></c:out></h1>
<h4>Item Name: <c:out value="${itemName}"></c:out></h4>
<h4>Price:$ <c:out value="${price}"></c:out></h4>
<h4>Description: <c:out value="${description}"></c:out></h4>
<h4>Vendor: <c:out value="${vendor}"></c:out></h4>


</body>
</html>