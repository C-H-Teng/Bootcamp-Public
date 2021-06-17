<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${title}"/></h1>
	
	<p>Description: <c:out value="${description}"/></p>
	<p>Language: <c:out value="${language}"/></p>
	<p>Number of pages: <c:out value="${numberOfPages}"/></p>
	
	<a href="/books/${id}/edit">Edit Book</a>
	
	<form action="/books/${id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
</body>
</html>