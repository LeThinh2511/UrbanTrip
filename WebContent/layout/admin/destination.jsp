<%@page import="com.urbantrip.model.Destination"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.urbantrip.model.DAL"%>
<%@page import="com.urbantrip.model.Tour"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>UrbanTrip | Destination</title>
<link href="./vendor/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./vendor/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<link href="./vendor/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="./vendor/vendor/morrisjs/morris.css" rel="stylesheet">
<link href="./vendor/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">

		<jsp:include page="/layout/admin/layout/navigation.jsp"></jsp:include>
		<jsp:include page="/layout/admin/addDestinationForm.jsp"></jsp:include>

		<div id="page-wrapper">
			<%
				DAL dal = new DAL();
				ArrayList<Destination> allDestinations = new ArrayList<>();
				allDestinations = dal.getAllDestination();
			%>
			<div class="row">
				<h2 class="text-center">All Destinations</h2>
				<hr />
			</div>
			<div class="container">
				<div class="row">
					<%
						for (int i = 0; i < allDestinations.size(); i++) {
							Destination destination = allDestinations.get(i);
					%>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<div>
								<span><%=destination.getName()%></span>
							</div>
							<img src="<%=request.getContextPath()%>/images?id=<%=destination.getIdImage() %>" /> <a
								href="<%=request.getContextPath()%>/layout/admin/editDestination?id=<%=destination.getIdDestination()%>"
								class="btn btn-info  btn-primary sbold uppercase"> Edit </a> <a
								href="javascript:void(0)"
								data-id=<%=destination.getIdDestination()%>
								class="btn btn-danger btn-outline sbold uppercase deleteDestination">
								Delete </a>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<a href="<%=request.getContextPath()%>/layout/admin/addDestination"
				class="btn btn-info  btn-primary sbold uppercase"> Add New
				Destination </a>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<script>
		function myFunction() {
			var element = document.getElementsByClassName("destination")[0].classList
					.add("active");
		}
	</script>

	<jsp:include page="layout/script.jsp"></jsp:include>
</body>
<script>
	$(document).ready(function() {
		$('.deleteDestination').click(function () {
			var id = $(this).data("id");
			console.log(id);
		    var confirmText = "Are you sure you want to delete this destination?";
		    if(confirm(confirmText)) {
		    	$.ajax({
		            type:"POST",
		            dataType:"json",
		            url: "<%=request.getContextPath()%>/layout/admin/deleteDestination",
															data : {
																id : $(this)
																		.data(
																				"id")
															},
															success : function() {
																alert("Delete Successfully!");
																$(this)
																		.closest(
																				'tr')
																		.remove();
															}

														});
												$(this).closest('tr').remove();
											}
											window.location.reload();
											return false;
										});
					})
</script>
</html>