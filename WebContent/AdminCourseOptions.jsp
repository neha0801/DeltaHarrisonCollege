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
<title>Admin Course Options</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">
			Admin Course Options <span class="glyphicon glyphicon-user"> <a class="btn btn-success" href="">Create New Course</a>
		</div>
		<form role="form" action="/ServletAdminCourse" method="POST">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<td>Course Number</td>
					<td>Course Name</td>
					<td>Description</td>
					<td>Subject</td>
					<td>Credits</td>
					<td>Option</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="course" items="${courses}">
					<tr>
						<td>${course.courseNumber}</td>
						<td>${course.name}</td>
						<td>${course.description}</td>
						<td>${course.HSubject.subjectCode}</td>
						<td>${course.credits}</td>
						<td><a class="btn btn-success" href = "EditCourse?courseId=${course.courseId}">Update Course</td>

					</tr>
				</c:forEach>
			</tbody>


		</table>
</form>




	</div>

</body>
</html>