<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<!-- So above, ${student.firstName} calls student.getFirstName() method and 
	 ${student.lastName} calls student.getLastName() method. -->
	 
<br><br>

Country: ${student.country}
<!-- Similarly above, for ${student.country}, Spring will call student.getCountry() method. -->

<br><br>

Favorite Language: ${student.favoriteLanguage}
<!-- Similarly, here Spring will call student.getFavoritelanguage() method. -->

</body>

</html>