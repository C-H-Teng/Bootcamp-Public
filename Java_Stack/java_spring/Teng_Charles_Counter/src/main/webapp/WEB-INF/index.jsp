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
	<h1>Welcome User!</h1>
	<h3>Count incrementing by 1</h3>
	<h4>Current count: ${count}</h4>
	<h4><a href="/counttotal">Go to count page</a></h4>
</body>
</html>