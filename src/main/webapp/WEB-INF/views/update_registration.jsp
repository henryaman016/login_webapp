<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Registration</title>
</head>
<body>
<h2>Update Here..</h2>
<form action="update" method="post" >
<pre>
Email:<input type="text" name="email" value="<%=request.getAttribute("email")%>" />
Mobile:<input type="text" name="phone" value="<%=request.getAttribute("phone")%>" />
<input type="submit" value="update" />
</pre>
</form>
</body>
</html>