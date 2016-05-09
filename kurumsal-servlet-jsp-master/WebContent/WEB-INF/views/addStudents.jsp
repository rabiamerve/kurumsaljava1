<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<script src="resources/js/jquery-1.11.3.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Student Information System</h2>

<%	
	if ((Boolean)request.getAttribute("Errors")){
%>
<div class="alert alert-danger" role="alert" >
<h3>ERRORS</h3>
<ul>
	<%
		if ((Boolean)request.getAttribute("firstname-error")){
	%>
	<li>First Name Error</li>
	<% }%>
	<%
		if ((Boolean)request.getAttribute("lastname-error")){
	%>
	<li>Last Name Error</li>
	<% }%>
	<%
		if ((Boolean)request.getAttribute("gender-error")){
	%>
	<li>Gender Error</li>
	<% }%>
</ul>
</div>
<% }%>
<form action="AddStudent" method="post">
<fieldset>
	<label for="first-name">First Name: </label>
	<input name="first-name" type="text">
	
	<label for="last-name">Last Name: </label>
	<input name="last-name" type="text">
	
	<label for="gender">Gender: </label>
	<select name="gender">
		<option value="Male">Male</option>
		<option value="Female">Female</option>
	</select>
	
	
</fieldset>

<input id="submitBtn" type="submit" value="Register Student">

</form>

</body>
</html>