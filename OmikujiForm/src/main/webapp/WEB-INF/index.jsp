<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/indexstyle.css">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div id="container">
		<h1>Send an Omikuji!</h1>
		<div id="form">
				<form action="/omikuji/formsubmit" method="POST">
			<div>
				<label for="">Pick any number form 5 to 25!</label>
				<input type="number" name="number" min="5" max="25"/>
			</div>
			<div>
				<label for="">Enter the name of any city.</label>
				<input type="text" name="city"/>
			</div>
			<div>
				<label for="">Enter the name of a real person.</label>
				<input type="text" name="person"/>
			</div>
			<div>
				<label for="">Enter a professional endeavor of hobby.</label>
				<input type="text" name="hobby"/>
			</div>
			<div>
				<label for="">Enter any type of living thing.</label>
				<input type="text" name="thing"/>
			</div>
			<div>
				<label for="">Say something nice to someone!</label>
			</div>
			<div>
				<textarea name="quote" id="" cols="30" rows="10"></textarea>
			</div>
			<input type="submit" value="submit!" />
			</form>
		</div>
	</div>



</body>
</html>