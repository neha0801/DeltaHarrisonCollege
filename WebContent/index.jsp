<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Harrison College</title>
<style>
	.navbar-brand
	{
	    margin: 0px;
	    padding: 4px;
	}
	
	.navbar-inverse
	{
		background-color: #1E6912;
	}
	
	.navbar-inverse .navbar-nav > li > a
	{
		color: #64B058;
	}
	
	.navbar-inverse .navbar-nav > li > a:hover,
	.navbar-inverse .navbar-nav > li > a:focus 
	{
	    color: #96D38D;
	}
	
	
	body 
	{
			background: #64B058 url("logo.png") no-repeat fixed bottom; 
	}

	.mainNav
	{
		margin-top: 15px;
	}
	.navbar-inverse .navbar-nav > .dropdown > .dropdown-menu {
	    background-color: #3C8D2F;
	}
	
	.logo
	{
		margin: 0px;
		padding: 0px;
		float:left;
	}
	
	.mainNav
	{
		float:left;
		width:90%;
	}
	.navbar-inverse 
	{
  		border-color: transparent;
  		border-radius: 0 !important;
  	}
</style>
</head>
<body>
<div class="logo">
	<a href="index.jsp"><img src="logo.png" width="82px" alt="Harrison College" class="img-rounded" style="background-color: #1E6912; padding:2px;" /></a>
</div>
<div class="mainNav">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- 
			<div class="navbar-header">
				<a class="navbar-brand"></a>
			</div>
			
			 -->
			<div>
				<ul class="nav navbar-nav">
					<c:if test="${empty user}">
						<li><a href="LoginForm.jsp">Login <span class="glyphicon glyphicon-log-in"></a></li>
						<li><a href="RegisterUser?action=load">Register</a></li>

					</c:if>
					<c:if test="${not empty user}">
					
					
						<c:if test="${user.isAdmin()}">
						  	<li role="presentation" class="dropdown">
	    						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	      							Admin Functions <span class="caret"></span>
	    						</a>
		    					<ul class="dropdown-menu">
		      						<li> <a href="AdminCourse">Manage Courses</a> </li>
		      						<li> <a href="AdminClassroom">Manage Classrooms</a> </li>
		      						<li> <a href="AdminDepartment">Manage Departments</a> </li>
		      						<li> <a href="AdminMajor">Manage Majors</a> </li>
		      						<li><a href="SearchForUser">Manage User Role</a>
		      						<li><a href="AddClass?action=load">Add Class</a></li>
		      						<li><a href="RemoveClass?action=load">Remove Class</a></li>
		      						<li><a href="OverrideEnrollment">Override Enrollment</a></li>
  									<li><a href="CreditFee?action=load">Tuition Credit Fee</a></li>
									<li><a href="Revenue?action=load">Revenue</a></li>		
		    					</ul>
	  						</li>	
							<li><a href="AdminReportSelection.jsp">Admin Reports</a></li>		
							
						</c:if>
						
						
						<c:if test="${user.isStudent()}">
							<li><a href="CurrentSchedule">Current Schedule</a></li>
							<li><a href="AllClasses">Enroll</a></li>
						  	<li role="presentation" class="dropdown">
	    						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	      							Transcript <span class="caret"></span>
	    						</a>
		    					<ul class="dropdown-menu">
		      						<li><a href="Transcript?type=Unofficial">View Unofficial Transcript</a></li>
		      						<li><a href="OfficialTranscript.jsp">Order Official Transcript</a></li>
		    					</ul>
	  						</li>
	
	
						</c:if>
						
						
						<c:if test="${user.isAdvisor()}">
							<li><a href="CurrentSchedule.jsp">Manage Student Schedule</a></li>
							<li><a href="Transcript.jsp">View Student Transcript</a></li>
							<li><a href="OverrideEnrollment">Enroll a student</a></li>
						</c:if>
						
						
						<c:if test="${user.isInstructor()}">
							<li><a href="InstructorClasses">Current Classes</a></li>
							<li><a href="InstructorRoster?action=getAll">Class Roster</a></li>
							<li><a href="InstructorRoster?action=getAll">Assign Grade</a></li>
							<li><a href="InstructorRoster?action=getAll">View Gradesheet</a></li>
						</c:if>
						
						
					  	<li role="presentation" class="dropdown">
	   						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	     							Courses <span class="caret"></span>
	   						</a>
	    					<ul class="dropdown-menu">
	      						<li><a href="AllCourses">View All Courses</a></li>
	      						<li><a href="CourseSearch">Courses by Department</a></li>
	    					</ul>
	 						</li>  						
						<li><a href="ClassSearch">Search for Classes</a></li>
						<li><a href="MajorSearch">Majors</a></li>
						<li><a href="Logout">Logout</a>
					</c:if>
				</ul>
			</div>
		</div>

	</nav>
</div>

				<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="image1.jpg" alt="Chania" width="1200" height="800">
      </div>

      <div class="item">
        <img src="image2.jpg" alt="Chania" width="1200" height="800">
      </div>
    
      <div class="item">
        <img src="image3.jpg" alt="Flower" width="1200" height="800">
      </div>

      <div class="item">
        <img src="image4.jpg" alt="Flower" width="1200" height="800">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>