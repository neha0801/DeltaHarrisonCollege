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
	<div class="panel panel-success col-sm-6 col-sm-offset-3">
		<div class="panel-heading" align=center><b>Reports</b></div>
		<div class="panel-body">

			<form action="AdminReports" method="GET">
				<input type="hidden" value="ByInstructor" name="ReportType"></input>
				<input type="submit" class="btn btn-success"
					value="Students taught by an instructor"></input>
			</form> <br>
			<form action="AdminReports" method="GET">
				<input type="hidden" value="ByClass" name="ReportType"></input>
				<input type="submit" class="btn btn-success"
					value="Instructors  that have taught by a class"></input>
			</form> <br>
			

			
			
			<c:if test="${reportType eq 'ByInstructor'}">
			<br>
			<label>Selection:</label>
			<br>
				<table class="table table-bordered table-striped">
					<tbody>
						<form action="AdminReports" method="POST">
						<tr>
							<td><label>Instructor</label> <select name="instructor">
									<c:forEach var="item" items="${instructors}">
										<option type="text" value="${item.userId}">${item.getFullName()}</option>
									</c:forEach>
							</select></td>
							<td><input type="hidden" 	value="ByInstructor" name="reportType">
							<input type="submit" class="btn pull-right btn-warning"
								value="View Students"></input></td>
						</form>
						</tr>
					</tbody>
				</table>
			</c:if>
			<c:if test="${reportType eq 'ByClass'}">
				<br>
			<label>Selection:</label>
			<br>
				<table class="table table-bordered table-striped">
					<tbody>
						<form action="AdminReports" method="POST">
						<tr>
							<td><label>Class</label> <select name="courseList">
									<c:forEach var="item" items="${courseList}">
										<option type="text" value="${item.courseId}">${item.name}</option>
									</c:forEach>
							</select></td>
							<td><input type="hidden" 	value="ByClass" name="reportType">
							<input type="submit" class="btn pull-right btn-warning"
								value="View Instructors"></input></td>
						</form>
						</tr>
					</tbody>
				</table>
			</c:if>

			<a href="ClassesByInstructor.jsp" class ="btn btn-success">All Classes By Instructor</a><br><br>
			<a href="ClassesByStudent.jsp" class ="btn btn-success">All Classes By Student</a><br><br>
			<a href="AdminCourseClassSearch" class ="btn btn-success">All Classes By Course</a><br><br>
			<a href="CurrentClassesDept" class ="btn btn-success">Current Classes By Department</a><br><br>
			<a href="Revenue?action=load" class ="btn btn-success">Revenue</a><br><br>
		</div>
	</div>



</body>
</html>