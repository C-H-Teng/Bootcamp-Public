<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title><c:out value="${category.name}"/></title>
</head>
<body>
	<div class="container">

		<h1><c:out value="${category.name}"/></h1>
		<div class="row">
			<div class="col">
				<h2>Products:</h2>
				<c:forEach items="${prodInCat}" var="prod">
					<ul>
						<li><c:out value="${prod.name}"/></li>
					</ul>
				</c:forEach>
			</div> <!-- products in category list div end -->
			
			<form action="/categories/${category.id}/cat" method="POST">
				<div class="row">
				<p>Add Product:</p>
				<select name="product_id">
					<option value="" disabled selected>Pick a Product</option>
					<c:forEach items="${notInCat}" var="product">
						<option value="${product.id}">
							<c:out value="${product.name}"/>
						</option>
					</c:forEach>
				</select>
				</div>
				<div class="button"><input type="submit" value="Add product to <c:out value="${category.name}"/>"/></div>
			</form>
		</div>
		<div class="row">
			<a href="/categories">Return to categories</a>
			<a href="/products">Go to products</a>
		</div>

	</div>
</body>
</html>