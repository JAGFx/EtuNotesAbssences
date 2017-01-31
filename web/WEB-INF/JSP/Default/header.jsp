<%--
  Created by IntelliJ IDEA.
  User: SMITHE
  Date: 01-Dec-16
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="projet.Controller.StudentController" %>
<%@ page import="projet.Controller.GroupController" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<header class="col-xs-12" >
	<nav class="navbar navbar-fixed-top navbar-inverse" >
		<div class="container" >
			
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
				<ul class="nav navbar-nav" >
					<li class="dropdown" >
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" >Etudians
							<span class="caret" ></span ></a >
						<ul class="dropdown-menu" >
							<li >
								<a href="<%= StudentController.getBasePath( true ) %>" >Liste</a >
							</li >
							<li >
								<a href="<%= StudentController.getBasePath( true ) %>/new" >Création</a >
							</li >
						</ul >
					</li >
					
					<li class="dropdown" >
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" >Groupe
							<span class="caret" ></span ></a >
						<ul class="dropdown-menu" >
							<li >
								<a href="<%= GroupController.getBasePath( true ) %>" >Liste</a >
							</li >
						</ul >
					</li >
				</ul >
			</div ><!-- /.navbar-collapse -->
		</div ><!-- /.container-fluid -->
	</nav >
</header >