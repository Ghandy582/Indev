<%@page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/login.css" >
<title>Connexion</title>
</head>
<body>
<div id="container">
            <!-- zone de connexion -->
            
            <form method="POST">
                <h1>Connexion</h1>
                
                <label><b>Nom d'utilisateur</b></label>
                <input type="text" placeholder="Entrer le nom d'utilisateur" id="login" required>

                <label><b>Mot de passe</b></label>
                <input type="password" placeholder="Entrer le mot de passe" id="password" required>

				<select id="choixbdd"> 
				    <c:forEach var="item" items="${url}"> 
				    <option>${item}</option> 
				    </c:forEach> 
				</select>
                <input type="button" id='button' value='VALIDER' onclick="javascript:connexion();">
        
            </form>
        </div>
        <script>
      function connexion(){
            $.ajax({
                  method: "POST",
                  url: "${pageContext.request.contextPath}/login",
                  data: {'action':'login','login':$("#login").val(), password:$("#password").val(), choixbdd:$("#choixbdd").val()},
                  //Succès de la requete ajax et reponse correcte
                  success : function(res){
                	  if(res["code"]==1){
 						 window.location.href  = "${pageContext.request.contextPath}/lobby";						
 					 }else{
 						 console.log(res["message"]); 
 					 }
                  }
            });
        }
      </script>
</html>