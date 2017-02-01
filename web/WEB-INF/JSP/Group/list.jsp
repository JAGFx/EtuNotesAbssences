<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr" >
	<head >
		<title >Title</title >
		<meta charset="utf-8" >
		<jsp:include page="../Default/head.jsp" />
	</head >
	<body class="container" >
		<%@ page import="projet.Entity.Group" %>
		<%@ page import="projet.Controller.GroupController" %>
		<%@ page import="projet.Entity.Student" %>
		<%@ page import="projet.Controller.StudentController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="listGroup" type="java.util.Collection<projet.Entity.Group>" scope="request" />
		
		<section class="col-xs-12" >
			<h2 >Liste des groupes</h2 >
			<a href="<%= GroupController.getBasePath( true ) %>/new" >Ajouter un groupe</a >
			
			<table class="table-responsive table table-striped" >
				<tr >
					<th >ID</th >
					<th >Nom</th >
					<th >Prénom</th >
					<th >Actions</th >
				</tr >
				<% for ( Group group : listGroup ) { %>
				<tr class="active" >
					<td colspan="3" ><%= group.getName() %> ( <%= group.getStudents().size() %> )</td >
					<td >
						<a class="btn btn-xs btn-default" href="<%= GroupController.getBasePath( true ) %>/details?grp=<%= group.getId() %>" >Détail</a >
						<a class="btn btn-xs btn-primary" href="<%= GroupController.getBasePath( true ) %>/edit?grp=<%= group.getId() %>" >Modifier</a >
						<a class="btn btn-xs btn-danger" href="<%= GroupController.getBasePath( true ) %>/delete?grp=<%= group.getId() %>" >Supprimer</a >
					</td >
				</tr >
				
				<% for ( Student student : group.getStudents() ) { %>
				<tr >
					<td ><%= student.getId() %>
					</td >
					<td ><%= student.getLastname() %>
					</td >
					<td ><%= student.getFirstname() %>
					</td >
					<td >
						<a href="<%= StudentController.getBasePath( true ) %>/details?etu=<%= student.getId() %>" class="btn btn-xs btn-default" >Détail</a >
						<button class="btn btn-xs btn-default modal-open new-note" data-etuid="<%=student.getId()%>" >Notes</button >
						<a href="<%= StudentController.getBasePath( true ) %>/edit?etu=<%= student.getId() %>" class="btn btn-xs btn-primary" >Modifier</a >
						<a href="<%= StudentController.getBasePath( true ) %>/delete?etu=<%= student.getId() %>" class="btn btn-xs btn-danger" >Supprimer</a >
					</td >
				</tr >
				<% } %>
				<% } %>
			</table >
		</section >
		
		<jsp:include page="../Default/modals/new.note.modal.jsp" />
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
