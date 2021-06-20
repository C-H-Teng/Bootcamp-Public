<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>All dojos</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<h1>All Dojos</h1>
			<a href="/dojos/new">Add a dojo</a>
		</div>
		<c:forEach items="${dojos}" var="dojo">
			<a href="/dojos/${dojo.id}">${dojo.name}</a>
		</c:forEach>
		<a href="/ninjas">View all Ninjas</a>

	</div>
</body>
</html>