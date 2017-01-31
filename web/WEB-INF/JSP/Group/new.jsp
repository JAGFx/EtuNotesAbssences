<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 23-Jan-17
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr" >
	<head >
		<title >Title</title >
		<jsp:include page="../Default/head.jsp" />
	</head >
	<body class="container" >
		<jsp:include page="../Default/header.jsp" />
		
		<form method="post" class="col-xs-12" >
			<div class="form-group" >
				<label for="name" >Nom</label >
				<input type="text" id="name" name="name" class="form-control" >
			</div >
			
			<button type="submit" class="btn btn-primary" >Valider</button >
			<button type="reset" class="btn btn-default" >Annuler</button >
		</form >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >