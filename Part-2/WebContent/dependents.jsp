<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dependents</title>
<style>
label
{
display:inline-block;
width:150px;
margin-bottom:10px;
}
</style>
</head>
<body>
<h1>Add Dependents</h1>
<form method="post" action="dependents">
<input type="text" name="essn" size="10" value=${ssnid} style="display:none"/><br/>
<label>Dependent_Name:</label>
<input type="text" name="dependent_name"/><br/>
<label>Sex</label><br/>
<input type="radio" id="male" name="gender" value="male">
  <label for="male">Male</label><br/>
  <input type="radio" id="female" name="gender" value="female">
  <label for="female">Female</label><br/>
  <input type="radio" id="other" name="gender" value="other">
  <label for="other">Other</label><br/>
  <label>BDATE:</label>
  <input type="date" name="bdate"/><br/>
  <label>Relationship:</label>
  <input type="text" name="relationship"/><br/>
     &nbsp <input type="submit" value="Submit"  />
  </body>
</html>