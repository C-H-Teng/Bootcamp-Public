<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Charles Teng's Ninja Gold assignment</title>
</head>
<body>
	<div class="container">

	<h3>Your Gold: <c:out value="${gold_count}"/></h3>
	<form action="/reset" method="POST">
		<button type="submit" value="submit">Reset</button>
	</form>
	<div id="gather_loc">
		<div class="box"> <!-- farm div -->
			<h2>Farm</h2>
			<h3>(earns 10-20 gold)</h3>
			<form action="/makeGold" method="POST">
				<input type="hidden" name="loc" value="farm">
				<button type="submit" value="submit">Find Gold!</button>
			</form>
		</div> <!-- farm div end -->
	
		<div class="box"> <!-- cave div -->
			<h2>Cave</h2>
			<h3>(earns 5-10 gold)</h3>
			<form action="/makeGold" method="POST">
				<input type="hidden" name="loc" value="cave">
				<button type="submit" value="submit">Find Gold!</button>
			</form>
		</div> <!-- cave div end -->
	
		<div class="box"> <!-- house div -->
			<h2>House</h2>
			<h3>(earns 2-5 gold)</h3>
			<form action="/makeGold" method="POST">
				<input type="hidden" name="loc" value="house">
				<button type="submit" value="submit">Find Gold!</button>
			</form>
		</div> <!-- house div end -->
	
		<div class="box"> <!-- casino div -->
			<h2>Casino</h2>
			<h3>(earns/takes 0-50 gold)</h3>
			<form action="/makeGold" method="POST">
				<input type="hidden" name="loc" value="casino">
				<button type="submit" value="submit">Find Gold!</button>
			</form>
		</div> <!-- casino div end -->
	</div> <!-- gather loc div end -->
	
	<h3>Activities:</h3>
	<div class="activities_log">
		<c:forEach items="${activityList}" var="activity">
			<p><c:out value="${activity}"/></p>
		</c:forEach>
	</div>

	</div> <!-- container div end -->
</body>
</html>