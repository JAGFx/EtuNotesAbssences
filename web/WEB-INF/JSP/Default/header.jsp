<%@ page import="projet.Controller.StudentController" %>
<%@ page import="projet.Controller.GroupController" %><%--
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
				<a href="<%= StudentController.getBasePath( true ) %>" >Etudiant</a >
			</li >
			<li >
				<a href="<%= GroupController.getBasePath( true ) %>" >Groupe</a >
			</li >
		</ul >
	</nav >
</header >