<!DOCTYPE html>
<html>

<head>

<!-- We need to use the JSP expression ${pageContext.request.contextPath} to access 
the correct root directory of static resources (like css, images, js) for our web application. -->
<link rel="stylesheet" type="text/css" 
	  href="${pageContext.request.contextPath}/resources/css/my-test.css">
	  
<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>

</head>

<body>

<h2>Spring MVC Demo - Home Page</h2>

<hr>

<!-- Setting up a link to our helloworld-form.jsp so that we need to to go manually 
to that form by typing in /showForm in url. -->

<a href="hello/showForm">Hello World form</a>

<!-- So, when we click this link 'Hello World form' then it will go to 'showForm' and
'showForm' is the actual Request Mapping in our HelloWorldController. -->

<!-- Later we are changing the href link from /showForm to hello/showForm because we have implemented 
Controller Level Request Mapping in our HelloWorldController. (See HelloWorldController from line 14). -->

<br><br>

<a href="student/showForm">Student form</a>

<br><br>

<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" />

<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me" />
<!-- This will call doSomething() function from simple-test.js file -->

</body>

</html>