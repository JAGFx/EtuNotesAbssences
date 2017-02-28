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
		<jsp:include page="../Default/head.jsp" />
	</head >
	<body class="container" >
		<%@ page import="projet.Entity.Absence" %>
		<%@ page import="projet.Controller.AbsenceController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="absences" type="java.util.Collection<projet.Entity.Absence>" scope="request" />
		
		<section class="col-xs-12" >
			<h2 >Liste des absences</h2 >
			
			<table class="table-responsive table table-striped" >
				<tr >
					<th >ID</th >
					<th >Etudiant</th >
					<th >Date de début</th >
					<th >Date de fin</th >
					<th >Actions</th >
				</tr >
				<% for ( Absence absence : absences ) { %>
				<tr >
					<td ><%= absence.getId_absence() %>
					</td >
					<td ><%= absence.getStudent() %>
					</td >
					<td ><%= absence.getFromDate() %>
					</td >
					<td ><%= absence.getToDate() %>
					</td >
					<td >
						<a href="<%= AbsenceController.getBasePath( true ) %>/edit?abs=<%= absence.getId_absence() %>" class="btn btn-xs btn-primary" >Modifier</a >
						<a href="<%= AbsenceController.getBasePath( true ) %>/delete?abs=<%= absence.getId_absence() %>" class="btn btn-xs btn-danger" >Supprimer</a >
					</td >
				</tr >
				<% } %>
			</table >
		</section >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
