<%@page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Ajout d'un ticket</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/ajout.css" >
    
</head>
<body>

<div id="container" style="display:none;">

    <form  method="POST">
        <h1>Ajouter un ticket</h1>

        <label><b>Nom de ticket :</b></label>
        <input type="text" placeholder="Entrez un nom de ticket" id="ticket_name" required>
		<br>
        <label><b>Description du ticket :</b></label>
        <input type="text" placeholder="Entrez la description du ticket" id="ticket_description" required>
        <br>
        <label><b>Type de demande :</b></label>
		<select id="type"> 
				   <c:forEach var="types" items="${types}"> 
				   <option id="${ types.getType_id()}">${types.getType_libelle()}</option> 
				   </c:forEach> 
		</select>
		<br>
        <label><b>Priorité du ticket :</b></label>
		<select id="priorite"> 
				   <c:forEach var="priorites" items="${priorites}"> 
				   <option id="${ priorites.getPriorite_id()}">${priorites.getPriorite_libelle()}</option> 
				   </c:forEach> 
		</select>
       	<input type="button" id='valider' value='Valider' onclick="javascript:ajout();">
       
            </form>
        </div>
        <script>
      function ajout(){
    			    
            $.ajax({
                  method: "POST",
                  url: "${pageContext.request.contextPath}/lobby",
                  data: {'action':'ajout','ticket_name':$("#ticket_name").val(), 'ticket_description':$("#ticket_description").val(), 'types':$("#type option:selected").attr('id'), 'priorites':$("#priorite option:selected").attr('id')},
                  
                  success : function(data){
                	  if(data.Erreurs == undefined){
                		  document.querySelector("#container").style.display = "none";
                		  setTimeout(function(){
                              window.location.reload();
                          },100);
 					 }else{
 						 console.log(res["message"]); 
 					
 					 }
                  }
            });
            
        }
      </script>
</body>
</html>