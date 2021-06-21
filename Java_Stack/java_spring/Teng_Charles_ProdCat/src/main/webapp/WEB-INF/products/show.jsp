<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title><c:out value="${product.name}"/> details</title>
</head>
<body>
	<div class="container">

		<h1><c:out value="${product.name}"/></h1>
		<div class="row">
			<div class="col">
				<h2>Categories:</h2>
				<c:forEach items="${catInProd}" var="cat">
					<ul>
						<li><c:out value="${cat.name}"/></li>
					</ul>
				</c:forEach>
			</div> <!-- categories in product list div end -->
			
			<form action="/products/${product.id}/prod" method="POST">
				<div class="row">
				<p>Add Product:</p>
				<select name="category_id">
					<option value="" disabled selected>Pick a Category</option>
					<c:forEach items="${notInProd}" var="category">
						<option value="${category.id}">
							<c:out value="${category.name}"/>
						</option>
					</c:forEach>
				</select>
				</div>
				<div class="button"><input type="submit" value="Add product to <c:out value="${product.name}"/>"/></div>
			</form>
		</div>
		<div class="row">
			<a href="/products">Return to products</a>
			<a href="/categories">Go to categories</a>
		</div>

	</div>
</body>
</html>