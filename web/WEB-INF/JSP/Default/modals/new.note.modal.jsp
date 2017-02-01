<%@ page import="projet.Controller.NoteController" %>
<div class="modal fade newnote" tabindex="-1" role="dialog" id="newnotemodal" >
	<div class="modal-dialog" role="document" >
		<div class="modal-content" >
			<div class="modal-header" >
				<button type="button" class="close" data-dismiss="modal" aria-label="Close" >
					<span aria-hidden="true" >&times;</span ></button >
				<h4 class="modal-title" >Ajout de note</h4 >
			</div >
			<form method="post" data-action="<%= NoteController.getBasePath( true ) %>/new?etu=" >
				<div class="modal-body" >
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
				</div >
				<div class="modal-footer" >
					<button type="submit" class="btn btn-primary" >Valider</button >
					<button type="reset" class="btn btn-default" data-dismiss="modal" >Annuler</button >
				</div >
			</form >
		</div ><!-- /.modal-content -->
	</div ><!-- /.modal-dialog -->
</div >
<!-- /.modal -->