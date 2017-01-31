<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="projet.Entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
	<head >
		<title >Title</title >
		<jsp:include page="../Default/head.jsp" />
	</head >
	<body class="container" >
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="group" class="projet.Entity.Group" scope="request" />
		
		<section class="col-xs-12" >
			<%-- TODO --%>
			<a href="" >Modifier</a >
			<a href="" >Supprimer</a >
			
			<ul >
				<li >ID: <%= group.getId() %>
				</li >
				<li >Name: <%= group.getName() %>
				</li >
			</ul >
			
			<h4 >Etudiants: </h4 >
			<ul >
				<% for ( Student etu : group.getStudents() ) { %>
				<li ><%= etu.getLastname() + ' ' + etu.getFirstname() %>
				</li >
				<% } %>
			</ul >
			
			<a href="list.jsp" >Retour</a >
		</section >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
