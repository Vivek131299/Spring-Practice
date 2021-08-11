<!DOCTYPE html>
<html>

<head>
<title>Hello World - Input Form</title>
</head>

<body>

<form action="processFormVersionThree" method="GET"> <!-- action="processForm" means we are going to send something
 over to the path /processForm. So we have to add a Request Mapping for /processForm in our HelloWorldController 
 to handle this request whenever we click submit button.
 And actual method type will be GET, so it is going to pass it as a 
 GET request (opposite to POST request). -->
 
 <!-- We are later changing action of form from 'processForm' to 'processFormVersionTwo' 
 because we have later implemented the model and added attribute in it to store the value. -->
 
 <!-- We are later changing action of form from 'processFormVersionTwo' to 'processFormVersionThree' 
 because we have later implemented Binding Request Params using @RequestParam Annotation in 
 our HelloWorldController class. -->
 

<input type="text" name="studentName" placeholder="What's your name?" />

<input type="submit" />

</form>

</body>

</html>