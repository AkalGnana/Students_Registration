<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: ">
			<div>
				<a href=LoginPage class="navbar-brand" style="font: x-large;">
					<!-- Admin Login--> </a>
			</div>
		</nav>
	</header>
	<br>
	
	
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
	<h1>login</h1>
	<form action=LoginSevlet method=post>
	
	
  <!-- Email input -->
  <div class="form-outline mb-4">
    <input type="text" name="uname" id="form2Example1" class="form-control" />
    <label class="form-label" for="form2Example1" >User Name</label>
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <input type="password" name="password" id="form2Example2" class="form-control" />
    <label class="form-label" for="form2Example2" >Password</label>
  </div>

  <!-- 2 column grid layout for inline styling -->
  <div class="row mb-4">
    <div class="col d-flex justify-content-center">
      <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> Remember me </label>
      </div>
    </div>

    <div class="col">
      <!-- Simple link -->
      <a href="#!">Forgot password?</a>
    </div>
  </div>

  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

  <!-- Register buttons -->
  <div class="text-center">
      <p>Not a member? <a href="SignUpPage.jsp">Register</a></p>
    <!--  <p>or sign up with:</p>-->
    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-facebook-f"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-google"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-twitter"></i>
    </button>

    <button type="button" class="btn btn-link btn-floating mx-1">
      <i class="fab fa-github"></i>
    </button>
  </div>

	
<!-- 	<fieldset class="form-group">
					<label>User Name</label> <input type="text" class="form-control"
						name="uname" required="required">
				</fieldset>
				
				<fieldset class="form-group">
				<label>Password</label> <input type="password" class="form-control"
						name="password" required="required">
				</fieldset>
				
				<input type="reset" id="button" class="btn btn-success" style="background-color: pink">
				<button type="submit" class="btn btn-success" style="background-color: pink">Login</button>
	
	-->
		<!--  <table>
			<tbody>
				<tr>
				
					<td>User Name:</td>
					<td><input type="text" name="uname"></td>
				
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td><input type="reset" id="button"></td>
					<td><input type="submit" value="Login" id="button"></td>
				</tr>
			</tbody>
		</table>-->
	</form>
	
			</div>
		</div>
	</div>
</body>
</html>





