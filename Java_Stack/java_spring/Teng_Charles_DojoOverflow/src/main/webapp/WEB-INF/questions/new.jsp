<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>New Question</title>
</head>
<body>
	<div class="container">

		<h1>What is your question?</h1>
		<form action="/questions" method="POST">
			<div class="row">
				<h3>Question:</h3>
				<textarea name="question" rows="5" cols="30"></textarea>
			</div>
			<div class="row">
				<h3>Tags:</h3>
				<input type="text" name="tag"/>
			</div>
			<div class="button"><input type="submit" value="Submit"/></div>
		</form>
		<p class="error">
			<c:out value="${questError}"/> <br>
			<c:out value="${tagError}"/>
		</p>

	</div>
</body>
</html>