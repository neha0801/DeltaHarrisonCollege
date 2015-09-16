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
<title>Admin Course Class Search</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Search for classes in a Course</div>
		<div class="panel-body">


			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger">
					<c:out value="${errorMessage}" />
				</div>
			</c:if>

			

			<form role="form" action="AdminCourseClassSearch" method="POST">
				<div class="form-group">
					
					<label for="course">Course</label>
					<select name="course">
						<option value = "all">all</option>

						<c:forEach var="course" items="${courses}">
							<option value="${course.courseId}">${course.name}</option>
						</c:forEach>

					</select>
					
				</div>

				<div class="form-group">
					<button type="submit" value="submit" class="btn btn-default">Search</button>

					
				</div>
			</form>
		</div>
	</div>
	
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">

				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Course Number</th>
							<th>Course Name</th>
							<th>Status</th>
							<th>Semester</th>
							<th>Subject</th>							
							<th>Department</th>
							<th>Class Day/Time</th>
							
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="currentclass" items="${classes}">
							<tr>
								<td>${currentclass.HCourse.courseNumber}</td>
								<td>${currentclass.HCourse.name}</td>								
								<td>${currentclass.HCourse.status}</td>
								<td>${currentclass.HSemester.season} ${currentclass.HSemester.year}</td>
								<td>${currentclass.HCourse.HSubject.subjectCode}</td>							
								<td>${currentclass.HCourse.HMajor.HDepartment.name}</td>
								<td>
									<c:forEach var="currentSchedule" items="${currentclass.HClassSchedules}">
									${currentSchedule.HWeekday.name} - ${currentSchedule.classTime}
									</c:forEach>
								</td>							
								
							</tr>
						</c:forEach>
					</tbody>
					

				</table>	
					
						


			
			</div>
	
	
	
	
	

</body>
</html>