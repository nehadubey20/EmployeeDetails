<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
</head>
<style>
	a{
		text-decoration: none;
		font-size:large;
		color:black;
	}
	.emp{
		margin-left: 20%;
		margin-right:5%;
	}
	button
	{
		  background-color:#fbffa6;
		  border: none;
		  color: white;
		  padding: 15px 32px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;		
	}
	
</style>
<body>
	<table>
		<div class="emp">
		<h1>Employee Detail</h1>
		<button><a href="addEmp.jsp">Insert Data</a></button>&nbsp;
		<button><a href="ShowEmp.jsp">Show Data</a></button>&nbsp;
		<button><a href="signup.jsp">Sign Up</a></button>&nbsp;
	
	</div>
</table>


</body>
</html>