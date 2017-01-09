<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 16-Dec-16
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="projet.Entity.Note" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
	<head >
		<title >Title</title >
	</head >
	<body >
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etu" type="projet.Entity.Student" scope="request" />
		
		<h2 >Etudiant : <%= etu %>
		</h2 >
		
		<h4 >Notes: </h4 >
		<ul >
			<% for ( Note note : etu.getNotes() ) { %>
			<li ><%= note %> / <%= Note.GRADING_SCALE %>
			</li >
			<% } %>
		</ul >
	</body >
</html >