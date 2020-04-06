<%@page import="it.dstech.gestione_libreria.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page - Gestione Libreria</title>
</head>
<body>
<h1>Effettua la registraizone</h1>
<% Utente utente = (Utente)request.getAttribute("utente"); %>

<h1><%= utente.getUsername() %></h1><br>
<img alt="immagine" src="data:image/jpg;base64,<%= utente.getImage() %>"> <br>
<%-- <%= utente.getUsername() %> --%>

</body>
</html>