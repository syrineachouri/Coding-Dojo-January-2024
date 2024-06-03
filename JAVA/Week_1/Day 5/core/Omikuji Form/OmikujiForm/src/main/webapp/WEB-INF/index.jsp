<%@ page language="java" contentType="text/html; charset=UTF-8*"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<div>
		<form action="/omikuji/post" method="POST">
			<label for="counter">Pick any number from 5 to 25: </label>
			<input type="number" name="counter" class="counter"/>
			<label for="city">Enter the name of any city: </label>
			<input type="text" name="city"/>
			<label for="person">Enter the name of any real person: </label>
			<input type="text" name="person"/>
			<label for="pursuit">Enter professional endeavor or hobby: </label>
			<input type="text" name="pursuit"/>
			<label for="thing">Enter any type of living thing: </label>
			<input type="text" name="thing"/>
			<label for="message">Say something nice to someone: </label>
			<textarea name="message" cols="30" rows="7"></textarea>
			<label for="submit">Send and show a friend</label>
			<input type="submit" name="sumbit"/>
		</form>
	</div>
</body>
</html>