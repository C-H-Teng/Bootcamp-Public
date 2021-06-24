<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<h1>Questions Dashboard</h1>
			<a href="/questions/new">New question</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${questions}" var="quest">
				<tr>
					<td><a href="/questions/${quest.id}"><c:out value="${quest.question}"/></a></td>
					<td>${quest.tagDisp()}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>