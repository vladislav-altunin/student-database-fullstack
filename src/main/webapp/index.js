function printStudents(studentList) {
	
	//First, print table header
	// "<a href='#' onclick='redirectToAddStudent()' id='add-student-small-button'>" + "Add student" + "</a>"
	let tableHeader =

		"<div class='table-header' id='tableHeader'>" +
		"<div class='header-cell small-cell'>" + "<p>" + "ID" + "</p>" + "</div>" +
		"<div class='header-cell medium-cell'>" + "<p>" + "LAST NAME" + "</p>" + "</div>" +
		"<div class='header-cell medium-cell'>" + "<p>" + "FIRST NAME" + "</p>" + "</div>" +
		"<div class='header-cell large-cell'>" + "<p>" + "STREET ADDRESS" + "</p>" + "</div>" +
		"<div class='header-cell small-cell'>" + "<p>" + "POSTCODE" + "</p>" + "</div>" +
		"<div class='header-cell medium-cell'>" + "<p>" + "CITY" + "</p>" + "</div>" +
		"<div class='header-cell medium-cell' id='small-button-container'>" + "<p>" + "<a href='#' onclick='redirectToAddStudent()' id='add-student-small-button'>" + "Add student" + "</a>" + "</p>" + "</div>" +
		"</div>";
		
		document.getElementById("table-header-container").innerHTML = tableHeader;
	
	//Then, table rows 
	for (student of studentList) {

		document.getElementById("table").innerHTML +=
			"<div class='table-row'>" +
			"<div class='table-cell small-cell'>" + "<p>" + "<td name='tableTxtId'>" + student.id + "</td>" + "</p>" + "</div>" +
			"<div class='table-cell medium-cell'>" + "<p>" + "<td>" + student.lastname + "</td>" + "</p>" + "</div>" +
			"<div class='table-cell medium-cell'>" + "<p>" + "<td>" + student.firstname + "</td>" + "</p>" + "</div>" +
			"<div class='table-cell large-cell'>" + "<p>" + "<td>" + student.streetaddress + "</td>" + "</p>" + "</div>" +
			"<div class='table-cell small-cell'>" + "<p>" + "<td>" + student.postcode + "</td>" + "</p>" + "</div>" +
			"<div class='table-cell medium-cell'>" + "<p>" + "<td>" + student.postoffice + "</td>" + "</p>" + "</div>" +
			"<div class='table-cell medium-cell' id='crud-cell'>" + "<p>" + "<td>" + createUpdateDeleteLinks(student) + "</td>" + "</p>" + "</div>" +
			"</div>";
	}

	// If there are no students in the database, add CTA "Add student(s)"
	const tableContent = document.getElementsByClassName("table-row").length;
	if (tableContent <= 0) {
		//But first, hide the table's heading h2, header-container and table-container
		document.getElementById("table-header-container").className = "no-table-container";
		document.getElementById("table-heading").className = "no-table-container";
		document.getElementById("table-container").className = "no-table-container";
		//And, finally, render CTA
		printHomePage();
		
	} else {
		//Otherwise, hide CTA
		document.getElementById("empty-page-container").className = "no-table-container";
		
		//And apply styles to the table
		const elements = document.getElementsByClassName("table-row");
		const newClassName = "second-table-row";
		changeTableStyles(elements, newClassName);
	}
};

//Prints starting / home page, if there are no students in the database yet
function printHomePage() {
	const pageHeader = "<h3>" + "The database is empty" + "</h3>";
	document.getElementById("empty-page-container").innerHTML = pageHeader +
		"\n" + "<div class='add-student-big-button'>" + "<a href='#' onclick='redirectToAddStudent()' id='addStudentButton'>" + "ADD STUDENT" + "</a>" + "</div>";
};

//Changes styles of the student table so that every other row would have a different colour
function changeTableStyles(htmlCollection, newClassName) {

	const isInteger = Number.isInteger(htmlCollection.length / 2);
	let index = 1;

	if (isInteger == false) {

		while (htmlCollection.length > 0) {
			
			//handles cases when the length is less than index 
			try {
				htmlCollection[index].className = newClassName;
				index++;
			} catch (err) {
				return true;
			}

		}

	} else {

		while (htmlCollection.length > 0) {
			
			//handles cases when the length is less than index
			try {
				htmlCollection[index].className = newClassName;
				index++;
			} catch (err) {
				return true;
			}
		}

	}
};


getDataFromServer("http://localhost:8080/WebAppExercises/StudentListServlet", printStudents);

