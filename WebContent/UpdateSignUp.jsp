<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
	padding: 1%;
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
.emp-form radio
{
	display:flex;
	flex-direction: row;
	padding:2%;
}
.emp-form button
{
	border-width: 8px;
	border: solid;
	font-size: large;
	height: 30px;
	width:30%;
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
				
				<div class="radio">
				<h4>Select Gender</h4>
				<% String str= sb.getGender(); %>
				<input type="radio" value="Male" <%=str.equals("Male")?"checked":"" %> name="gender" >Male
				<input type="radio" value="Female" <%=str.equals("Female")?"checked":"" %> name="gender" >Female</br>
				</br>
				
				
				<h4>Choose your city:</h4>
				
					<select name="city" id="city">
					<%String strr = sb.getCity(); %>
				
					  <option value="Indore"<%= strr.equalsIgnoreCase("Indore")?"selected":"" %>>Indore</option>
					  <option value="Bhopal"<%= strr.equalsIgnoreCase("Bhopal")?"selected":"" %>>Bhopal</option>
					  <option value="Dewas"<%= strr.equalsIgnoreCase("Dewas")?"selected":"" %>>Dewas</option>
					  <option value="Pune"<%= strr.equalsIgnoreCase("Pune")?"selected":"" %>>Pune</option>
					</select></br>
								
				
			 <h4>Select your device</h4>
				<%String st = sb.getDev();%>
				  
				  <input type="checkbox" id="Laptop" name="device" value="Laptop" <%=st.indexOf("Laptop")!=-1?"checked":""%> />
				  <label for="Laptop"> I have a laptop</label></br>			  
				  <input type="checkbox" id="PC" name="device"  value="PC" <%=st.indexOf("PC")!=-1?"checked":""%>/>
				  <label for="PC"> I have a PC</label></br>
				  <input type="checkbox" id="Tablet" name="device" value="Tablet" <%=st.indexOf("Tablet")!=-1?"checked":""%> />
				  <label for="Tablet"> I have a Tablet</label></br>	
			      <input type="checkbox" id="MacBook" name="device" value="MacBook" <%=st.indexOf("MacBook")!=-1?"checked":""%> />
				  <label for="MacBook"> I have a MacBook</label></br>
			
				<button type="submit">Update</button>
				<button type="reset">Reset</button>
				</div>	
			</form>
			
		</div>
</body>
</html>