
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




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
<div class="logo">
	<img src="logo.png" width="82px" alt="Harrison College" class="img-rounded" style="background-color: #1E6912; padding:2px;" />
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
						<li><a href="LoginForm.jsp">Login</a></li>
						<li><a href="RegisterUser.jsp">Register</a></li>
					</c:if>
					<c:if test="${not empty user}">
					
					
						<c:if test="${user.isAdmin()}">
						  	<li role="presentation" class="dropdown">
	    						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	      							Admin Functions <span class="caret"></span>
	    						</a>
		    					<ul class="dropdown-menu">
		      						<li> <a href="#">Manage Courses</a> </li>
		      						<li> <a href="#">Manage Classrooms</a> </li>
		      						<li> <a href="#">Manage Departments</a> </li>
		      						<li> <a href="#">Manage Majors</a> </li>
		      						<li><a href="SearchForUser">Manage User Role</a>
		      						<li><a href="AddClass?action=load">Add Class</a></li>
		      						<li><a href="RemoveClass?action=load">Remove Class</a></li>
		      						<li><a href="#">Override Enrollment</a></li>		
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
		      						<li><a href="Transcript?type=Official">Order Official Transcript</a></li>
		    					</ul>
	  						</li>
	
	
						</c:if>
						
						
						<c:if test="${user.isAdvisor()}">
						
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

