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

<title>Admin | Add Destination</title>
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

		<div id="page-wrapper">
			<form action="<%=request.getContextPath()%>/layout/admin/addDestination" method="post" enctype='multipart/form-data'>
				<fieldset>
					<legend>ADD NEW DESTINATION</legend>
					<span class="form-group"> 
					<label for="name">Enter destination's name: </label> 
					<input class="form-control" type="hidden"
						name="idDestination"> 
					<input class="form-control" type="text" name="name" required>
					</span> 
					<span class="form-group"> 
					<label for="name">Enter tour id: </label> 
					<input class="form-control" type="hidden"
						name="idDestination"> 
					<input class="form-control" type="text" name="idTour" required>
					<label for="name">Upload image: </label>
					<input class="form-control" type="file" name="image" required>
					</span>
					<div class="form-group">
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</fieldset>
			</form>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

</body>

</html>
