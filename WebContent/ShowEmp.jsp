<%@page import="Bean.BeanClass"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All employee Data</title>
</head>
<style type="text/css">

table{
	margin-left:20%;
	margin-top:5%;
	border:solid;
	border-width: 2%;
	align-content: center;
}
</style>

<body>
	
<table border="1"> 
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Company</th>
	<th>Salary</th>
	<th>Email</th>
	<th>Phone No</th>
	<th>Action</th>
</tr>
 <% ArrayList al = (ArrayList)getServletContext().getAttribute("empdata"); %>
 <% for(int i=0;i<al.size();i++) { 
	 BeanClass b = (BeanClass)al.get(i); %>
<tr>
		<td><%=b.getId() %></td>
		<td><%=b.getName() %></td>
		<td><%= b.getCompany() %></td>
		<td><%= b.getSalary() %></td>
		<td><%= b.getEmail() %></td>
		<td><%= b.getPhone() %></td>
		<td><a href="#?user_id=<%=b.getId() %>">Edit</a> / 
			<a href="#?user_id=<%=b.getId() %>">Delete</a>
			</td>
	
</tr>
<% } %>
</table>
</body>
</html>