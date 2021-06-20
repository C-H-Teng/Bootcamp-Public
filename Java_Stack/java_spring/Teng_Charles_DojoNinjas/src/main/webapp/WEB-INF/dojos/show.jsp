<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>${dojo.name}'s details</title>
</head>
<body>
	<div class="container">

		<h1>Ninjas in ${dojo.name}</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ninjas}" var="ninja">
				<tr>
					<td><c:out value="${ninja.first_name}"/> <c:out value="${ninja.last_name}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/ninjas/new">Add ninja</a>

	</div>
</body>
</html>