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
<title>Admin Reports</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">
			<c:out value="${errorMessage}" />
		</div>
	</c:if>

	<c:if test="${not empty goodMessage}">
		<div class="alert alert-success">
			<c:out value="${goodMessage}" />
		</div>
	</c:if>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Reports</div>
		<div class="panel-body">


			<c:if test="${reportType eq 'ByInstructor'}">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<td>Student Name</td>
							<td>Student Number</td>
							<td>Major</td>
							<td>Entry Year</td>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${userList}">

							<tr>

								<td>${item.getFullName()}</td>
								<td>${item.HStudentDetail.studentNumber}</td>
								<td>${item.HStudentDetail.HMajor.name}</td>
								<td>${item.HStudentDetail.entryYear}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="AdminReportSelection.jsp" class="btn btn-primary"> Go Back</a>
			</c:if>
			
			<c:if test="${reportType eq 'ByClass'}">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<td>Instructor Name</td>
							<td>Employee Number</td>
							<td>Department</td>
							<td>Office Number</td>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${instructorList}">

							<tr>

								<td>${item.HUser.getFullName()}</td>
								<td>${item.employeeNumber}</td>
								<td>${item.HDepartment.name}</td>
								<td>${item.officeNumber}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="AdminReportSelection.jsp" class="btn btn-primary"> Go Back</a>
			</c:if>


		</div>
	</div>



</body>
</html>