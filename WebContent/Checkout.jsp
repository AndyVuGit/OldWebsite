<%@ page language="java" import="java.util.*, java.text.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ShoppingCart.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert your billing information</title>
</head>
<body>
<p>
<%
	shoppingCart cart = (shoppingCart) session.getAttribute("shoppingCart");
	
	if (cart == null)
	{
		cart = new shoppingCart();
		session.setAttribute("shoppingCart", cart);
	}
	
	Vector items = cart.getItems();
	
	if (items.size() == 0)
	{
		out.println("<h3>Your shopping cart is empty.</h3>");
		
	}
	else
	{
%>
<%--Display the header for the shopping cart table --%>	
<br>
<table border = 4>
<tr><th>Descriptions</th><th>Price</th></tr>
<%

		int numItems = items.size();
	
	
		for (int i = 0; i < numItems; i++)
		{
			Item item = (Item) items.elementAt(i);
		
			out.print("<tr><td>");
			out.print(item.movieName);
			out.print("</td><td>");
			out.print(item.orderQuantity);

			
			out.println(
					"<a href=RemoveItemServlet?item=" + i + ">Remove</a></td></tr>");
		}
	}
%>
<p>

<form action = "CheckoutServlet" method="post">

<table>
<tr><td>Name: </td>
	<td><input type="text" name="nameOnCard"></td></tr>
<tr><td>Credit Card Number: </td>
	<td><input type="text" name="creditID"></td></tr>
<tr><td>Credit Card Expiration: </td>
	<td><input type="text" name="expiration"></td></tr>

<tr><td>Email Address: </td>
	<td><input type="text" name="emailAddress"></td></tr>

<tr><td>Password: </td>
	<td><input type="password" name="password"></td></tr>
</table>

<p>
<input type="submit" value="Complete Order">
<a href="mainpage.html">Back To Main Page</a>
</form>
</body>
</html>