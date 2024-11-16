document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("signUpForm");
    const inputs = form.querySelectorAll("input");
	let formSubmitted = false; // Indicates whether the form has been submitted at least once
	
	// Add input and blur events to the form elements
    inputs.forEach(input => {
        input.addEventListener("input", function () {
			if(formSubmitted) {
				validateInput(input);
			}
        });

        input.addEventListener("blur", function () {
            validateInput(input);
        });
    });
	
	form.addEventListener("submit", function (event) {
		let isValid = true;
	    if (!form.checkValidity()) {
	        event.preventDefault(); // Block the submission of the form if it is invalid
			form.querySelector(":invalid").focus();
			isValid = false;
	    }
		
		const password = document.getElementById("reg_password").value;
		const confirmPassword = document.getElementById("confirmPassword").value;

		if (password !== confirmPassword) {
			event.preventDefault(); // Blocca l'invio se le password non corrispondono
		    document.getElementById("confirmPasswordError").textContent = "Passwords do not match.";
		    document.getElementById("confirmPassword").classList.add("is-invalid");
		    isValid = false;
		}else {
			document.getElementById("confirmPassword").classList.remove("is-invalid");
			document.getElementById("confirmPassword").classList.add("is-valid");
			document.getElementById("confirmPasswordError").textContent = "";
		}
		
		return isValid;
	});
});

function validateInput(input) {
	const errorElement = document.getElementById(`${input.id}Error`); // Error message exists
	if(input.validity.valid) {
		input.classList.remove("is-invalid");
		input.classList.add("is-valid");
		errorElement.textContent = ""; // Remove the error message
	}else {
		input.classList.remove("is-valid");
		input.classList.add("is-invalid");
		
		// Use server-side error message if present
		if(errorElement.textContent === "") {
			errorElement.textContent = "Invalid input"; // Generic fallback
		}
	}
}
