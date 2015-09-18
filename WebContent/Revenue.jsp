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
		<div class="panel-heading" align=center>
			<b>Revenue</b>
		</div>
		<div class="panel-body">
			<table class="table">
				<tbody>
					<form action="Revenue" method="Get">
						<tr>
							<td><label>Semester</label> <select name="semesters">
									<c:forEach var="item" items="${semestersList}">
										<option type="text" value="${item.semesterId}">${item.getSemester()}</option>
									</c:forEach>
							</select></td>
							<td><input type="hidden" value="ByDepartment" name="action"></input>
								<input type="submit" class="btn btn-primary"
								value="Revenue By Department"></input></td>
								
						</tr>
					</form>
								<form action="Revenue" method="Get">
						<tr>
							<td><label>Semester</label> <select name="semesters">
									<c:forEach var="item" items="${semestersList}">
										<option type="text" value="${item.semesterId}">${item.getSemester()}</option>
									</c:forEach>
							</select></td>
							
								<td><input type="hidden" value="ByInstructor" name="action"></input>
								<input type="submit" class="btn btn-primary"
								value="Revenue By Instructor"></input></td>
						</tr>
					</form>
					</form>
					<form action="Revenue" method="Get">
						<tr>
							<td><label>Semester</label> <select name="semesters">
									<c:forEach var="item" items="${semestersList}">
										<option type="text" value="${item.semesterId}">${item.getSemester()}</option>
									</c:forEach>
							</select></td>
							
								<td><input type="hidden" value="ByCourse" name="action"></input>
								<input type="submit" class="btn btn-primary"
								value="Revenue By Course"></input></td>
						</tr>
					</form>
					
						<form action="Revenue" method="Get">
						<tr>							
								
								<td colspan="2" ><input type="hidden" value="ByClass" name="action"></input>
								<input type="submit" class="btn btn-primary"
								value="Revenue By Class"></input></td>
						</tr>
					</form>
					<br>

				</tbody>
			</table>


		</div>
	</div>



</body>
</html>