<%@ page import="projet.Controller.EtudiantController" %>
<%@ page import="projet.Controller.GroupeController" %><%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header >
	<h1 >Application Notes/Absences</h1 >
	
	<nav >
		<ul >
			<li >
				<a href="<%= EtudiantController.getBasePath( true ) %>" >Etudiant</a >
			</li >
			<li >
				<a href="<%= GroupeController.getBasePath( true ) %>" >Groupe</a >
			</li >
		</ul >
	</nav >
</header >