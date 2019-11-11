<div class="div-create-employee">
	<div class="div-create-employee-header">
		New Employee
	</div>
	<div class="row">
		<div class="col-xl-1"></div>
		<div class="col-xl-5">First Name: <input type="text" id="firstName" /></div>
		<div class="col-xl-5">Middle Initial: <input type="text" id="middleInitial" /></div>
		<div class="col-xl-1"></div>
	</div>
	<div class="row">
		<div class="col-xl-1"></div>
		<div class="col-xl-11">Last Name: <input type="text" id="lastName" /></div>
	</div>
	<div class="row">
		<div class="col-xl-1"></div>
		<div class="col-xl-5">Date of Birth: <input type="text" id="dateOfBirth" readonly /></div>
		<div class="col-xl-5">Date of Employment: <input type="text" id="dateOfEmployment" readonly /></div>
		<div class="col-xl-1"></div>
	</div>
	<div class="row">
		<div class="col-xl-12 button-save"><button id="btnCreateSave" type="button" data-action="create" class="btn btn-info" onclick="saveNewEmployee(this);"> Save </button></div>
	</div>
</div>
