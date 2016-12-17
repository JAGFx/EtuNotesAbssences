<%@ page import="projet.*" %>
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
		<jsp:useBean id="etu" class="projet.Model.Etudiant" scope="request" />
		<jsp:useBean id="nbAbsences" type="java.lang.Integer" scope="request" />
		
		<ul >
			<li >ID: <%= etu.getId() %>
			</li >
			<li >Name: <%= etu.getNom() %>
			</li >
			<li >FirstName: <%= etu.getPrenom() %>
			</li >
			<li > Absences:  <%= nbAbsences %>
			</li >
		</ul >
		
		<a href="list.jsp" >Retour</a >
	</body >
</html >
