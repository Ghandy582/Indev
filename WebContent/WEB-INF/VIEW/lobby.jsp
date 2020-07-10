<%@page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/bootstrap.css" >
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
	            <th>Priorité</th>
	            <th>Date ouverture</th>
	            <th>Technicien</th>
	            <th>Date cloture</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${ tickets }" var="tickets" varStatus="boucle">
	           <tr id="${ tickets.getTicket_id()}" >
	            	<td>${ tickets.getTicket_nom() }</td>
	            	<td >${ tickets.getVar_string_etat() }</td>
	            	<td >${ tickets.getVar_string_type() }</td>
	            	<td >${ tickets.getVar_string_priorite() }</td>
	 				<td >${ tickets.getTicket_date_ouverture() }</td>
	            	<td >${ tickets.getVar_string_userModifier() }</td>
	            	<td >${ tickets.getTicket_date_cloture() }</td>
	            	<td>
		            	<i style="padding: 3px; cursor: pointer;" class=" material-icons" onclick="">remove_red_eye</i>
		            	<c:forEach  var="right" items="${USER.getVar_list_right()}">
		            		<c:if test="${right.getDroit_libelle().equals('modification')}">
		            			<i style="padding: 3px; cursor: pointer;" class="material-icons" onClick="">edit</i>
		            		</c:if>
		            		<c:if test="${right.getDroit_libelle().equals('suppression')}">
		            			<i style="padding: 3px; cursor: pointer;" class=" material-icons" onclick="">delete_forever</i>
		            		</c:if>
		            	</c:forEach>
	           		</td>
           		</tr>
      		</c:forEach>
	    </tbody>
	</table>
	<br />
	<button id=ajouter>
	    Créer un nouveau ticket
	</button>
	<button id=fermer>
	    Fermer
	</button>
</div>
<script>
$(document).ready( function () {
    $('#tickets').DataTable();
} );

document.querySelector("#ajouter").addEventListener("click", function()
	    {
	    document.querySelector("#container").style.display = "block";
	    });
	    document.querySelector("#fermer").addEventListener("click", function()
	    {
	    document.querySelector("#container").style.display = "none";
	    });
</script> 
<c:forEach  var="sub_view" items="${sub_views}">
	<jsp:include page="${sub_view}"/> 
</c:forEach>
</body>
</html>