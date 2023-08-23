<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch-Manager Home Page</title>
</head>
<body>
	<h1>Welcome to Branch Manager Home Page Mr.${name }</h1>
	<h2>Your Role : ${role }</h2>




	<h3>1) Create Stadff Here</h3>

	<form action="userregister">
		Name : <input type="text" name="name"><br> <br>
		Email : <input type="text" name="email"><br> <br>
		Password : <input type="text" name="password"><br> <br>
		Role : <input type="text" value="STAFF" readonly="readonly" name="role"> <br><br> 
		<input type="submit" value="CREATE-STAFF"> <input type="reset" value="RESET">
	</form>

	<h3>2) Find Staff By Id : </h3>
	
	<input type="text"><br><br>
	<button type="submit">Find Staff</button>


	<h3>3) Create Menu</h3>
	
	<input type="text" name="menulist">
	
	
	





	<br>
	<br>
	<br>
	<br>
	<br>
	<center>
		<a href="userlogout"><button>Logout</button></a>
	</center>
</body>
</html>