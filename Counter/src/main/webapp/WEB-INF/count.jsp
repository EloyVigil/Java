<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>

<h1>You have visited <a href="/your_server">your server</a> site <c:out value="${count}"></c:out> times!</h1>

<a href="/your_server/reset">Reset Counter</a>

</body>
</html>