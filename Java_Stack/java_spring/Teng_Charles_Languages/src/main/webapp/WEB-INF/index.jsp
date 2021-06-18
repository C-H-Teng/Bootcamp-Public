<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Charles Teng's Languages assignment</title>
</head>
<body>
	<div class="container">
	<h1>All Languages</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${langList}" var="lang">
			<tr>
				<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
				<td><c:out value="${lang.creator}"/></td>
				<td><c:out value="${lang.version}"/></td>
				<td>
					<form action="/languages/${lang.id}" method="POST">
						<input type="hidden" name="_method" value="delete">
						<span class="buttonLink"><input type="submit" value="Delete"></span> |
						<a href="/languages/${lang.id}/edit">Edit</a>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

		<h2>Add Language</h2>
	<form:form action="/languages" method="POST" modelAttribute="language">
		<div class="row">
			<h3>Name</h3>
			<form:input path="name"/>
		</div>
			<span class="error"><form:errors path="name"/></span>
		<div class="row">
			<h3>Creator</h3>
			<form:input path="creator"/>
		</div>
			<span class="error"><form:errors path="creator"/></span>
		<div class="row">
			<h3>Version</h3>
			<form:input path="version"/>
		</div>
			<span class="error"><form:errors path="version"/></span>
		<div class="button"><input type="submit" value="Submit"/></div>
	</form:form>
	</div> <!-- container div end -->
</body>
</html>