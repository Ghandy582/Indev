<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.css" >
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>

<title>Gestion des tickets</title>
</head>
<body>
<h1>Gestion des tickets</h1>
<div class="panel-body" style="display: block;padding: 5px;min-height: 260px;">
<div class="row">
  <div class="col-sm">
	   		<h4 class="text-center">Nouveaux tickets : ${ nbNouveaux }</h4>			     
	   </div>
	    <div class="col-sm">
	   		<h4 class="text-center">Tickets en cours : ${ nbEnCours }</h4>		      
	   </div>
	</div>
	 <br />
	<table id="tickets" class="display">
	    <thead>
	        <tr>
	            <th>Nom</th>
	            <th>Etat</th>
	            <th>Type</th>
	            <th>Priorit�</th>
	            <th>Date ouverture</th>
	            <th>Technicien</th>
	            <th>Date cloture</th>
	        </tr>
	    </thead>
	    <tbody>
	        <tr>
	            <td>Ticket 1</td>
	            <td>En cours</td>
	            <td>Panne mat�riel</td>
	            <td>normal</td>
	            <td>08/07/2020</td>
	            <td>Loulou le pou</td>
	            <td> ---</td>
	        </tr>
	    </tbody>
	</table>
	<br />
	<button type="button">
	    Cr�er un nouveau ticket
	</button>
</div>
<script>
$(document).ready( function () {
    $('#tickets').DataTable();
} );
</script> 
</body>
</html>