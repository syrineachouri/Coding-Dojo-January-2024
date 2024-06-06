<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!-- for Bootstrap CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-3">
<h1>Registration</h1>
<form:form action="/register" method="post" modelAttribute="user">
    <p>
        <form:label path="userName">username</form:label>
        <form:errors path="userName" />
        <form:input path="userName"/>
    </p>
    <p>
        <form:label path="email">email</form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
    </p>
    <p>
        <form:label path="password">password</form:label>
        <form:errors path="password"/>
        <form:input type ="password" path="password"/>
    </p>
    <p>
        <form:label path="confirm">confirm</form:label>
        <form:errors path="confirm"/>     
        <form:input type ="password" path="confirm"/>
    </p>   

    <input type="submit" value="Submit"/>
</form:form>

<h1>User Login</h1>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <p>
        <form:label path="email">email</form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
    </p>
    <p>
        <form:label path="password">password</form:label>
        <form:errors path="password"/>
        <form:input type ="password" path="password"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>