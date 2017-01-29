<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 16-Dec-16
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="projet.Entity.Note" %>
<%@ page import="projet.Controller.NoteController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
	<head >
		<title >Title</title >
		<jsp:include page="../Default/headpage.jsp" />
	</head >
	<body >
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etu" type="projet.Entity.Student" scope="request" />
		
		<h2 >Etudiant : <%= etu %>
		</h2 >
		
		<a href="<%= NoteController.getBasePath( true ) %>/new?etu=<%= etu.getId() %>" >Ajouter</a >
		
		<h4 >Notes: </h4 >
		<ul >
			<% for ( Note note : etu.getNotes() ) { %>
			<li ><%= note %>
				<a href="<%= NoteController.getBasePath( true ) %>/edit?note=<%= note.getId_note() %>" class="btn btn-primary btn-xs" >Modifier</a >
				<a href="<%= NoteController.getBasePath( true ) %>/delete?note=<%= note.getId_note() %>" class="btn btn-danger btn-xs" >Supprimer</a >
			</li >
			<% } %>
			
		</ul >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >