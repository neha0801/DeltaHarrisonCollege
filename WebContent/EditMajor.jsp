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
<title>Edit Major</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<jsp:include page="./header.jsp" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="panel panel-primary col-sm-6 col-sm-offset-3">
		<div class="panel-heading">Edit Major</div>
		<div class="panel-body">


<form role="form" action="EditMajor" method="POST">

			<div class="form-group">
				<label for="departmentName">Major Name: </label> <input type="text"
					class="form-control" name="majorName"
					value="${major.name}" required />
			</div>
			<div class="form-group">
			<label for="sel1">Status: </label>
				<select class="form-control" name="majorStatus">
						<option value="Active" <c:if test="${major.status eq 'Active'}">selected</c:if> >Active</option>
						<option value="Inactive" <c:if test="${major.status eq 'Inactive'}">selected</c:if> >Inactive</option>
				</select>
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