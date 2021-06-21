<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>New Product</title>
</head>
<body>
	<div class="container">

		<h1>Add a product</h1>
		<form:form action="/products" method="POST" modelAttribute="product">
			<div class="row">
				<h3>Name:</h3>
				<form:input path="name"/>
			</div>
			<div class="row">
				<h3>Description:</h3>
				<form:input path="description"/>
			</div>
			<div class="row">
				<h3>Price:</h3>
				<form:input path="price"/>
			</div>
			<div class="button"><input type="submit" value="Create"/></div>
		</form:form>

	</div>
</body>
</html>