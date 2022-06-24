// "Add student", "Update", "Delete" links and their functionality 

// "Update" & "Delete" links itself and their functionality
function createUpdateDeleteLinks(student) {
	return "<div class='crud-icons-container'>" + 
					"<div class='crud-icon-edit'>" +
						"<span class='links' onclick='redirectToUpdate(" + student.id + ");' onmouseover='' style='cursor: pointer;'>" + 
							"<img alt='linkedin-link' src='./images/icons/icon_edit.png'>" + "</span>" + 
					"</div>" +
					"<div class='crud-icon-delete'>" +
						"<span class='links' onclick='deleteStudent(" + student.id + ");' onmouseover='' style='cursor: pointer;'>" +
							"<img alt='linkedin-link' src='./images/icons/icon_delete.png'>" + "</span>" +
					"</div>" +
			"</div>";
}

//"Update" redirection
function redirectToUpdate(studentId) {
	location.replace("studentUpdate.html?txtId=" + studentId);
}

//"Add student" redirection
function redirectToAddStudent() {
	location.replace("studentAdd.html");
}