<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Admission Form</title>

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
<body style="background-color:#0492c2;">
<h1 align="center" style="color:white">Students Admission Form</h1>


<form action="RegisterServlet" method="post" style="margin: auto; width: 350px;" >
<table>
<tbody style="color:white">
<tr><td>First Name:</td><td><input type="text" name="fname"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lname"></td></tr>
<tr><td>Date of Birth:</td><td><input type="text" name="dob"></td></tr>
<tr><td>Age:</td><td><input type="text" name="age"></td></tr>

<tr><td>Phone:</td><td><input type="text" name="phone"></td></tr>
<tr><td>Address:</td><td><textarea id="address" name="address" rows="4" cols="15">

</textarea></td></tr>
<tr><td>Gender:</td><td>
<select name="gender" >
  <option value=""></option>
  <option value="Male">Male</option>
  <option value="Female">Female</option>
</select></td></tr>


<tr><td>Grade:</td><td><select name="grade" >
  <option value=""></option>
  <option value=1>1</option>
  <option value=2>2</option>
  <option value=3>3</option>
  <option value=4>4</option>
  <option value=5>5</option>
  <option value=6>6</option>
  <option value=7>7</option>
  <option value=8>8</option>
  <option value=9>9</option>
  <option value=10>10</option>
  <option value=11>11</option>
  <option value=12>12</option>
  
</select></td></tr>


<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
<tr><td>Admission Date:</td><td><input type="text" name="admission"></td></tr>

<tr><td></td><td><input type="submit" value="Register" style="color:white;" id="button"></td></tr>
<!--  <tr><td></td><td><input type="submit" value="Logout" style="color:#0492c2;"></td></tr>-->
<!--<tr><td></td><td><a href="Home.jsp" style="color:#0492c2;"><button style="color:#0492c2;" id="button">Logout</button></a></td></tr>-->
</tbody>
</table>
</form>

<form action="Login.jsp" style="margin: auto; width: 350px;">
<table>
<tr><td></td><td><input type="submit" value="Logout" style="color:white;" id="button"></td></tr>
</table>

</form>

</body>
</html>