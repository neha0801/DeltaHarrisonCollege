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
<title>Add Class</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Add Class</div>
		<form action="AddClass" method="post">
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
			<div class="form-group">
				<label>Major</label> <select name="major">
					<c:forEach var="item" items="${majors}">
						<option type="text" value="${item.majorId}">${item.name}</option>
					</c:forEach>
				</select><br> <br> <label>Course</label> <select name="course">
					<c:forEach var="item" items="${courses}">
						<option type="text" value="${item.courseId}">${item.name}</option>
					</c:forEach>
				</select><br> <br> <label>Instructor</label> <select
					name="instructor">
					<c:forEach var="item" items="${instructors}">
						<option type="text" value="${item.userId}">${item.getFullName()}</option>
					</c:forEach>
				</select><br> <br> <label>Semester</label> <select name="semester">
					<c:forEach var="item" items="${semesters}">
						<option type="text" value="${item.semesterId}">${item.getSemester()}</option>
					</c:forEach>
				</select><br> <br> <label>Classroom</label> <select
					name="classroom">
					<c:forEach var="item" items="${classrooms}">
						<option type="text" value="${item.classroomId}">${item.getClassroom()}</option>
					</c:forEach>
				</select><br> <br> 
				<label>Class Schedule:</label><br> 
				<label for="time1">Monday  :</label> <select
					name="time1">
					<option value="-1">NO CLASS</option>
					<option value="8">8:00AM</option>
					<option value="9">9:00AM</option>
					<option value="10">10:00AM</option>
					<option value="11">11:00AM</option>
					<option value="12">12:00PM</option>
					<option value="13">1:00PM</option>
					<option value="14">2:00PM</option>
					<option value="15">3:00PM</option>
					<option value="16">4:00PM</option>
					<option value="17">5:00PM</option>
					<option value="18">6:00PM</option>
					<option value="19">7:00PM</option>
					<option value="20">8:00PM</option>
				</select> 
				<label for="time2">Tuesday  :</label> <select name="time2">
					<option value="-1">NO CLASS</option>
					<option value="8">8:00AM</option>
					<option value="9">9:00AM</option>
					<option value="10">10:00AM</option>
					<option value="11">11:00AM</option>
					<option value="12">12:00PM</option>
					<option value="13">1:00PM</option>
					<option value="14">2:00PM</option>
					<option value="15">3:00PM</option>
					<option value="16">4:00PM</option>
					<option value="17">5:00PM</option>
					<option value="18">6:00PM</option>
					<option value="19">7:00PM</option>
					<option value="20">8:00PM</option>
				</select> 
				<label for="time3">Wednesday:</label> <select name="time3">
					<option value="-1">NO CLASS</option>
					<option value="8">8:00AM</option>
					<option value="9">9:00AM</option>
					<option value="10">10:00AM</option>
					<option value="11">11:00AM</option>
					<option value="12">12:00PM</option>
					<option value="13">1:00PM</option>
					<option value="14">2:00PM</option>
					<option value="15">3:00PM</option>
					<option value="16">4:00PM</option>
					<option value="17">5:00PM</option>
					<option value="18">6:00PM</option>
					<option value="19">7:00PM</option>
					<option value="20">8:00PM</option>
				</select><br><br>
				<label for="time4">Thursday   :</label> <select name="time4">
					<option value="-1">NO CLASS</option>
					<option value="8">8:00AM</option>
					<option value="9">9:00AM</option>
					<option value="10">10:00AM</option>
					<option value="11">11:00AM</option>
					<option value="12">12:00PM</option>
					<option value="13">1:00PM</option>
					<option value="14">2:00PM</option>
					<option value="15">3:00PM</option>
					<option value="16">4:00PM</option>
					<option value="17">5:00PM</option>
					<option value="18">6:00PM</option>
					<option value="19">7:00PM</option>
					<option value="20">8:00PM</option>
				</select> 
				<label for="time5">Friday    :</label> <select name="time5">
					<option value="-1">NO CLASS</option>
					<option value="8">8:00AM</option>
					<option value="9">9:00AM</option>
					<option value="10">10:00AM</option>
					<option value="11">11:00AM</option>
					<option value="12">12:00PM</option>
					<option value="13">1:00PM</option>
					<option value="14">2:00PM</option>
					<option value="15">3:00PM</option>
					<option value="16">4:00PM</option>
					<option value="17">5:00PM</option>
					<option value="18">6:00PM</option>
					<option value="19">7:00PM</option>
					<option value="20">8:00PM</option>
				</select>

				<div class="form-group">
					<input type="hidden" value="load" name="action"></input>
					<input type="submit" class="btn pull-right btn-danger" value="Add Class"></input>
				</div>
			</div>
		</div>
		</form>
		</div>
		
</body>
</html>