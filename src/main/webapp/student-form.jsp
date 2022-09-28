<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #0492c2">
			<div>
				<a href=student-list class="navbar-brand">
					Student Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="update" method=post>
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method=post>
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id"
						value="<c:out value='${student.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${student.fname}' />" class="form-control"
						name="fname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${student.lname}' />" class="form-control"
						name="lname">
				</fieldset>

				<fieldset class="form-group">
					<label>Date of Birth</label> <input type="text"
						value="<c:out value='${student.dob}' />" class="form-control"
						name="dob">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="text"
						value="<c:out value='${student.age}' />" class="form-control"
						name="age" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone No</label> <input type="text"
						value="<c:out value='${student.phone}' />" class="form-control"
						name="phone" required="required">
				</fieldset>

			<!-- 	<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${student.address}' />" class="form-control"
						name="address" required="required">
				</fieldset> -->
				
				<fieldset class="form-group">
					<label>Address</label> <textarea rows="5" cols="5" value="<c:out value='${student.address}' />" class="form-control"
						name="address" required="required"></textarea>
				</fieldset>
				

				<!--<fieldset class="form-group">
					<label>Gender</label> <input type="text"
						value="<c:out value='${student.gender}' />" class="form-control"
						name="gender" required="required">
				</fieldset>-->

				<fieldset class="form-group">
					<label>Gender</label> <select name="gender"
						value="<c:out value='${student.gender}' />" class="form-control">
						<option value=""></option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</fieldset>





				<!--<fieldset class="form-group">
					<label>Grade</label> <input type="text"
						value="<c:out value='${student.grade}' />" class="form-control"
						name="grade" required="required">
				</fieldset>-->

				<fieldset class="form-group">
					<label>Grade</label><select name="grade"
						value="<c:out value='${student.grade}' />" class="form-control">
						<option value=""></option>
						<option value="Grade 1">Grade 1</option>
						<option value="Grade 2">Grade 2</option>
						<option value="Grade 3">Grade 3</option>
						<option value="Grade 4">Grade 4</option>
						<option value="Grade 5">Grade 5</option>
						<option value="Grade 6">Grade 6</option>
						<option value="Grade 7">Grade 7</option>
						<option value="Grade 8">Grade 8</option>
						<option value="Grade 9">Grade 9</option>
						<option value="Grade 10">Grade 10</option>
						<option value="Grade 11">Grade 11</option>
						<option value="Grade 12">Grade 12</option>
                        </select>
                </fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="email"
						value="<c:out value='${student.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Admission Date</label> <input type="text"
						value="<c:out value='${student.admission}' />"
						class="form-control" name="admission" required="required">
				</fieldset>


				<button type="submit" class="btn btn-success" style="background-color: #0492c2">Save</button>
				</form>
				

     <div class="container text-left">

						<a href="LoginPage.jsp" class="btn btn-success">Logout</a>
					</div>
			</div>
		</div>
	</div>
	
	
	
<script type="text/javascript">

var status = document.getElementById("status").value;

if(status == "success"){
	swal("Registration Successful");
}
</script>	
	
	
	
	
</body>
</html>