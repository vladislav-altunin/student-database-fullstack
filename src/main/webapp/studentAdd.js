//Adds a student onclick

function addStudent() {

	var url = "http://localhost:8080/WebAppExercises/StudentAddServlet";

	var form = document.forms["formStudent"];
	var requestParameters =

		"studentId=" + form["txtId"].value +
		"&firstName=" + form["txtFname"].value +
		"&lastName=" + form["txtLname"].value +
		"&streetAddress=" + form["txtStreetaddress"].value +
		"&postCode=" + form["txtPostcode"].value +
		"&postOffice=" + form["txtPostoffice"].value;

	postDataToServer(url, requestParameters, processResponseStatus);

}

//Autofills the form
function autofillForm() {
	const form = document.forms["formStudent"];
	
	form["txtId"].value = "1234567890";
	form["txtFname"].value = "Paul";
	form["txtLname"].value = "Smith";
	form["txtStreetaddress"].value = "100 Oxford Street";
	form["txtPostcode"].value = "W1A 2NS";
	form["txtPostoffice"].value = "London";
}

function processResponseStatus(status) {

	if (status.errorCode === 0) {
		alert("Student data added!");
		location.replace("index.html");
	} else if (status.errorCode === 1) {
		alert("Cannot add the student. The id is already in use!");
		location.replace("studentAdd.html");
	} else if (status.errorCode === -1) {
		alert("Invalid ID format");
	} else {
		alert("Unknown error!");
	}
}