<div class="div-table-employee">
    <table class="table" id="table-employee" border="0">
    	<thead class="thead-dark">
		   <tr>
		     <th scope="col">#</th>
		     <th scope="col">First Name</th>
		     <th scope="col">Middle Initial</th>
		     <th scope="col">Last Name</th>
		     <th scope="col">Date Of Birth</th>
		     <th scope="col">Date Of Employment</th>
		     <th scope="col">Status</th>
		     <th scope="col"></th>
		   </tr>
 		</thead>
		<tbody>
		</tbody>
    </table>
</div>
<div id="createEmployee-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
        	<div class="modal-header">
        		<h5 class="modal-title">You need to provide admin credentials to continue</h5>
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
        	</div>
        	<div class="modal-body">
        		<div class="row">
	        		<div class="col-xl-4">Username:</div>
	        		<div class="col-xl-8"><input type="text" id="username" /></div>
				</div><br>
				<div class="row">
	        		<div class="col-xl-4">Password:</div>
	        		<div class="col-xl-8"><input type="password" id="password" /></div>
				</div>
        	</div>
        	<div class="modal-footer">
          		<button id="btnModalAccept" type="button" class="btn btn-secondary" onClick="modalAcceptAction(this);">Accept</button>
        	</div>
      	</div>
      </div>
</div>