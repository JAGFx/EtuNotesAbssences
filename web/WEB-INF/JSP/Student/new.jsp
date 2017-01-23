<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 23-Jan-17
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
	<head >
		<title >Title</title >
		<link rel="stylesheet" type="text/css" href="/lib/bootstrap-3.3.7/css/bootstrap.min.css" >
		<link rel="stylesheet" type="text/css" href="/lib/bootstrap-3.3.7/css/bootstrap-theme.min.css" >
		<jsp:include page="../Default/headpage.jsp" />
	</head >
	<body class="container">
		<%@ page import="projet.Entity.Group" %>
		<%@ page import="projet.Controller.GroupController" %>
		
		<jsp:include page="../Default/header.jsp" />
		<form action="" method="post"  >
			<div class="form-group">
				<label for="name" >Nom</label >
				<input type="text" id="name" class="form-control" >
			</div>
			
			<button type="submit" class="btn btn-primary" >Valider</button >
			<button type="reset" class="btn btn-default" >Annuler</button >
		</form >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >