<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<h1>Register!</h1>

	<p><form:errors path="user.*" /></p>
	<p><c:out value="${error}" /></p>

	<form:form method="POST" action="/register" modelAttribute="user">
		<p>
			<form:label path="email">Email:</form:label>
			<form:input type="email" path="email" />
		</p>
		<p>
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
		</p>
		<p>
			<form:label path="passwordConfirm">Password Confirmation:</form:label>
			<form:password path="passwordConfirm" />
		</p>
		<input type="submit" value="Register!" />
	</form:form>

</body>
</html>
