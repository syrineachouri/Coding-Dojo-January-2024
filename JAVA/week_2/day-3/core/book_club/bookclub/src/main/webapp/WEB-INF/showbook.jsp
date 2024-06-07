<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container mt-3">
    <div class="d-flex align-items-center justify-content-between mb-5">
        <h1><c:out value="${book.title}"/></h1>
        <a href="/books">back to the shelves</a>
    </div>
    <c:if test="${book.postedBy.id == user.id}">
        <p class="span0"><span class="span1">You</span> read <span class="span2"><c:out value="${book.title}"/></span> by <span class="span3"><c:out value="${book.author}"/></span></p>
        <p>And Here are your thoughts:</p>
    </c:if>
    <c:if test="${book.postedBy.id != user.id}">
        <p class="span0"><span class="span1"><c:out value="${book.postedBy.name}"/></span> read <span class="span2"><c:out value="${book.title}"/></span> by <span class="span3"><c:out value="${book.author}"/></span></p> 
        <p>And Here are <c:out value="${book.postedBy.name}'s"/> thoughts:</p>
    </c:if>
    <hr>
    <p><c:out value="${book.thoughts}"/></p>
    <hr>
    <div class="text-right">
        <c:if test="${book.postedBy.id == user.id}">
            <a href="/books/${book.id}/edit" class="btn btn-primary">Edit</a>
            <form action="/books/delete/${book.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete" class="btn btn-danger d-flex">
			</form>
        </c:if>
    </div>
	

</div>
</body>
</html>