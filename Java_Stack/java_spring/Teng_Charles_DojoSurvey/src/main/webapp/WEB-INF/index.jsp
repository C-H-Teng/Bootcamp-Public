<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Charles Teng's Dojo Survey assignment</title>
</head>
<body>
	<div class="container">

		<form method="POST" action="/submit">
			<div class="row">
				<h3>Your Name:</h3>
				<input type="text" name="name">
			</div>

			<div class="row">
				<h3>Dojo Location:</h3>
				<select name="loc">
					<option value="San Jose">San Jose</option>
					<option value="Seattle">Seattle</option>
					<option value="New York">New York</option>
					<option value="Austin">Austin</option>
				</select>
			</div>

			<div class="row">
				<h3>Favorite Language:</h3>
				<select name="favLang">
					<option value="Java">Java</option>
					<option value="JavaScript">JavaScript</option>
					<option value="Python">Python</option>
					<option value="C#">C#</option>
				</select>
			</div>

			<h3>Comment (optional):</h3>
			<textarea name="comment" rows="4" cols="30"></textarea>
			<button type="submit" value="submit">Submit</button>
		</form>

	</div>
</body>
</html>