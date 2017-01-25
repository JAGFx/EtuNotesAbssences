<%@ page import="projet.Controller.StudentController" %><%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
	<head >
		<title >Title</title >
		<jsp:include page="../Default/headpage.jsp" />
	</head >
	<body >
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="etu" class="projet.Entity.Student" scope="request" />
		<jsp:useBean id="nbAbsences" type="java.lang.Integer" scope="request" />
		
		<%-- TODO --%>
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
		
		<a href="list.jsp" >Retour</a >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
