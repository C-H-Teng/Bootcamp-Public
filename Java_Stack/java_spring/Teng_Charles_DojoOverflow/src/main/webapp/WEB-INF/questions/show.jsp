<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title><c:out value="${quest.question}"/></title>
</head>
<body>
	<div class="container">

	<h1><c:out value="${quest.question}"/></h1>
	<div class="row">
		<div class="leftHalf">
			<div class="row">
				<h3>Tags:</h3>
				<p><c:out value="${quest.tagDisp()}"/></p>
			</div>
			<table>
				<thead>
					<tr>
						<td><h3>Answers</h3></td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${answers}" var="ans">
					<tr>
						<td><c:out value="${ans.getAnswer()}"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	
		<div class="rightHalf">
			<a href="/questions">Return to questions</a>
			<h3>Add your answer:</h3>
			<form action="/questions/${id}/answer" method="POST">
				<textarea name="answer"></textarea>
				<div class="button"><input type="submit" value="Submit"/></div>
			</form>
		</div>
	</div>

	</div>
</body>
</html>