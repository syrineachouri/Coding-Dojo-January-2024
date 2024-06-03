<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="UTF-8">
<title>Show Page</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<p>In <span><c:out value="${counter}"/></span> years, you will live in <span><c:out value="${city}"/></span>
		with <span><c:out value="${person}"/></span> as your roommate, <span><c:out value="${pursuit}"/></span> 
		for a living. The next time you see a <span><c:out value="${thing}"/></span>, you will have good luck. Also,
		<span><c:out value="${message}"/></span>. </p>
	<a href="/omikuji">Go back</a>
</body>
</html>