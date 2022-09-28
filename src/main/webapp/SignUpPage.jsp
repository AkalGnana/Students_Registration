<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Form</title>

<style>
#button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>


</head>
<body style="background-color: #0492c2;">
	<h1 align="center" style="color: white">SignUp Form</h1>


	<form action=RegisterServlet method="post"
		style="margin: auto; width: 350px;">
		<table>
			<tbody style="color: white">
				<tr>
					<td>Full Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td>Re-Password:</td>
					<td><input type="text" name="repassword"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Register"
						style="color: white;" id="button"></td>
				</tr>

			</tbody>
		</table>
	</form>

	<form action="Login.jsp" style="margin: auto; width: 350px;">
		<table>
			<tr>
				<td></td>
				<td><input type="submit" value="Logout" style="color: white;"
					id="button"></td>
			</tr>
		</table>

	</form>
	<div class="container text-left">

						<a href="LoginPage.jsp" class="btn btn-success">Logout</a>
					</div>

</body>
</html>