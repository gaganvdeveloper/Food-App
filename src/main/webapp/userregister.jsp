<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register Page</title>
</head>
<body>
	<h1>User Login Page</h1>
	<form action="userregister">
	Name : <input type="text" name="name"><br><br> 
	Email : <input type="text" name="email"><br><br> 
	Password : <input type="text" name="password"><br><br> 
	<select name="role">
		<option>----Select Role----</option>
		<option>BRANCHMANAGER</option>
		<option>CUSTOMER</option>
		<option>STAFF</option>
		<option>ADMIN</option>
	</select>
	<br><br>
	<input type="submit" value="User-Register"> 
	</form>
</body>
</html>