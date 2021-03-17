<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Sign Up</title>
</head>
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
	padding: 1%;
	display: flex;
	flex-direction: column;
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
.emp-form input radio
{
	display:flex;
	flex-direction:row;
	padding:10%;
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

 		<h3>Sign UP Form</h3>
			<form action="SignUp" method="post">
				<h4>Enter First Name:</h4>
				<input type="text" name="fname" value="" placeholder="Enter First name"/><br>
				<h4>Enter Last Name:</h4>
				<input type="text" name="lname" value="" placeholder="Enter Last name"/><br>
				<h4>Enter E-mail:</h4>
				<input type="email" name="email" value="" placeholder="Enter Your E-mail"/><br>
				<h4>Enter Phone:</h4>
				<input type="tel" name="phone" value="" placeholder="Enter Your Phone Number"/><br>
				<h4>Enter Password:</h4>
				<input type="password" name="password" value="" placeholder="Enter Your Password"/><br>
				
				<div class= radio>
				
				<h4>Select Gender</h4>
				<input type="radio" name="gender" value="Male">Male 
				<input type="radio" name="gender" value="Female">Female</br>
				</br>
				
				<h4>Choose your State:</h4>
					<select name="city" id="state">
					<option value="0">Select Your State</option>
					  
					   <option value="1">Madhya Pradesh</option>
					  <option value="2">Maharashtra</option>
					  <option value="3">Gujarat</option>
					  <option value="4">Rajasthan</option>
					  <option value="5">Tamil Nadu</option>   
 				</select></br></br>
				
				<h4>Choose your city:</h4>
					<select name="city" id="city">
					<option value="0">Select Your City</option>
					
					<!--  <option value="Indore">Indore</option>
					  <option value="Bhopal">Bhopal</option>
					  <option value="Dewas">Dewas</option>
					  <option value="Pune">Pune</option>  
					 --></select></br>
					</br>
					
				<h4>Select your device</h4>
				<input type="checkbox" id="Laptop" name="device" value="Laptop">
				  <label for="Laptop"> I have a Laptop</label><br>
				  <input type="checkbox" id="PC" name="device" value="PC">
				  <label for="PC"> I have a PC</label><br>
				  <input type="checkbox" id="Tablet" name="device" value="Tablet">
				  <label for="Tablet"> I have a Tablet</label><br>	
				  <input type="checkbox" id="Macbook" name="device" value="MacBook">
				  <label for="MacBook"> I have a MacBook</label><br>	
				  		
				<button>Sign Up</button>
				<button>Reset</button>
				</div>
			</form>
		</div>

</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#state").change(function(){
			var state = $(this).val();
			
			
			$.ajax({
				url:"SignUp",
				data:{state_id:state},
				success:function(res)
				{
					$("#city").html(res);
				},
				error:function(e)
				{
					alert("Error is:"+e);
				}
			});
		});
	});

</script>
</html>