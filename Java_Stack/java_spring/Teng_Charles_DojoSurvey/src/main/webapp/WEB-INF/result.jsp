<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Charles Teng's Dojo Survey assignment</title>
</head>
<body>
	<div class="container">

	<h2>Submitted Info</h2>
	<div class="row">
		<h3>Name:</h3>
		<p><c:out value="${name}"/></p>
	</div>
	<div class="row">
		<h3>Dojo Location:</h3>
		<p><c:out value="${loc}"/></p>
	</div>
	<div class="row">
		<h3>Favorite Language:</h3>
		<p><c:out value="${favLang}"/></p>
	</div>
	<div class="row">
		<h3>Comment:</h3>
		<p><c:out value="${comment}"/></p>
	</div>

	<a href="/">Go Back</a>

	</div>
</body>
</html>