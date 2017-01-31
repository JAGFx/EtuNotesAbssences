<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
	<head >
		<title >Title</title >
		<jsp:include page="../Default/head.jsp" />
	</head >
	<body class="container" >
		<%@ page import="projet.Entity.Student" %>
		<%@ page import="projet.Controller.StudentController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etusList" type="java.util.Collection<projet.Entity.Student>" scope="request" />
		
		<section class="col-xs-12" >
			<h2 >Liste des students</h2 >
			<a href="<%= StudentController.getBasePath( true ) %>/new" >Ajouter un Etudiant</a >
			
			<table class="table-responsive table table-striped" >
				<tr >
					<th >ID</th >
					<th >Nom</th >
					<th >Prénom</th >
					<th >Actions</th >
				</tr >
				<% for ( Student student : etusList ) { %>
				<tr >
					<td ><%= student.getId() %>
					</td >
					<td ><%= student.getLastname() %>
					</td >
					<td ><%= student.getFirstname() %>
					</td >
					<td >
						<a href="<%= StudentController.getBasePath( true ) %>/details?etu=<%= student.getId() %>" class="btn btn-xs btn-default" >Détail</a >
						<a href="<%= StudentController.getBasePath( true ) %>/notes?etu=<%= student.getId() %>" class="btn btn-xs btn-default" >Notes</a >
						<a href="<%= StudentController.getBasePath( true ) %>/edit?etu=<%= student.getId() %>" class="btn btn-xs btn-primary" >Modifier</a >
						<a href="<%= StudentController.getBasePath( true ) %>/delete?etu=<%= student.getId() %>" class="btn btn-xs btn-danger" >Supprimer</a >
					</td >
				</tr >
				<% } %>
			</table >
		</section >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
