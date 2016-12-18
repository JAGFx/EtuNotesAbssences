<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
	<head >
		<title >Title</title >
	</head >
	<body >
		<%@ page import="projet.Model.Etudiant" %>
		<%@ page import="projet.Controller.EtudiantController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etusList" type="java.util.Collection<projet.Model.Etudiant>" scope="request" />
		
		<h2 >Liste des etudiants</h2 >
		
		<ul >
			<% for ( Etudiant etu : etusList ) { %>
			<li >
				<%= etu.getNom() %>
				<a href="<%= EtudiantController.getBasePath( true ) %>/details?etu=<%= etu.getId() %>" >Détail</a >
				<a href="<%= EtudiantController.getBasePath( true ) %>/notes?etu=<%= etu.getId() %>" >Notes</a >
			</li >
			<% } %>
		</ul >
	</body >
</html >
