<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Charles Teng's Counter assignment</title>
</head>
<body>
	<p>You have visited <a href="/">localhost:8080</a> ${count} times.</p>
	<a href="/">Test another visit?</a><br>
	<a href="/reset">Reset counter</a>
</body>
</html>