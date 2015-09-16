<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<title>Admin Classroom Options</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">
			Admin Classroom Options <span class="glyphicon glyphicon-user"> <a class="btn btn-success" href="ServletAddCourse.java">Create New Classroom</a>
		</div>
		<form role="form" action="/ServletAdminCourse" method="POST">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<td>Building Name</td>
					<td>Room Number</td>
					<td>Max Capacity</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="classroom" items="${classrooms}">
					<tr>
						<td>${classroom.buildingName}</td>
						<td>${classroom.roomNumber}</td>
						<td>${classroom.maxCapacity }</td>
						<td><a class="btn btn-success" href = "EditClassroom?classroomId=${classroom.classroomId}">Update Classroom</td>

					</tr>
				</c:forEach>
			</tbody>


		</table>
</form>




	</div>

</body>
</html>