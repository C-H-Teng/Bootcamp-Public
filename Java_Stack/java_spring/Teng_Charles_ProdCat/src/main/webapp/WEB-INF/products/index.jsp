<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>All Products</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<h1>All Products</h1>
			<a href="/products/new">Add a product</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${products}" var="prod">
				<tr>
					<td><a href="/products/${prod.id}"><c:out value="${prod.name}"/></a></td>
					<td><c:out value="${prod.description}"/></td>
					<td><c:out value="${prod.price}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/categories">View all Categories</a>

	</div>
</body>
</html>