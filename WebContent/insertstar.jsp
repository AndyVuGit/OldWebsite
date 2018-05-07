<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1>Insert a Star</H1>
<form action = InsertStarServlet method = "post">
<input type="text" placeholder="Star Id" name = "id"/>
<input type="text" placeholder="Star Name" name = "name"/>
<input type="text" placeholder="date of birth" name = "dob"/>
<input type="text" placeholder="photo url" name = "photo"/>
<button type="submit">submit</button>
</form>
</body>
</html>