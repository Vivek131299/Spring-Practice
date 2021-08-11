<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Above is the taglib reference for JSTL so that we can
 use JSTL Tags (like FOR EACH TAG) in this file. -->

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

<br><br>

<!-- For displaying operatingSystems, there may be more than one Operating Systems user has 
selected. So to display multiple Operating Systems, we need to loop over the array 'operatingSystems'
and print out the information in it.
So for this, we need to make use of JSTL TAGS, the core tags, that will give
 us FOR EACH TAG for looping over a collection/array. 
We have Imported that JSTL Library at the start of this file. (See line 1). -->
Operating Systems:

<!-- We are making use of bullet list (unordered list) to display multiple Operating Syatems. -->
<ul>
	<!-- LOOPING OVER AN ARRAY AND DISPLAYING VALUES IN IT -->
	<c:forEach var="temp" items="${student.operatingSystems}" >
	
		<li> ${temp} </li>
	
	</c:forEach>
</ul>
<!-- Above, we are using JSTL forEach tag code for looping.
	 "temp" is the variable name. 
	 And items="${student.operatingSystems}" will call student.getOperatingSystems() method.
	 Then it will loop through that while current value is stored in 'temp' variable for each 
	 iteration of loop.
	 And then inside this loop we are accessing that current value stored in 'temp' variable
	 by ${temp}. -->

</body>

</html>