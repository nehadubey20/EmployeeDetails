<%@page import="Bean.SignUpBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Details</title>
</head>
<style type="text/css">

table{
	margin-left:20%;
	margin-top:5%;
	border:solid;
	border-width: 2%;
	align-content: center;
}

a{

text-decoration: none;
}
</style>



<body>
<table border="1">

<tr>
	<th>ID</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>E-mail</th>
	<th>Phone No</th>
	<th>Gender</th>
	<th>City</th>
	<th>Action</th>
</tr>
<%  ArrayList arrlst = (ArrayList)getServletContext().getAttribute("showData");  %>
<%  for(int i=0;i<arrlst.size();i++) { 
	SignUpBean b1 = (SignUpBean)arrlst.get(i); %>
<tr>
	<td><%=b1.getId() %></td>
	<td><%=b1.getFname() %></td>
	<td><%=b1.getLname() %></td>
	<td><%=b1.getEmail() %></td>
	<td><%=b1.getPhone() %></td>
	<td><%=b1.getGender() %></td>
	<td><%=b1.getCity() %></td>
	<td><a href="UpdateSignUp?user_id=<%=b1.getId()%>">Update</a> / 
	<a href="DeleteSelected?user_id=<%=b1.getId()%>">Delete</a></td>
</tr>
<% } %>
</table>

</body>
</html>