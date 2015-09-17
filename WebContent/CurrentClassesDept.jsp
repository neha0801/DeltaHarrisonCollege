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
<title>Admin Current Class Search</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Search for current classes in Department</div>
		<div class="panel-body">


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

			<form role="form" action="CurrentClassesDept" method="POST">
				<div class="form-group">
					
					<label for="deparment">Department</label>
					<select name="department">
						<option value = "all">all</option>

						<c:forEach var="dept" items="${departments}">
							<option value="${dept.departmentId}">${dept.name}</option>
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
							<th>Course Name</th>
							<th>Room Number</th>
							<th>Building Name</th>
							<th>Department</th>
							<th>Semester</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="currentClass" items="${classes}">
							<tr>
								<td>${currentClass.HCourse.name}</td>
								<td>${currentClass.HClassroom.roomNumber}</td>								
								<td>${currentClass.HClassroom.buildingName}</td>
								<td>${currentClass.HCourse.HMajor.HDepartment.name}</td>
								<td>${currentClass.HSemester.season} ${currentClass.HSemester.year}</td>
								<td>${currentClass.status}</td>
								
							</tr>
						</c:forEach>
					</tbody>
					

				</table>	
					
						


			
			</div>
	
	
	
	
	

</body>
</html>