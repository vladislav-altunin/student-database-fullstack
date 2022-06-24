// Ajax helper

// GET
function getDataFromServer(url, cbf) {

	fetch(url)
		.then(response => {
			if (response.ok) {
				console.log("The response is ok!");
				return response.json();
			} else {
				console.log("The response is NOT ok!");
				throw "HTTP status code is " + response.status;
			}
		})
		.then(response => cbf(response)) // response is a student list
		.catch(errorText => alert("getDataFromServer failed: " + errorText));

}

//POST
function postDataToServer(url, requestParameters, cbf) {

	var requestOptions = {
		method: "POST",
		headers: { "Content-Type": "application/x-www-form-urlencoded" },
		body: requestParameters
	};

	fetch(url, requestOptions)
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw "HTTP status code is " + response.status;
			}
		})
		.then(response => cbf(response)) //response is a status
		.catch(errorText => alert("postDataToServer failed: " + errorText));
}