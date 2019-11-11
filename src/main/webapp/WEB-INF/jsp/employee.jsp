<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/lib/bootstrap.min.css">
    <link rel="stylesheet" href="css/lib/datatables.css">
    <link rel="stylesheet" href="css/lib/jquery-ui.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/lib/jquery.min-3.4.1.js"></script>
    <script src="js/lib/bootstrap.min.js"></script>
    <script src="js/lib/datatables.js"></script>
    <script src="js/lib/jquery-ui.js"></script>
    <script src="js/employee.js"></script>
    <title>Kenzan - Employee</title>
  </head>
  <body>
    <%@ include file="common/header.jsp"%>
    <%@ include file="common/menu.jsp"%>
    <div class="container main-section">
	    
	</div>
	<div id="generalModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
	        	<div class="modal-header">
	          		<button type="button" class="close" data-dismiss="modal">&times;</button>
	        	</div>
	        	<div class="modal-body">
	        		<p id="modalText"></p>
	        	</div>
	        	<div class="modal-footer">
	          		<button id="button" data-dismiss="modal">Accept</button>
	        	</div>
	      	</div>
	      </div>
	</div>
  </body>
</html>
