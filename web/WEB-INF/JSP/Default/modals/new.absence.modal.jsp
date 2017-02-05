<%@ page import="projet.Controller.AbsenceController" %>
<div class="modal fade newabsence" tabindex="-1" role="dialog" id="newabsencemodal" >
	<div class="modal-dialog" role="document" >
		<div class="modal-content" >
			<div class="modal-header" >
				<button type="button" class="close" data-dismiss="modal" aria-label="Close" >
					<span aria-hidden="true" >&times;</span ></button >
				<h4 class="modal-title" >Ajout d'une absence</h4 >
			</div >
			<form method="post" data-action="<%= AbsenceController.getBasePath( true ) %>/new?etu=" >
				<div class="modal-body" >
					<div class="form-group" >
						<label for="fromDate" >Date de début</label >
						<div class='input-group date datetimepicker' >
							<input type="text" id="fromDate" name="fromDate" class="form-control" >
							<span class="input-group-addon" >
								<span class="glyphicon glyphicon-calendar" ></span >
							</span >
						</div >
					</div >
					
					<div class="form-group" >
						<label for="toDate" >Date de fin</label >
						<div class='input-group date datetimepicker' >
							<input type="text" id="toDate" name="toDate" class="form-control" >
							<span class="input-group-addon" >
								<span class="glyphicon glyphicon-calendar" ></span >
							</span >
						</div >
					</div >
				</div >
				<div class="modal-footer" >
					<button type="reset" class="btn btn-default" data-dismiss="modal" >Annuler</button >
					<button type="submit" class="btn btn-primary" >Valider</button >
				</div >
			</form >
		</div ><!-- /.modal-content -->
	</div ><!-- /.modal-dialog -->
</div >
<!-- /.modal -->