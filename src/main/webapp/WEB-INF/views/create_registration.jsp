<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h2>Registration Here...</h2>

<form action="newReg" method="post" >

<pre>
Name:<input type="text" name="name" />
Email:<input type="text" name="email" />
City:<input type="text" name="city" />
Phone:<input type="text" name="phone" />
<input type="submit" value="save" />

</pre>
</form>
<%
if(request.getAttribute("msg")!=null){
out.println(request.getAttribute("msg"));
}
%>

</body>
</html>