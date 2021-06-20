<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>All Ninjas</title>
</head>
<body>
<div class="container">

		<div class="row">
			<h1>All Ninjas</h1>
			<a href="/ninjas/new">Add a ninja</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Dojo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ninjas}" var="ninja">
				<tr>
					<td>${ninja.first_name} ${ninja.last_name}</td>
					<td>${ninja.age}</td>
					<td>${ninja.dojo.name}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/dojos">View all Dojos</a>

	</div>
</body>
</html>