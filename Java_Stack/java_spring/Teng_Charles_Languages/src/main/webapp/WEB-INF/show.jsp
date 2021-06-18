<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Charles Teng's Languages assignment</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1><c:out value="${language.name}"/></h1>
			<a href="/languages">Dashboard</a>
		</div>
		<div class="row">
			<h3>Creator:</h3>
			<p><c:out value="${language.creator}"/></p>
		</div>
		<div class="row">
			<h3>Version:</h3>
			<p><c:out value="${language.version}"/></p>
		</div>
		<div class="row">
			<form action="/languages/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<span class="buttonLink"><input type="submit" value="Delete"></span> |
				<a href="/languages/${language.id}/edit">Edit</a>
			</form>
		</div>
	</div> <!-- container div end -->
</body>
</html>