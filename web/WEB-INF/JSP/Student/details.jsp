<%@ page import="projet.Controller.StudentController" %><%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:58
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
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etu" class="projet.Entity.Student" scope="request" />
		<jsp:useBean id="nbAbsences" type="java.lang.Integer" scope="request" />
		
		<section class="col-xs-12" >
			<a href="<%= StudentController.getBasePath( true ) %>/edit?etu=<%= etu.getId() %>" >Modifier</a >
			<a href="<%= StudentController.getBasePath( true ) %>/delete?etu=<%= etu.getId() %>" >Supprimer</a >
			
			<ul >
				<li >ID: <%= etu.getId() %>
				</li >
				<li >Name: <%= etu.getLastname() %>
				</li >
				<li >FirstName: <%= etu.getFirstname() %>
				</li >
				<li > Absences:  <%= nbAbsences %>
				</li >
			</ul >
		</section >
		
		<a href="list.jsp" >Retour</a >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
