<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 13:55
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
		<%@ page import="projet.Entity.Group" %>
		<%@ page import="projet.Controller.GroupController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="listGroup" type="java.util.Collection<projet.Entity.Group>" scope="request" />
		
		<h2 >Liste des group</h2 >
		<%-- TODO --%>
		<a href="" >Ajouter un groupe</a >
		
		<ul >
			<% for ( Group group : listGroup ) { %>
			<li ><%= group.getName() %>
				<a href="<%= GroupController.getBasePath( true ) %>/details?grp=<%= group.getId() %>" >Détail</a >
			</li >
			<% } %>
		</ul >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >
