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
		<%@ page import="projet.Model.Group" %>
		<%@ page import="projet.Controller.GroupController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<jsp:useBean id="listGroup" type="java.util.Collection<projet.Model.Group>" scope="request" />
		
		<h2 >Liste des group</h2 >
		
		<ul >
			<% for ( Group group : listGroup ) { %>
			<li ><%= group.getName() %>
				<a href="<%= GroupController.getBasePath( true ) %>/details?grp=<%= group.getId() %>" >Détail</a >
			</li >
			<% } %>
		</ul >
	</body >
</html >
