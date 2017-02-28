<%--
  Created by IntelliJ IDEA.
  User: emsm
  Date: 29/01/2017
  Time: 15:26
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
		<%@ page import="projet.Entity.Student" %>
		<jsp:useBean id="students" type="java.util.Collection<projet.Entity.Student>" scope="request" />
		<jsp:useBean id="note" type="projet.Entity.Note" scope="request" />
		
		<jsp:include page="../Default/header.jsp" />
		<form method="post" >
			<div class="form-group" >
				<label for="name" >Nom</label >
				<input type="text" id="name" name="name" class="form-control" value="<%= note.getName() %>" required >
			</div >
			
			<div class="form-group" >
				<label for="coef" >Coeficient</label >
				<input type="number" id="coef" name="coef" class="form-control" value="<%= note.getCoef() %>" required min="1" step="1" >
			</div >
			
			<div class="form-group" >
				<label for="value" >Valeur</label >
				<input type="text" id="value" name="value" class="form-control" value="<%= note.getValue() %>" required min="0" step="0.1" >
			</div >
			
			<div class="form-group" >
				<label for="gradingScale" >Barème</label >
				<input type="number" id="gradingScale" name="gradingScale" class="form-control" value="<%= note.getGraddingScale() %>" required min="1" step="1" >
			</div >
			
			<%--<div class="form-group" >
				<label for="student" >Elève</label >
				<select name="student" id="student" class="form-control" >
					<% for ( Student student : students ) { %>
					<option value="<%= student.getId() %>" ><%= student %>
					</option >
					<% } %>
				</select >
			</div >--%>
			
			<button type="submit" class="btn btn-primary" >Modifier</button >
			<button type="reset" class="btn btn-default" >Annuler</button >
		</form >
		
		<jsp:include page="../Default/foot.jsp" />
	</body >
</html >