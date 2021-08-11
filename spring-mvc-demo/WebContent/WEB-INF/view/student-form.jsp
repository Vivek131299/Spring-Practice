<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Above is the taglib reference so that we can use Spring MVC Form Tags in this file. -->

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

<!-- Below is Spring MVC Form Tag -->
<form:form action="processForm" modelAttribute="student"> 
<!-- Above, Model Attribute 'student' is the same name of model attribute from our StudentController. -->

	First name: <form:input path="firstName" />
	<!-- Above, Path 'firstName' is the Property of Student class because we have getter ans setter 
	methods for firstName. -->
	
	<br><br>
	
	Last name: <form:input path="lastName" />
	
	<br><br>
	
	<!-- When the Form is LOADED, Spring MVC will call the Getter Methods.
		 So here, getFirstName() and getLastName() methods will get called. -->
	
	<input type="submit" value="Submit" />
	
	<!-- And when we SUBMIT the Form, Spring MVC will call the Setter Methods.
		 So here, setFirstName() and setLastName() methods will get called. -->

</form:form>

</body>

</html>