<%@page import="com.urbantrip.model.DAL"%>
<%@page import="com.urbantrip.model.Tour"%>
<%@page import="java.util.ArrayList"%>
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

<title>UrbanTrip | Tour</title>
<link
	href="./layout/admin/vendor/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./layout/admin/vendor/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<link href="./layout/admin/vendor/dist/css/sb-admin-2.css"
	rel="stylesheet">
<link href="./layout/admin/vendor/vendor/morrisjs/morris.css"
	rel="stylesheet">
<link
	href="./layout/admin/vendor/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapper">
		<%
			System.out.print("to tour");
		%>

		<jsp:include page="/layout/admin/layout/navigation.jsp"></jsp:include>

		<div id="page-wrapper">
			<%
				DAL dal = new DAL();
				ArrayList<Tour> allTours = new ArrayList<>();
				allTours = dal.getAllTour();
			%>
			<div class="row">
				<h2 class="text-center">All Tours</h2>
				<hr />
				<a style="font-size: 20px" data-toggle="modal"
					data-target="#newtour"> <i class="fa fa-plus"></i></a>
			</div>

			<%
				for (int i = 0; i < allTours.size(); i++) {
					Tour tour = allTours.get(i);
					System.out.println("" + tour.getName());
					if (i % 2 == 0) {
			%>
			<div class="row">
				<%
					}
				%>

				<div class="col-md-6 tourItem">
					<div class="thumbnail">
						<a data-toggle="modal" data-target="#tour<%=tour.getIdTour()%>"
							style="font-size: 30px; padding: 0px;"><h5><%=tour.getName()%></h5></a>
						<a style="font-size: 15px; float: right;" data-toggle="modal"
							data-target="#deleteTour<%=tour.getIdTour()%>"> <i
							class="fa fa-times"></i>
						</a> <img height="500px" src="./img/tours/<%=tour.getImagePath()%>"
							alt="...">
					</div>
				</div>
				<%
					if (i % 2 != 0) {
				%>
			</div>
			<%
				}
			%>
			<!-- modals -->
			<div class="modal fade" id="tour<%=tour.getIdTour()%>" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title"><%=tour.getName()%></h4>
						</div>
						<div class="modal-body row">
							<form action="EditTour?id=<%=tour.getIdTour()%>" method="post">
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="tourName">Name</label> <input type="text"
											class="form-control" id="tourName" name="edittourName"
											placeholder="Tour Name" value="<%=tour.getName()%>">
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="tourDescription">Description</label>
										<textarea class="form-control" id="tourDescription"
											style="height: 100px" name="edittourDescription"
											value="<%=tour.getDescription()%>"></textarea>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="tourPrice">Price</label> <input type="text"
											class="form-control" id="inputTourPrice" name="edittourPrice"
											value="<%=tour.getPrice()%>">
									</div>
									<div class="form-group col-md-4">
										<label for="tourType">Type</label> <select id="editinputTourType"
											class="form-control" name="edittourType">
											<option selected><%=tour.getType()%></option>
											<option>Walking Tour</option>
										</select>
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Update</button>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>

			<!-- delete modals -->
			<div class="modal fade" id="deleteTour<%=tour.getIdTour()%>"
				role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Confirmation</h4>
						</div>
						<div class="modal-body">
							Would you like to delete
							<%=tour.getName()%>?
						</div>
						<div class="modal-footer">
							<a
								href="<%=request.getContextPath()%>/DeleteTour?id=<%=tour.getIdTour()%>"
								data-id=<%=tour.getIdTour()%> class="btn btn-default"> Yes </a>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">No</button>
						</div>
					</div>

				</div>
			</div>
			<%
				}
			%>
			<div class="col-md-6">
				<div class="thumbnail"></div>
				<!-- modals -->

			</div>

		</div>
		<div class="modal fade" id="newtour" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">New Tour</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<form action="addnewTour" method="post">
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="tourName">Name</label> <input type="text"
											class="form-control" id="tourName" name="tourName"
											placeholder="Tour Name">
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="tourDescription">Description</label>
										<textarea class="form-control" id="tourDescription"
											name="tourDescription"></textarea>
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="tourPrice">Price</label> <input type="text"
											class="form-control" id="inputTourPrice" name="tourPrice">
									</div>
									<div class="form-group col-md-4">
										<label for="tourType">Type</label> 
										<select id="inputTourType"
											class="form-control" name="tourType">
											<option selected>Cycling Tour</option>
											<option>Walking Tour</option>
										</select>
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Sign in</button>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<jsp:include page="/layout/admin/layout/script.jsp"></jsp:include>
	<script>
		function myFunction() {
			var element = document.getElementsByClassName("tour")[0].classList
					.add("active");
		}
	</script>
	<script>
		$(document).ready(function() {
			console.log("a");
			$('.deleteTour').click(function () {
				console.log("clicked");
				var id = $(this).data("id");
				console.log(id);
			    	$.ajax({
			            type:"POST",
			            dataType:"json",
			            url: "<%=request.getContextPath()%>
		" + "/DeleteTour",
					data : {
						id : $(this).data("id")
					}

				});

			});
		})
	</script>


</body>
</html>