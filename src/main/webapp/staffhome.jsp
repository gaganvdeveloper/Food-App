<%@page import="com.tyss.foodapp.dto.Item"%>
<%@page import="java.util.List"%>
<%@page
	import="com.tyss.foodapp.service.implementation.ItemServiceImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Home Page</title>


<%
ItemServiceImplementation service = new ItemServiceImplementation();

List<Item> items = service.findAllItems();
%>

</head>
<body>
	<h1>Welcome to Staff Home Page Mr.${name }</h1>
	<h2>Your Role : ${role }</h2>

	<hr>

	<h2>Create Item :</h2>
	<form action="createitem">
		Item name : <input type="text" name="name"> <br> <br>
		Product ID : <input type="text" name="productId"> <br> <br>
		Type : <select name="type">
			<option>----Select----</option>
			<option>VEG</option>
			<option>NONVEG</option>
		</select> <br> <br> Quantity : <input type="number" name="quantity">
		<br> <br> Price : <input type="text" name="price"> <br>
		<br>

		<button type="submit">Create Item</button>

	</form>



	<br>
	<hr>


	<h2>Create Food Order :</h2>

	<form action="createfoodorder">
		<br> Customer Name : <input type="text" name="customerName"><br>
		<br> Customer Phone Number : <input type="text"
			name="customerPhoneNumber"> <br> <br>Status : <select
			name="status">
			<option>----Select----</option>
			<option>ACCEPTED</option>
			<option>PREPARING</option>
			<option>ONTHEWAY</option>
			<option>DELIVERD</option>
			<option>NOTACCEPTED</option>
		</select> <br> <br>

		<h3>Select Items :</h3>
		<table border="1" cellpadding="10" cellspacing="1"
			style="text-align: center;">

			<tr>
				<th>Name</th>
				<th>Type</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Select</th>
			</tr>

			<%
			for (Item item : items) {
			%>

			<tr>
				<td><%=item.getName()%></td>
				<td><%=item.getType()%></td>
				<td><%=item.getQuantity()%></td>
				<td><%=item.getPrice()%></td>
				<td><input type="checkbox" name="itemId"
					value="<%=item.getId()%>"></td>
			</tr>
			<%
			}
			%>
		</table>

		<br>
		<br>

		<button
			style="color: white; background-color: darkgreen; border: none; outline: none; font-size: 15px; border-radius: 7px; font-weight: bold; padding: 10px;"
			type="submit">Create FoodOrder</button>
	</form>


	<hr>

	<h3>All Items Available :</h3>
	<table border="1" cellpadding="10" cellspacing="1"
		style="text-align: center;">

		<tr>

			<th>ID</th>
			<th>Product ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Delete</th>
		</tr>

		<%
		for (Item item : items) {
		%>

		<tr>
			<td><%=item.getId()%></td>
			<td><%=item.getProductId()%></td>
			<td><%=item.getName()%></td>
			<td><%=item.getType()%></td>
			<td><%=item.getQuantity()%></td>
			<td><%=item.getPrice()%></td>
			<td><a href="deleteitem?id=<%=item.getId()%>"><button
						type="button"
						style="color: white; background-color: crimson; border: none; outline: none; font-size: 15px; border-radius: 7px; font-weight: bold; padding: 5px;">Delete</button></a>
			</td>
		</tr>
		<%
		}
		%>
	</table>

	<br>
	<hr>



	<br>
	<br>
	<br>
	<br>
	<br>












	<center>
		<a href="userlogout"><button
				style="color: white; background-color: crimson; border: none; outline: none; width: 100px; height: 50px; font-size: 20px; border-radius: 10px;">Logout</button></a>
	</center>









</body>
</html>