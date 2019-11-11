<div class="div-find-employee">
	<div class="form-find-employee">
		<div class="div-create-employee-header">
			Get Employee By ID:
		</div>
		<div class="row">
			<div class="col-xl-2"></div>
			<div class="col-xl-8">
				ID: <input type="text" id="employeeID" /> 
				<button id="btnSearchEmployee" type="button" class="btn btn-info" onclick="searchEmployee(this);"> Search </button></div>
			<div class="col-xl-2"></div>
		</div>
	</div>
	<div class="div-table-search">
	    <table class="table" id="table-search" border="0">
	    	<thead class="thead-dark">
			   <tr>
			     <th scope="col">#</th>
			     <th scope="col">First Name</th>
			     <th scope="col">Middle Initial</th>
			     <th scope="col">Last Name</th>
			     <th scope="col">Date Of Birth</th>
			     <th scope="col">Date Of Employment</th>
			     <th scope="col">Status</th>
			   </tr>
	 		</thead>
			<tbody>
			</tbody>
	    </table>
	</div>
</div>