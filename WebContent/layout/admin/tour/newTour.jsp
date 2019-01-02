<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action = "newTour" method = "post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="tourName">Name</label> 
					<input type="text"
						class="form-control" id="inputTourName" name="tourName" placeholder="Tour Name">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-12">
					<label for="tourDescription">Description</label>
					<textarea class="form-control" id="tourDescriptionTxArea" name="tourDescription"></textarea>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="tourPrice">Price</label> 
					<input type="text"
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
</body>
</html>