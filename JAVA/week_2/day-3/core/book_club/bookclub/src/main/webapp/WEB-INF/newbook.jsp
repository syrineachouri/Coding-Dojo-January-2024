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
</head>
<body>
<div class="container mt-3">
	<div  class="d-flex align-items-center justify-content-between">
        <h1>Add a Book to Your Shelf</h1>
        <a href="/books">back to the shelves</a>
    </div>
    <form:form method="post" action="/processbook" modelAttribute="book">
            <div class="form-group">
                <label for="title">Title</label>
                <form:input path="title" id="title" class="form-control" />
                <form:errors path="title" cssClass="error" />
            </div>
            <div class="form-group">
                <label for="author">Author</label>
                <form:input path="author" id="author" class="form-control" />
                <form:errors path="author" cssClass="error" />
            </div>
            <div class="form-group">
                <label for="thoughts">My Thoughts</label>
                <form:textarea path="thoughts" id="thoughts" class="form-control" />
                <form:errors path="thoughts" cssClass="error" />
            </div>
            <div>
                <input type="submit" value="Submit" class="btn btn-primary" />
            </div>
    </form:form>
</div>
</body>
</html>