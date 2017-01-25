<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 24-Jan-17
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr" >
	<head >
		<title >Title</title >
		<jsp:include page="../Default/headpage.jsp" />
	</head >
	<body class="container" >
		<%@ page import="projet.Entity.Student" %>
		<jsp:useBean id="students" type="java.util.Collection<projet.Entity.Student>" scope="request" />
		
		<jsp:include page="../Default/header.jsp" />
		<form method="post" >
			<div class="form-group" >
				<label for="coef" >Coeficient</label >
				<input type="number" id="coef" name="coef" class="form-control" >
			</div >
			
			<div class="form-group" >
				<label for="value" >Valeur</label >
				<input type="text" id="value" name="value" class="form-control" >
			</div >
			
			<div class="form-group" >
				<label for="gradingScale" >Barème</label >
				<input type="number" id="gradingScale" name="gradingScale" class="form-control" >
			</div >
			
			<div class="form-group" >
				<label for="student" >Elève</label >
				<select name="student" id="student" class="form-control" >
					<% for ( Student student : students ) { %>
					<option value="<%= student.getId() %>" ><%= student %>
					</option >
					<% } %>
				</select >
			</div >
			
			<button type="submit" class="btn btn-primary" >Valider</button >
			<button type="reset" class="btn btn-default" >Annuler</button >
		</form >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >