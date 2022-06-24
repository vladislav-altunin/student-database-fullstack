// GET REQUEST (Retrieves Student data after redirection ("Update") from the main page) 
function printUpdateStudentForm(student) {

	let form = document.forms["formStudentUpdate"];

	form["txtId"].disabled = true;
	form["txtId"].value = student.id;
	form["txtFname"].value = student.firstname;
	form["txtLname"].value = student.lastname;
	form["txtStreetaddress"].value = student.streetaddress;
	form["txtPostcode"].value = student.postcode;
	form["txtPostoffice"].value = student.postoffice;

}

function retrieveStudentData() {
	const parameter = window.location.search;
	const url = "http://localhost:8080/WebAppExercises/StudentUpdateServlet" + parameter;

	getDataFromServer(url, printUpdateStudentForm);

}

retrieveStudentData();

// POST REQUEST ("Update" button)
function updateStudent() {

	const form = document.forms["formStudentUpdate"];

	const id = "txtId=" + form["txtId"].value;
	const fName = "txtFname=" + form["txtFname"].value;
	const lName = "txtLname=" + form["txtLname"].value;
	const sAddress = "txtStreetaddress=" + form["txtStreetaddress"].value;
	const pCode = "txtPostcode=" + form["txtPostcode"].value;
	const pOffice = "txtPostoffice=" + form["txtPostoffice"].value;
	
	const url = "http://localhost:8080/WebAppExercises/StudentUpdateServlet";
	const parameters = 
	 
		id + "&" + fName + "&" + lName + "&" + sAddress + "&" + 
		pCode + "&" + pOffice;
	
	postDataToServer(url, parameters, processResponseStatus);
	
}

function processResponseStatus(status) {

	if (status.errorCode === 0) {
		location.replace("index.html");
		alert("Student data updated!");
	} else if (status.errorCode === 1) {
		alert("Student data has not been updated! All fields are mandatory!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.");
	}
}




