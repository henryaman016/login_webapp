<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registration</title>
</head>
<body>
<h2>Registration</h2>

<table>
<tr>
<th>Name:</th>
<th>Email:</th>
<th>Phone:</th>
<th>City:</th>
<th>Action</th>
</tr>


<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next()){
%>

<tr>
<td><%=result.getString(1) %></td>
<th><%=result.getString(2) %></th>
<th><%=result.getString(3) %></th>
<th><%=result.getString(4) %></th>
<th>
<a href="delete?email=<%=result.getString(2)%>">delete</a>
<a href="update?email=<%=result.getString(2)%>&phone=<%=result.getString(3)%>">update</a>
</th>
</tr>



<%
}


%>

</table>
</body>
</html>