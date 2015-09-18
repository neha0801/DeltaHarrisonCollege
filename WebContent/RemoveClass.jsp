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
<title>Remove Classes</title>
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
<div class="panel-heading">
			Remove Classes <span class="glyphicon glyphicon-user"> 
		</div>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<td>Course Name</td>
					<td>Classroom</td>
					<td>Class Schedule</td>
					<td>Semester</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="currentClass" items="${classes}">
					<tr>
						<td>${currentClass.HCourse.name}</td>
						<td>${currentClass.getClassroom()}</td>
						<td>${currentClass.getClassSchedule()}</td>
						<td>${currentClass.HSemester.getSemester()}</td>
						<form action="RemoveClass" method="POST">
						<td><input type="hidden" name="classId"
							value="${currentClass.classId}"></input> <input type="hidden"
							name="action" value="load"></input> <input type="submit"
							class="btn pull-right btn-danger" value="Remove Class"></input></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>


		</table>





	</div>

</body>
</html>