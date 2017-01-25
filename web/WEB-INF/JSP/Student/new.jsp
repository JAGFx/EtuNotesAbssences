<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 23-Jan-17
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr" >
	<head >
		<title >Title</title >
		<jsp:include page="../Default/headpage.jsp" />
	</head >
	<body class="container" >
		<%@ page import="projet.Entity.Group" %>
		<%@ page import="projet.Controller.GroupController" %>
		<jsp:useBean id="groups" type="java.util.Collection<projet.Entity.Group>" scope="request" />
		
		<jsp:include page="../Default/header.jsp" />
		<form method="post" >
			<div class="form-group" >
				<label for="lastname" >Nom</label >
				<input type="text" id="lastname" name="lastname" class="form-control" >
			</div >
			
			<div class="form-group" >
				<label for="firstname" >Prénom</label >
				<input type="text" id="firstname" name="firstname" class="form-control" >
			</div >
			
			<div class="form-group" >
				<label for="group" >Groupe</label >
				<select name="group" id="group" class="form-control" >
					<% for ( Group group : groups ) { %>
					<option value="<%= group.getId() %>" ><%= group %>
					</option >
					<% } %>
				</select >
			</div >
			
			<button type="submit" class="btn btn-primary" >Valider</button >
			<button type="reset" class="btn btn-default" >Annuler</button >
		</form >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >