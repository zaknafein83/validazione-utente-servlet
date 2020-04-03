<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page - Gestione Libreria</title>
</head>
<body>

<% String messaggio = (String) request.getAttribute("message"); 
if (messaggio != null) {%>
	<h1><%=messaggio  %></h1>
<% } %>
<form action="scelta" method="post">
	<input type="submit" name="action" value="Accedi"/>
	<input type="submit" name="action" value="Registra" />
</form>


</body>
</html>