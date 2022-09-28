<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!DOCTYPE html>
		<html>
		<title>Student Management Application</title>
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		</head>
		<body>

		<!-- <header>
				<nav class="navbar navbar-expand-md navbar-dark"
					style="background-color: #0492c2">
					<div>
						<a href=student-list class="navbar-brand"> Student
							Management </a>
					</div>

					<ul class="navbar-nav">
						<li><a href="<%=request.getContextPath()%>/list"
							class="nav-link">Student List</a></li>
					</ul>
				</nav>
			</header> -->
			<br>

			<div class="row">
				<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

				<div class="container">
					<h3 class="text-center">List of Students</h3>
					<hr>
					
					<br>    
					
					<form action="" method="get">
					<input type="text" name="search" placeholder="Search here...">
					</form>
					
					<br><br><br>
					
					
					<table class="table table-bordered">
					
						
						
						
						<thead>
							<tr>
								<th>ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Date of Birth</th>
								<th>Age</th>
								<th>Phone</th>
								<th>Address</th>
								<th>Gender</th>
								<th>Grade</th>
								<th>Email</th>
								<th>Admission Date</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
					<%
						/*Statement stat=null;
						ResultSet res=null;
						stat=conn.createStatement();
						String query=request.getParameter("search");
						String data;
						if(query!=null){
							data="select*from school_db where name like'%"+query+"%' or email like'%"+query+"%' or phonelike'%"+query+"%' or addresslike'%"+query+"%' or gradelike'%"+query+"%' genderlike'%"+query+"%' or agelike'%"+query+"%'";
						}else{
							data="select*from school_db order by id desc";
						}
							res=stat.execteQuery(data);
						while(res.next()){*/
						
						
						%> 	
							<!--   for (Todo todo: todos) {  -->
							<c:forEach var="student" items="${listStudent}">

								<tr>
								<td><c:out value="${student.id}" /></td>
								<td><c:out value="${student.fname}" /></td>
							    <td><c:out value="${student.lname}" /></td>
						        <td><c:out value="${student.dob}" /></td>
					         	<td><c:out value="${student.age}" /></td>
								<td><c:out value="${student.phone}" /></td>
								<td><c:out value="${student.address}" /></td>
							    <td><c:out value="${student.gender}" /></td>
							    <td><c:out value="${student.grade}" /></td>
								<td><c:out value="${student.email}" /></td>
								<td><c:out value="${student.admission}" /></td>
									
									<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>
										&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
								</tr>
							</c:forEach>
							<!-- } -->
							
						</tbody>

					</table>
					<div class="container text-left">

						<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
							New Students</a>
					</div>
					<br>
					
					<div class="container text-left">

						<a href="LoginPage.jsp" class="btn btn-success">Logout</a>
					</div>
				</div>
			</div>
		</body>
		</html>


