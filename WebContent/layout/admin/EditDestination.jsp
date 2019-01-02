<%@page import="com.urbantrip.model.Destination"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin | Edit Destination</title>
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
	<%
		Destination destination = (Destination) request.getAttribute("destination");
	%>

	<div id="wrapper">

		<jsp:include page="/layout/admin/layout/navigation.jsp"></jsp:include>

		<div id="page-wrapper">
			<form action="<%=request.getContextPath()%>/layout/admin/editDestination" method="post">
				<fieldset>
					<legend>EDIT DESTINATION</legend>
					<span class="form-group"> 
					<label for="name">Enter destination's name: </label> 
					<input class="form-control" type="hidden"
						name="idDestination" value="<%=destination.getIdDestination()%>"> 
					<input class="form-control" type="text" name="name" value="<%=destination.getName()%>">
					</span> 
					<span class="form-group"> 
					<label for="name">Enter tour id: </label> 
					<input class="form-control" type="hidden"
						name="idDestination" value="<%=destination.getIdDestination()%>"> 
					<input class="form-control" type="text" name="idTour"
						value="<%=destination.getIdTour()%>">
					</span>
					<div class="form-group">
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
				</fieldset>
			</form>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

</body>

</html>
