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
				<label for="fromDate" >Date de début</label >
				<div class='input-group datetimepicker' >
					<input type="text" id="fromDate" name="fromDate" class="form-control" >
					<span class="input-group-addon" >
						<span class="glyphicon glyphicon-calendar" ></span >
					</span >
				</div >
			</div >
			
			<div class="form-group" >
				<label for="toDate" >Date de fin</label >
				<div class='input-group datetimepicker' >
					<input type="text" id="toDate" name="toDate" class="form-control" >
					<span class="input-group-addon" >
						<span class="glyphicon glyphicon-calendar" ></span >
					</span >
				</div >
			</div >
			
			<button type="submit" class="btn btn-primary" >Valider</button >
			<button type="reset" class="btn btn-default" >Annuler</button >
		</form >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >