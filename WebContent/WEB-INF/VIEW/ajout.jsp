<%@page language="java" contentType="text/html;" pageEncoding="UTF-8"%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/login.css" >
    <title>Ajout d'un ticket</title>
</head>
<body>

<div id="container">

    <form  method="POST">
        <h1>Ajouter un ticket</h1>

        <label><b>Nom de ticket</b></label>
        <input type="text" placeholder="Entrez un nom de ticket" name="ticket_nom" required>

        <label><b>Description du ticket</b></label>
        <input type="text" placeholder="Entrez la description du ticket" name="ticket_description" required>

        <label><b>Date d'ouverture</b></label>
        <input type="text" placeholder="Entrez la date d'ouverture du ticket" name="ticket_date_ouverture" required>

        <a href="login">Retour à la page d'accueil</a>
    </form>
</div>
</body>
</html>