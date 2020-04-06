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
<form action="registrazione" method="post" enctype="multipart/form-data">
	<input type="text" name="username" placeholder="Inserisci la mail">
	<input type="password" name="password" placeholder="Inserisci la password">
	<input type="file" name="image" placeholder="Inserisci l'immagine del profilo">
	<input type="submit" name="action" value="Registra" />
</form>


</body>
</html>