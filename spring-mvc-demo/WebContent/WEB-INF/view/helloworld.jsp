<!DOCTYPE html>
<html>

<body>

Hello World of Spring!

<br><br>

Student name: ${param.studentName}

<!-- Above, We are reading the form data.
We are reading it through JSP Expression Language like: ${param.HTML_form_field_name} 
So, in our case it becomes: ${param.studentName} because 'studentName' is the actual name
of the HTML Form Field of the <input> tag in form in our helloworld-form.jsp file.-->

</body>

</html>