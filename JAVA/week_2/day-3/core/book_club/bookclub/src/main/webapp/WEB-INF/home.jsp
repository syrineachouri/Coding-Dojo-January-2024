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
<div class="container">
    <div class="d-flex align-items-center justify-content-between" >
        <h1>Welcome,<c:out value="${user.name}" /></h1>
        <a href="/logout">Logout</a>
    </div>
    <div class="d-flex align-items-center justify-content-between">
        <p>Books from everyone's shelves.</p>
        <a href="/books/new">+ Add a book to my shelf</a>
    </div>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author Name</th>
                <th>Posted By</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allBook}" var="book">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.postedBy.name}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>