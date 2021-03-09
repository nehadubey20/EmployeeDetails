<%@page import="java.util.ArrayList"%>
<%@page import="Bean.SignUpBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Sign Up Content</title>

<style>
	*{
	margin: 0;
	padding: 0;
}
.emp-form
{
	margin: 1%;
	padding: 2%;
}

.emp-form form
{
	/*width: 50%;*/
	padding: 2%;
	display: flex;
	flex-direction: column;
	align-self: center;
	width: 30%;
	height: auto;
	float:left;
	margin-right: 30px;
}

.emp-form input
{
	border-width: 3px;
	height: 30px;
	margin-bottom: 1%;
	font-size: 15px;
	border: groove;

}

.emp-form button
{
	border-width: 8px;
	border: solid;
	font-size: large;
	height: 40px;
	width:40%;
}
</style>

</head>
<body>
<div class="emp-form">

 		<h1>Sign UP Form -- UPDATION </h1>
 		<% ArrayList al = (ArrayList)getServletContext().getAttribute("UserData");

 			SignUpBean sb = (SignUpBean)al.get(0); %>
			<form action="UpdateSignUp" method="post">
			<h3>Your id is:</h3>
			<input type="text" name="user_id" value=<%=sb.getId() %> readonly="readonly"/>
				<h3>First Name:</h3>
				<input type="text" name="fname" value="<%=sb.getFname() %>" /><br>
				<h3>Last Name:</h3>
				<input type="text" name="lname" value="<%=sb.getLname() %>" /><br>
				<h3>E-mail:</h3>
				<input type="email" name="email" value="<%=sb.getEmail() %>" /><br>
				<h3>Phone:</h3>
				<input type="tel" name="phone" value="<%=sb.getPhone() %>" /><br>
				<h3>Password:</h3>
				<input type="text" name="password" value="<%=sb.getPassword() %>"/><br>
				<button type="submit">Update</button><br>
				<button type="reset">Reset</button>
				
			</form>
		</div>


</body>
</html>