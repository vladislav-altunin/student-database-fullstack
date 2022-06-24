//Deletes student onclick

function deleteStudent(studentId) {

	var isConfirmed = confirm("Delete student " + studentId + "?");

	if (isConfirmed) {
		var url = "http://localhost:8080/WebAppExercises/StudentDeleteServlet";
		var requestParameters = "studentId="+studentId;

		postDataToServer(url, requestParameters, processResponseStatus);
	}


}

function processResponseStatus(status) {

	if (status.errorCode === 0) {
		location.replace("index.html");
		alert("Student data deleted!");
	} else if (status.errorCode === 1) {
		alert("Student data not deleted. Unknown student id!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.");
	}
}