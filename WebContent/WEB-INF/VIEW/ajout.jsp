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

        <label><b>Nom de ticket</b></label>
        <input type="text" placeholder="Entrez un nom de ticket" id="ticket_name" required>
		<br>
        <label><b>Description du ticket</b></label>
        <input type="text" placeholder="Entrez la description du ticket" id="ticket_description" required>
        <br>
        <label><b>Type de demande</b></label>
		<select id="type"> 
				   <c:forEach var="item" items="${url}"> 
				   <option>${item}</option> 
				   </c:forEach> 
		</select>
		<br>
        <label><b>Priorité du ticket</b></label>
		<select id="priorite"> 
				   <c:forEach var="item" items="${url}"> 
				   <option>${item}</option> 
				   </c:forEach> 
		</select>
       	<input type="button" id='button' value='VALIDER' onclick="javascript:ajouter();">
        
            </form>
        </div>
        <script>
      function ajout(){
            $.ajax({
                  method: "POST",
                  url: "${pageContext.request.contextPath}/login",
                  data: {'action':'ajout','ticket_nom':$("#ticket_nom").val(), ticket_description:$("#ticket_description").val(), type:$("#type").val(), priorite:$("#priorite").val()},
                  
            });
        }
      </script>
</body>
</html>