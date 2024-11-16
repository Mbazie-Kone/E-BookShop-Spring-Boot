function validateInput(input) {
	const errorElement = document.getElementById(`${input.id}Error`); // Error message exists
	if(input.validity.valid) {
		input.classList.remove("is-invalid");
		input.classList.add("is-valid");
		errorElement.textContent = ""; // Remove the error message
	}else {
		input.classList.remove("is-valid");
		input.classList.add("is-invalid");
	}
	
	// Use server-side error message if present
	if(errorElement.textContent === "") {
		errorElement.textContent = "Invalid input"; // Generic fallback
	}
}