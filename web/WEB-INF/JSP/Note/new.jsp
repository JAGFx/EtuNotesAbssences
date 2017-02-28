<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 24-Jan-17
  Time: 10:36
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
		<form method="post" >
			<div class="form-group" >
				<label for="name" >Nom</label >
				<input type="text" id="name" name="name" class="form-control" required >
			</div >
			
			<div class="form-group" >
				<label for="coef" >Coeficient</label >
				<input type="number" id="coef" name="coef" class="form-control" required min="1" step="1" >
			</div >
			
			<div class="form-group" >
				<label for="value" >Valeur</label >
				<input type="text" id="value" name="value" class="form-control" required min="0" step="0.1" >
			</div >
			
			<div class="form-group" >
				<label for="gradingScale" >Barème</label >
				<input type="number" id="gradingScale" name="gradingScale" class="form-control" required min="1" step="1" >
			</div >
			
			<button type="submit" class="btn btn-primary" >Valider</button >
			<button type="reset" class="btn btn-default" >Annuler</button >
		</form >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >