<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding= "UTF-8" %>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<h1> Fruit Store </h1>
	
	<div class = "container">
	
		<table class = "table">
		
			<tr>
			
				<th> Name </th>
				
				<th> Price </th>
			
			</tr>
			
			<c:forEach var = "fruit" items = "${fruit}">
			
				<tr>
					
					<td> ${fruit.name} </td>
					
					<td> ${fruit.price} </td>
					
				</tr>
		
			</c:forEach>
		</table>
	
	</div>

</body>
</html>