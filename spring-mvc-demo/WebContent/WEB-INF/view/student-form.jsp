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
	<!-- Above, Path 'firstName' is the Property of Student class because we have getter and setter 
	methods for firstName. -->
	
	<br><br>
	
	Last name: <form:input path="lastName" />
	
	<br><br>
	
	Country:
	
	<!-- Below is the Spring MVC Select Tag for displaying Drop Down List-->
	<form:select path="country">
	<!-- When we submit, Spring MVC is going to call student.setCountry() method from Student class. -->
	
	<!--<form:option value="Brazil" label="Brazil" />
		<form:option value="France" label="France" />
		<form:option value="Germany" label="Germany" />
		<form:option value="India" label="India" /> -->	
		
	<!-- Above, 'label' is the text which will be displayed on the screen and 
	     'value' is the actual code that we are passing to the model when we submit the form. -->
	     
	<!-- Commenting above form options because now we are Reading Countries form Java class (Student.java)
	instead of hard coding them here. So now we do like:-->
	
	<form:options items="${student.countryOptions}" />
	
	<!-- NOTICE above that we have 'options' and NOT 'option' as before.
		 'items' refer to the collection of data and '${student.countryOptions}' will
		 call student.getCountryOptions() method. So this method will return a LinkedHashMap
		 of countries and that will be displayed as options. -->
	
	
	</form:select>
	
	<br><br>
	
	<!-- When the Form is LOADED, Spring MVC will call the Getter Methods.
		 So here, getFirstName() and getLastName() methods will get called. -->
	
	<input type="submit" value="Submit" />
	
	<!-- And when we SUBMIT the Form, Spring MVC will call the Setter Methods.
		 So here, setFirstName() and setLastName() methods will get called. -->

</form:form>

</body>

</html>