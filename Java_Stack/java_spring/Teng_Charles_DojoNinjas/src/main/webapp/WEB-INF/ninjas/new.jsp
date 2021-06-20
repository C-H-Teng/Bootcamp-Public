<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>New Ninjas</title>
</head>
<body>
	<div class="container">

	<h1>Add a ninja</h1>
	<form:form action="/ninjas" method="POST" modelAttribute="ninja">
		<div class="row">
			<h3>First Name:</h3>
			<form:input path="first_name"/>
		</div>
		<div class="row">
			<h3>Last Name:</h3>
			<form:input path="last_name"/>
		</div>
		<div class="row">
			<h3>Age:</h3>
			<form:input path="age"/>
		</div>
		<div class="row">
			<h3>Dojo:</h3>
			<form:select path="dojo">
				<option value="" disabled selected>Pick a Dojo</option>
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.id}">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="button"><input type="submit" value="Create"/></div>
		
		<span class="error"><form:errors path="first_name"/></span>
		<span class="error"><form:errors path="last_name"/></span>
		<span class="error"><form:errors path="age"/></span>
		<span class="error"><form:errors path="dojo"/></span>
	</form:form>

	</div>
</body>
</html>