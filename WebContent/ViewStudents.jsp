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
<title>Your Classes</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<table class="table table-bordered table-striped">
			<c:if test="${not empty enrolledList}">
			<thead>
				<tr>
					<td>Student Name</td>
					<td>Student Number</td>
					<td>Major</td>
					<td>Entry Year</td>
					<td>Grade</td>
					<td>Action</td>
				</tr>
			</thead>
			</c:if>
			<c:if test="${empty enrolledList}">
			<label>No Students are enrolled in this class</label>
			</c:if>
			<tbody>
			
				<c:forEach var="item" items="${enrolledList}">
				
					<tr>
					<form action="AssignGrades" method="GET" >
						<td>${item.HStudentDetail.HUser.getFullName()}</td>
						<td>${item.HStudentDetail.studentNumber}</td>
						<td>${item.HStudentDetail.HMajor.name}</td>
						<td>${item.HStudentDetail.entryYear}</td>
						<td>${item.grade }</td>
						
						<td><input type="hidden" name="enrollmentId" value="${item.enrollmentId}"></input>
						
						<c:if test="${not empty item.grade}">
							<input type="submit" class="btn btn-success" value="Change Grades"></input></td>
						</c:if>
						<c:if test="${empty item.grade}">
						<input type="submit" class="btn btn-success" value="Assign Grades"></input></td>
						</c:if>
						</form>
					</tr>
				</c:forEach>
			</tbody>


		</table>
		<br>
		<br>
<form action="InstructorRoster" method="GET">
<input type="hidden" value="getAll" name="action"></input>
<input type="submit" value="Go back" class="btn btn-primary"></input>
</form>




	</div>

</body>
</html>