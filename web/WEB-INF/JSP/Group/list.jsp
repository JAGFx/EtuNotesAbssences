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
		<%@ page import="projet.Entity.Note" %>
		<%@ page import="projet.Controller.NoteController" %>
		<%@ page import="projet.Entity.Absence" %>
		<%@ page import="projet.Controller.AbsenceController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="listGroup" type="java.util.Collection<projet.Entity.Group>" scope="request" />
		
		<section class="col-xs-12" >
			<h2 >Liste des groupes</h2 >
			<a href="<%= GroupController.getBasePath( true ) %>/new" >Ajouter un groupe</a ><br />
			<label class="checkbox" >
				<input type="checkbox" checked data-toggle="toggle" id="showNotes" data-size="mini" >
				Afficher les notes
			</label >
			<label class="checkbox" >
				<input type="checkbox" data-toggle="toggle" id="showAbsences" data-size="mini" >
				Afficher les absences
			</label >
			
			<table class="table-responsive table table-striped" >
				<tr >
					<th style="width: 100px;" >ID</th >
					<th style="width: 25%;" >Nom</th >
					<th style="width: 25%;" >Prénom</th >
					<th >Actions</th >
				</tr >
				<% for ( Group group : listGroup ) { %>
				<tr class="info" >
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
						<button class="btn btn-xs btn-default modal-open new-note" data-etuid="<%=student.getId()%>" >
							<span class="glyphicon glyphicon-plus" ></span > Notes
						</button >
						<button class="btn btn-xs btn-default modal-open new-abs" data-etuid="<%=student.getId()%>" >
							<span class="glyphicon glyphicon-plus" ></span > Absences
						</button >
						<a href="<%= StudentController.getBasePath( true ) %>/edit?etu=<%= student.getId() %>" class="btn btn-xs btn-primary" >Modifier</a >
						<a href="<%= StudentController.getBasePath( true ) %>/delete?etu=<%= student.getId() %>" class="btn btn-xs btn-danger" >Supprimer</a >
					</td >
				</tr >
				<% if ( !student.getNotes().isEmpty() ) { %>
				<tr class="groupNote" >
					<td ></td >
					<td colspan="3" class="success" >Notes</td >
				</tr >
				<% } %>
				<% for ( Note note : student.getNotes() ) { %>
				<tr class="groupNote" >
					<td ></td >
					<td ><%= note %>
					</td >
					<td ><%= note.getName() %>
					</td >
					<td >
						<a href="<%= NoteController.getBasePath( true ) %>/edit?note=<%= note.getId_note() %>" class="btn btn-primary btn-xs" >Modifier</a >
						<a href="<%= NoteController.getBasePath( true ) %>/delete?note=<%= note.getId_note() %>" class="btn btn-danger btn-xs" >Supprimer</a >
					</td >
				</tr >
				<% } %>
				
				<% if ( !student.getAbsences().isEmpty() ) { %>
				<tr class="groupAbs" >
					<td ></td >
					<td colspan="3" class="warning" >Absences</td >
				</tr >
				<% } %>
				<% for ( Absence absence : student.getAbsences() ) { %>
				<tr class="groupAbs" >
					<td ></td >
					<td colspan="2" ><%= absence %>
					<td >
						<a href="<%= AbsenceController.getBasePath( true ) %>/edit?abs=<%= absence.getId_absence() %>" class="btn btn-primary btn-xs" >Modifier</a >
						<a href="<%= AbsenceController.getBasePath( true ) %>/delete?abs=<%= absence.getId_absence() %>" class="btn btn-danger btn-xs" >Supprimer</a >
					</td >
				</tr >
				<% } %>
				<% } %>
				<% } %>
			</table >
		</section >
		
		<jsp:include page="../Default/modals/new.note.modal.jsp" />
		<jsp:include page="../Default/modals/new.absence.modal.jsp" />
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
