<!DOCTYPE html>
<html>

<head>
<title>Hello World - Input Form</title>
</head>

<body>

<form action="processForm" method="GET"> <!-- action="processForm" means we are going to send something
 over to the path /processForm. So we have to add a Request Mapping for /processForm in our HelloWorldController 
 to handle this request whenever we click submit button.
 And actual method type will be GET, so it is going to pass it as a 
 GET request (opposite to POST request). -->

<input type="text" name="studentName" placeholder="What's your name?" />

<input type="submit" />

</form>

</body>

</html>