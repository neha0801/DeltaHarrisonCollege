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
<title>Search for Classes</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Search for classes</div>
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

			<form role="form" action="ClassSearch" method="POST">
				<div class="form-group">
					<label for="subject">Subject:</label> 
					<select name = "subject">
						<option value ="all">all</option>
						<c:forEach var="subject" items="${subjects}">
							<option value="${subject.subjectId}">${subject.subjectCode}</option>
						</c:forEach>
					</select> <br>
					
					<label for="instructor">Instructor:</label> 
					<input type = "text" name="instructor" />
					<br>
					
					<label for="time">Time:</label> 
					<select name = "time">
						<option value = "all">all</option>
						<option value = "8">8:00AM</option>
						<option value = "9">9:00AM</option>
						<option value = "10">10:00AM</option>
						<option value = "11">11:00AM</option>
						<option value = "12">12:00PM</option>
						<option value = "13">1:00PM</option>
						<option value = "14">2:00PM</option>
						<option value = "15">3:00PM</option>
						<option value = "16">4:00PM</option>
						<option value = "17">5:00PM</option>
						<option value = "18">6:00PM</option>
						<option value = "19">7:00PM</option>
						<option value = "20">8:00PM</option>
					</select>
					
					<br>
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
							<th>Subject</th>
							<th>Instructor</th>
							<th>Department</th>
							<th>Time</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="currentClass" items="${classes}">
							<tr>
								<td>${currentClass.HCourse.name}</td>
								<td>${currentClass.HCourse.HSubject.subjectCode}</td>								
								<td>${currentClass.HStaffDetail.HUser.firstName} ${currentClass.HStaffDetail.HUser.lastName}</td>
								<td>${currentClass.HCourse.HMajor.HDepartment.name}</td>
								<td>${currentClass.getClassSchedule()}</td>
								
								
							</tr>
						</c:forEach>
					</tbody>
					

				</table>	
					
						


			
			</div>
	
	
	
	
	
	

</body>
</html>