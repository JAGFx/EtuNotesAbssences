<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 16-Dec-16
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="projet.Entity.Note" %>
<%@ page import="projet.Controller.NoteController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr" >
	<head >
		<title >Title</title >
		<jsp:include page="../Default/head.jsp" />
	</head >
	<body class="container" >
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etu" type="projet.Entity.Student" scope="request" />
		
		<section class="col-xs-12" >
			<h2 >Etudiant : <%= etu %> <span class="label label-primary" ><%= etu.getAverage() %></span >
			</h2 >
			
			<a href="<%= NoteController.getBasePath( true ) %>/new?etu=<%= etu.getId() %>" >Ajouter</a >
			
			<h4 >Notes: </h4 >
			<table class="table-responsive table table-striped" >
				<tr >
					<th >Note</th >
					<th >Désignation</th >
					<th >Actions</th >
				</tr >
				<% for ( Note note : etu.getNotes() ) { %>
				<tr >
					<td ><%= note %>
					</td >
					<td ><%=note.getName()%>
					</td >
					<td >
						<a href="<%= NoteController.getBasePath( true ) %>/edit?note=<%= note.getId_note() %>" class="btn btn-primary btn-xs" >Modifier</a >
						<a href="<%= NoteController.getBasePath( true ) %>/delete?note=<%= note.getId_note() %>" class="btn btn-danger btn-xs" >Supprimer</a >
					</td >
				</tr >
				<% } %>
			
			</table >
		</section >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >