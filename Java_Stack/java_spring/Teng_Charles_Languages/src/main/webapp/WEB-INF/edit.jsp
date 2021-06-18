<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isErrorPage="true" %>
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
		<div class="aliRight">
			<form action="/languages/${language.id}" method="POST">
				<input type="hidden" name="_method" value="delete">
				<span class="buttonLink"><input type="submit" value="Delete"></span> |
				<a href="/languages">Dashboard</a>
			</form>
		</div>
		
		<form:form action="/languages/${language.id}" method="POST" modelAttribute="language">
			<input type="hidden" name="_method" value="PUT">
		<div class="row">
			<h3>Name</h3>
			<span class="error"><form:errors path="name"/></span>
			<form:input path="name"/>
		</div>
		<div class="row">
			<h3>Creator</h3>
			<span class="error"><form:errors path="creator"/></span>
			<form:input path="creator"/>
		</div>
		<div class="row">
			<h3>Version</h3>
			<span class="error"><form:errors path="version"/></span>
			<form:input path="version"/>
		</div>
		<div class="button"><input type="submit" value="Submit"/></div>
	</form:form>
	</div> <!-- container div end -->
</body>
</html>