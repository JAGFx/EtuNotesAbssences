<%@ page import="projet.Model.Etudiant" %>
<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
	<head >
		<title >Title</title >
	</head >
	<body >
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="groupe" class="projet.Model.Groupe" scope="request" />
		
		<ul >
			<li >ID: <%= groupe.getId() %>
			</li >
			<li >Name: <%= groupe.getName() %>
			</li >
		</ul >
		
		<h4 >Etudiants: </h4 >
		<ul >
			<% for ( Etudiant etu : groupe.getEtudiants() ) { %>
			<li ><%= etu.getNom() + ' ' + etu.getPrenom() %>
			</li >
			<% } %>
		</ul >
		
		<a href="list.jsp" >Retour</a >
	</body >
</html >
