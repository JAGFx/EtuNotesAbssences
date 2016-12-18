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
		<%@ page import="projet.Model.Groupe" %>
		<%@ page import="projet.Controller.GroupeController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="listGroupe" type="java.util.Collection<projet.Model.Groupe>" scope="request" />
		
		<h2 >Liste des groupe</h2 >
		
		<ul >
			<% for ( Groupe groupe : listGroupe ) { %>
			<li ><%= groupe.getName() %>
				<a href="<%= GroupeController.getBasePath( true ) %>/details?grp=<%= groupe.getId() %>" >Détail</a >
			</li >
			<% } %>
		</ul >
	</body >
</html >
