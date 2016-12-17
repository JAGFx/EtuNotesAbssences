<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 16-Dec-16
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
	<head >
		<title >Title</title >
	</head >
	<body >
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etu" type="projet.Model.Etudiant" scope="request" />
		
		<h2 >Etudiant : <%= etu.getNom() + ' ' + etu.getPrenom() %>
		</h2 >
		
		<h4 >Notes: </h4 >
		<ul >
			<% for ( Float note : etu.getNoteEtudiant() ) { %>
			<li ><%= note %>
			</li >
			<% } %>
		</ul >
	</body >
</html >