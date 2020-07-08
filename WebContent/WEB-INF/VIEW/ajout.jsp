<%@page language="java" contentType="text/html;" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Ajout d'un ticket</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/ajout.css" >
</head>
<body>

<div id="container">

    <form  method="POST">
        <h1>Ajouter un ticket</h1>

        <label><b>Nom de ticket</b></label>
        <input type="text" placeholder="Entrez un nom de ticket" name="ticket_nom" required>
		<br>
        <label><b>Description du ticket</b></label>
        <input type="text" placeholder="Entrez la description du ticket" name="ticket_description" required>
		<br>
        <label><b>Date d'ouverture</b></label>
        <input type="date" placeholder="Entrez la date d'ouverture du ticket" name="ticket_date_ouverture" required>

    </form>
</div>
</body>
</html>