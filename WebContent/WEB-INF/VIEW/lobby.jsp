<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>

<title>Gestion des tickets</title>
</head>
<body>
<table id="table_id" class="display">
    <thead>
        <tr>
            <th>Nom</th>
            <th>Etat</th>
            <th>Type</th>
            <th>Priorité</th>
            <th>Date ouverture</th>
            <th>Technicien</th>
            <th>Date cloture</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Ticket 1</td>
            <td>En cours</td>
            <td>Panne matériel</td>
            <td>normal</td>
            <td>08/07/2020</td>
            <td>Loulou le pou</td>
            <td> ---</td>
        </tr>
    </tbody>
</table>
<script>
$(document).ready( function () {
    $('#table_id').DataTable();
} );
</script> 
</body>
</html>