<%@ page import="projet.Model.Student" %>
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
		<jsp:useBean id="group" class="projet.Model.Group" scope="request" />
		
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
	</body >
</html >
