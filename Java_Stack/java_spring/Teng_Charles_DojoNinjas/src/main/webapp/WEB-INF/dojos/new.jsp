<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Add Dojo</title>
</head>
<body>
	<div class="container">

		<h1>New Dojo</h1>
		<form:form action="/dojos" method="POST" modelAttribute="dojo">
			<div class="row">
				<h3>Name</h3>
				<form:input path="name"/>
			</div>
			<div class="button"><input type="submit" value="Create"/></div>
		</form:form>

	</div>
</body>
</html>