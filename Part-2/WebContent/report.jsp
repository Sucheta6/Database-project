<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>
<h1>Report</h1>
 <table class = "container" border="1" >
<tr>
<th>Sno</th>
<th>First Name</th>
<th>Last Name </th>
<th>SSN</th>
<th>Bdate</th>
<th>Address</th>
<th>Sex</th>
<th>Salary</th>
<th>Superssn</th>
<th>Email</th>
</tr>

<tr>
<td>1</td>
<td>${fnames}</td>
<td>${lnames}</td>
<td align="center">${ssns}</td>
<td align="center">${bdays}</td>
<td align="center">${address}</td>
<td align="center">${sex}</td>
<td align="center">${salaries}</td>
<td align="center">${superssns}</td>
<td align="center">${emails}</td>
</tr>

</table> 
</body>
</html>