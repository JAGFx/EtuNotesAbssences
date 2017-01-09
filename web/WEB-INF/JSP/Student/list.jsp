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
		<%@ page import="projet.Entity.Student" %>
		<%@ page import="projet.Controller.StudentController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etusList" type="java.util.Collection<projet.Entity.Student>" scope="request" />
		
		<h2 >Liste des students</h2 >
		<%-- TODO --%>
		<a href="" >Ajouter un Etudiant</a >
		
		<ul >
			<% for ( Student etu : etusList ) { %>
			<li >
				<%= etu.getLastname() %>
				<a href="<%= StudentController.getBasePath( true ) %>/details?etu=<%= etu.getId() %>" >Détail</a >
				<a href="<%= StudentController.getBasePath( true ) %>/notes?etu=<%= etu.getId() %>" >Notes</a >
			</li >
			<% } %>
		</ul >
	</body >
</html >
