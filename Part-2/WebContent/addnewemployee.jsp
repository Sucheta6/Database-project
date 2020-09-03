<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD EMPLOYEE</title>
<style>
label
{
display:inline-block;
width:100px;
margin-bottom:10px;
}
</style>
</head>
<body>
<h1>Add Employee</h1>
<form method="post" action="InsertionEmployee">
<label>First Name:</label>
<input type="text" name="fname"/><br/>
<label>Middle Name:</label>
<input type="text" name="minit"/><br/>
<label>Last Name:</label>
<input type="text" name="lname"/><br/>
<label>SSN:</label>
 <input type="text" maxlength="9" minlength="9" id="SSN" name="SSN" /></br></br>
<label>BDATE:</label>
<input type="date" name="bdate"/><br/>
<label>Address:</label>
<input type="text" name="address"/><br/>
<label>Sex</label><br/>
<input type="radio" id="male" name="gender" value="male">
  <label for="male">Male</label><br/>
  <input type="radio" id="female" name="gender" value="female">
  <label for="female">Female</label><br/>
  <input type="radio" id="other" name="gender" value="other">
  <label for="other">Other</label><br/>
<label>Salary:</label>
<input type="number" name="sal" size="10"/><br/>
<label>SuperSSN:</label>
<input type="number" name="super_ssn" size="10"/><br/>
<label>DNO:</label>
<input type="number" name="dno" size="4"/><br/>
<label>Email:</label>
<input type="email" name="email"/><br/>
<input type="submit" value="Add Employee"/>
</form>
</body>
</html>
