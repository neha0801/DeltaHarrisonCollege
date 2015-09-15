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
			<div class="panel-heading">Assign Grades</div>
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
		<br>
			<FORM ACTION="AssignGrades" METHOD="post">
			<div>
             <INPUT TYPE="radio" NAME="grade" VALUE="A" CHECKED>
             A
            <BR>
            <INPUT TYPE="radio" NAME="grade" VALUE="B">
             B
            <BR>
            <INPUT TYPE="radio" NAME="grade" VALUE="C">
             C
            <BR>
             <INPUT TYPE="radio" NAME="grade" VALUE="D">
             D
            <BR> 
            </div>
            <input type="hidden" value="${enrollmentId}" name ="enrollmentId">
            <INPUT TYPE="submit" class="btn pull-right btn-primary" VALUE="Save">
        </FORM>
        </div>
		<br>
<!-- <form action="InstructorRoster" method="GET">
<input type="submit" value="Go back"></input>
</form> -->




	</div>

</body>
</html>