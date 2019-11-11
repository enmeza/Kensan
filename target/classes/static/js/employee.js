function showEmployeeTable() {
	$(".nav-item").removeClass("active");
	$("#navGetAll").addClass("active");
	$.ajax({
        type: "GET",
        contentType: "html",
        url: "http://"+location.hostname+":8080/employeeTable",
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$(".main-section").html(data);
        	getAll();
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}
function showCreate(action, employeeData) {
	if (action != "edit") {
		$(".nav-item").removeClass("active");
		$("#navCreate").addClass("active");
	}
	$.ajax({
        type: "GET",
        contentType: "html",
        url: "http://"+location.hostname+":8080/createEmployee",
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$(".main-section").html(data);
        	if (action == "edit") {
        		$(".div-create-employee-header").html("Edit Employee");
        		$("#btnCreateSave").attr("data-action", "edit");
        		$("#btnCreateSave").attr("data-id", employeeData.employee.id);
        		$(".div-create-employee").find("#firstName").val(employeeData.employee.firstName);
    			$(".div-create-employee").find("#middleInitial").val(employeeData.employee.middleName);
    			$(".div-create-employee").find("#lastName").val(employeeData.employee.lastName);
    			$(".div-create-employee").find("#dateOfBirth").val(employeeData.employee.dateOfBirth);
    			$(".div-create-employee").find("#dateOfEmployment").val(employeeData.employee.dateOfEmployment);
        	}
        	$("#dateOfBirth").datepicker({ dateFormat: 'yy-mm-dd', changeMonth: true, changeYear: true, yearRange: "-100:+0" });
        	$("#dateOfEmployment").datepicker({ dateFormat: 'yy-mm-dd', changeMonth: true, changeYear: true, yearRange: "-100:+0" });
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}
function showFindEmployee() {
	$(".nav-item").removeClass("active");
	$("#navFind").addClass("active");
	$.ajax({
        type: "GET",
        contentType: "html",
        url: "http://"+location.hostname+":8080/findEmployee",
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$(".main-section").html(data);
        	getAll();
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}
function getAll(){
	$.ajax({
	    type: "POST",
	    contentType: "application/json",
	    url: "http://"+location.hostname+":8080/employee/getAll",
	    dataType: 'json',
	    cache: false,
	    timeout: 600000,
	    success: function (data) {
	    	fillTable(data, 1);
	    },
	    error: function (e) {
	        console.log("ERROR : ", e);
	    }
	});
}
function searchEmployee() {
	var employeeID = +$("#employeeID").val();
	$.ajax({
	    type: "POST",
	    contentType: "application/json",
	    url: "http://"+location.hostname+":8080/employee/getById?id="+employeeID,
	    dataType: 'json',
	    cache: false,
	    timeout: 600000,
	    success: function (data) {
	    	var response = {
	    			employeeList : [data.employee]
	    	}
	    	fillTable(response, 2);
	    },
	    error: function (e) {
	        console.log("ERROR : ", e);
	    }
	});
}
function fillTable(data, type) {
	var tableId = (+type === 1) ? "table-employee" : "table-search";
	if ($.fn.DataTable.isDataTable('#' + tableId) ) {
		$('#' + tableId).DataTable().destroy();
	}
	$('#' + tableId + ' tbody').empty();
	var response = data.employeeList;
	
	for(var i=0; i<response.length; i++){
		var employeeListResponse = response[i];
		var clazz = (i%2)?"odd":"even";
		var status = (+employeeListResponse.status === 1) ? "Active" : "Inactive";
		var cols = "<tr class='" + clazz + "'>";
    	cols += "<td>" + employeeListResponse.id + "</td>";
    	cols += "<td>" + employeeListResponse.firstName + "</td>";
    	cols += "<td>" + employeeListResponse.middleName + "</td>";
    	cols += "<td>" + employeeListResponse.lastName + "</td>";
    	cols += "<td>" + employeeListResponse.dateOfBirth + "</td>";
    	cols += "<td>" + employeeListResponse.dateOfEmployment + "</td>";
    	cols += "<td>" + status + "</td>";
    	if(+type === 1) {
	    	if (+employeeListResponse.status === 1) {
	    		cols += "<td><i class='fa-edit' title='Edit Employee' onclick='showEditEmployee(\""+employeeListResponse.id+"\");'></i>&nbsp;&nbsp;&nbsp;<i class='fa-delete' title='Unactivate Employee' onClick='deleteEmployee(\""+employeeListResponse.id+"\");'></i></td>";
	    	} else {
	    		cols += "<td></td>";
	    	}
    	}
    	cols += "</tr>";
    	$("#" + tableId).append(cols);
	}
	$("#" + tableId).DataTable({ "searching": false, "dom": 'rtip', "bSort" : false });
}
function deleteEmployee(employeeId){
	$("#btnModalAccept").attr("data-action","delete");
	$("#btnModalAccept").attr("data-id",employeeId);
	$("#createEmployee-modal").modal();
}
function showEditEmployee(employeeId){
	$("#btnModalAccept").attr("data-action","edit");
	$("#btnModalAccept").attr("data-id",employeeId);
	$("#createEmployee-modal").modal();
}
function modalAcceptAction(obj){
	if ($(obj).attr("data-action") == "delete"){
		if (isValidUser()) {
			$.ajax({
			    type: "POST",
			    contentType: "application/json",
			    url: "http://"+location.hostname+":8080/employee/delete?id="+ +$(obj).attr("data-id"),
			    dataType: 'json',
			    cache: false,
			    timeout: 600000,
			    success: function (data) {
			    	getAll();
			    	$("#createEmployee-modal").modal("hide");
			    	$("#generalModal").find("#modalText").html(data.message);
			    	$("#generalModal").modal();
			    },
			    error: function (e) {
			    	$("#createEmployee-modal").modal("hide");
			        $("#generalModal").find("#modalText").html("ERROR : ", e);
			    	$("#generalModal").modal();
			    }
			});
		} else {
			$("#createEmployee-modal").find(".modal-body").before("<div class='red'>The user and/or password are not correct</div>");
		}
	} else if ($(obj).attr("data-action") == "edit") {
		if (isValidUser()) {
			$("#createEmployee-modal").modal("hide");
			$(".modal-backdrop").remove();
			$.ajax({
			    type: "POST",
			    contentType: "application/json",
			    url: "http://"+location.hostname+":8080/employee/getById?id="+ +$(obj).attr("data-id"),
			    dataType: 'json',
			    cache: false,
			    timeout: 600000,
			    success: function (data) {
			    	showCreate("edit", data);
			    },
			    error: function (e) {
			    	$("#createEmployee-modal").modal("hide");
			        $("#generalModal").find("#modalText").html("ERROR : ", e);
			    	$("#generalModal").modal();
			    }
			});
		}
	}
}
function isValidUser() {
	var isValid = false;
	$.ajax({
	    type: "POST",
	    contentType: "application/json",
	    url: "http://"+location.hostname+":8080/employee/authentication?user="+$("#username").val()+"&pass="+$("#password").val(),
	    dataType: 'json',
	    async: false,
	    cache: false,
	    timeout: 600000,
	    success: function (data) {
	    	if (data.success) {
	    		isValid = true;
	    	} else {
	    		$("#createEmployee-modal").find(".modal-body").before("<div class='red'>The user and/or password are not correct</div>");
	    	}
	    },
	    error: function (e) {
	    	$("#createEmployee-modal").modal("hide");
	        $("#generalModal").find("#modalText").html("ERROR : ", e);
	    	$("#generalModal").modal();
	    }
	});
	return isValid;
}

function saveNewEmployee(obj){
	var employee = {
			firstName 	: $(".div-create-employee").find("#firstName").val(),
			middleName 	: $(".div-create-employee").find("#middleInitial").val(),
			lastName 		: $(".div-create-employee").find("#lastName").val(),
			dateOfBirth 	: $(".div-create-employee").find("#dateOfBirth").val(),
			dateOfEmployment: $(".div-create-employee").find("#dateOfEmployment").val()
	};
	var endPoint = "http://"+location.hostname+":8080/employee/save";
	if($(obj).data("action") == "edit") {
		employee['id'] = $(obj).data("id");
		endPoint = "http://"+location.hostname+":8080/employee/modify";
	}
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: endPoint,
		data : JSON.stringify(employee),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			$(".div-create-employee").find("input[type='text']").val("");
			if($(obj).data("action") == "edit") {
				$("#navGetAll").click();
			}
			$("#generalModal").find("#modalText").html(data.message);
			$("#generalModal").modal();
		},
		error: function (e) {
			$("#generalModal").find("#modalText").html("ERROR : ", e);
			$("#generalModal").modal();
		}
	});
}

$(document).ready(function() {
	showEmployeeTable();
});