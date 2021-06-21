<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>All Categories</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<h1>All Categories</h1>
			<a href="/categories/new">Add a category</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${categories}" var="cat">
				<tr>
					<td><a href="/categories/${cat.id}"><c:out value="${cat.name}"/></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/products">View all Products</a>

	</div>
</body>
</html>