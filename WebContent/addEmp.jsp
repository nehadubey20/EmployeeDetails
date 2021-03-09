<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
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


<body>
<div class="emp-form">

 		<h1>Employee Form</h1>

			<form action="Insert" method="post">
				<h3>Enter Employee Name:</h3>
				<input type="text" name="name" value="" placeholder="Enter name"/><br>
				<h3>Enter Company:</h3>
				<input type="text" name="company" value="" placeholder="Enter Company Name"/><br>
				<h3>Enter Salary:</h3>
				<input type="number" name="salary" value="" placeholder="Enter Your Salary"/><br>
				<h3>Enter E-mail:</h3>
				<input type="email" name="email" value="" placeholder="Enter Your E-mail"/><br>
				<h3>Enter Phone:</h3>
				<input type="tel" name="phone" value="" placeholder="Enter Your Phone Number"/><br>

				<button>Submit</button><br>
				<button>Reset</button>
				
			</form>
		</div>

</body>
</html>