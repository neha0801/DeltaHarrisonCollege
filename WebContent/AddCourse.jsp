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
<title>Add Course</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Add Course</div>
		<div class="panel-body">


<form role="form" action="/ServletAddCourse" method="GET">

			<div class="form-group">
				<label for="courseNumber">Course Number: </label> <input type="text"
					class="form-control" name="courseNumber"
					required />
			</div>
			<div class="form-group">
				<label for="courseName">Course Name: </label> <input type="text"
					class="form-control" name="courseName"
					 required />
			</div>
			<div class="form-group">
					<label for="courseDescription">Description: </label> <input type="text"
						class="form-control" name="courseDescription" 
						required />
				</div>
				<div class="form-group">
					<label for="courseCredits">Credits: </label> <input type="text"
						class="form-control" name="courseCredits" 
						required />
				</div>
					<div class="form-group">
					<button type="submit" value="submit" class="btn btn-default">Update</button>
${errorMessage}

				</div>
</form>

		</div>
	</div>

</body>
</html>
</html>