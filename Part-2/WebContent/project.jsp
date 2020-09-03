<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
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
<h2>Record Inserted!</h2>
<h1>Add Projects</h1>
<form method="post" action="projectassign">
<label>Project Name</label><br/>
<%String ssnid=(String)request.getAttribute("ssnid");%>

<input type="checkbox" id="myCheck1" name="myCheck1"  onclick="sdf()"> ProductX 
 <input type="text" id="text1" name="text1" maxlength="2" placeholder="Assigning Hours"  style="display:none"/> 
</br>
<input type="checkbox" id="myCheck2"  name="myCheck2" onclick="sdf()">ProductY
 <input type="text" id="text2" name="text2"  maxlength="2"  placeholder="Assigning Hours"  style="display:none"/>
</br>
 <input type="checkbox" id="myCheck3" name="myCheck3" onclick="sdf()"> ProductZ
 <input type="text" id="text3"  name="text3" maxlength="2"  placeholder="Assigning Hours"  style="display:none"/>
 </br>
<input type="checkbox" id="myCheck4"  name="myCheck4" onclick="sdf()"> Computerization
 <input type="text" id="text4"  name="text4" maxlength="2"  placeholder="Assigning Hours"  style="display:none"/>
 </br>
 <input type="checkbox" id="myCheck5" name="myCheck5" onclick="sdf()">Reorganization
 <input type="text" id="text5"  name="text5" maxlength="2"  placeholder="Assigning Hours" style="display:none"/>
</br>
 <input type="checkbox" id="myCheck6" name="myCheck6"  onclick="sdf()"> Newbenefits
 <input type="text" id="text6" name="text6" maxlength="2"  placeholder="Assigning Hours"  style="display:none"/>
</br>
 <input type="text" name="ssnid"  maxlength="2"  placeholder="Assigning Hours" value=${ssnid}   style="display:none"/>

<h2>Are there any dependents?</h2>
<input type="checkbox"  name="dependents" value="yes">
<label for="2">Yes</label> <br>
<input type="checkbox"  name="dependents" value="no">
<label for="2">No</label><br>

<script>
document.getElementById("ssnid").value = ssnid;
function sdf() {
	  var checkBox1 = document.getElementById("myCheck1");
	  var checkBox2 = document.getElementById("myCheck2");
	  var checkBox3 = document.getElementById("myCheck3");
	  var checkBox4 = document.getElementById("myCheck4");
	  var checkBox5 = document.getElementById("myCheck5");
	  var checkBox6 = document.getElementById("myCheck6");

	  var text1 = document.getElementById("text1");
	  var text2 = document.getElementById("text2");
	  var text3 = document.getElementById("text3");
	  var text4 = document.getElementById("text4");
	  var text5 = document.getElementById("text5");
	  var text6 = document.getElementById("text6");
	  
	  
	  if (checkBox1.checked == true){
	    text1.style.display = "block";
	  } else {
	     text1.style.display = "none";
	  }
	  if (checkBox2.checked == true){
	    text2.style.display = "block";
	  } else {
	     text2.style.display = "none";
	  }
	  if (checkBox3.checked == true){
	    text3.style.display = "block";
	  } else {
	     text3.style.display = "none";
	  }
	  if (checkBox4.checked == true){
	    text4.style.display = "block";
	  } else {
	     text4.style.display = "none";
	  }if (checkBox5.checked == true){
	    text5.style.display = "block";
	  } else {
	     text5.style.display = "none";
	  }
	  if (checkBox6.checked == true){
	    text6.style.display = "block";
	  } else {
	     text6.style.display = "none";
	  }
	  
	}
	
</script>
</br>
 &nbsp <input type="submit" value="Submit"  />
   </form>
  
  </body>
</html>