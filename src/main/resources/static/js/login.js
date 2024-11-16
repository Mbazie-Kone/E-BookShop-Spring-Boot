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
			if(formSubmitted) {
				validateInput(input);
			}
        });
    });
	
	// Submit management
	form.addEventListener("submit", function (event) {
		formSubmitted = true; // The form has now been submitted
		let isValid = true;
		
		// General validity check
	    if (!form.checkValidity()) {
	        event.preventDefault(); // Block the submission of the form if it is invalid
			form.querySelector(":invalid").focus();
			isValid = false;
	    }
		
		// Check that the passwords match and confirm password is not empty
		const password = document.getElementById("reg_password").value;
		const confirmPassword = document.getElementById("confirmPassword").value;
		
		if(!confirmPassword) {
			event.preventDefault();
			document.getElementById("confirmPasswordError").textContent = "Confirm Password cannot be empty.";
			document.getElementById("confirmPassword").classList.add("is-invalid");
			isValid = false;
		}else if (password !== confirmPassword) {
			event.preventDefault();
		    document.getElementById("confirmPasswordError").textContent = "Passwords do not match.";
		    document.getElementById("confirmPassword").classList.add("is-invalid");
		    isValid = false;
		}else {
			document.getElementById("confirmPassword").classList.remove("is-invalid");
			document.getElementById("confirmPassword").classList.add("is-valid");
			document.getElementById("confirmPasswordError").textContent = "";
		}
		
		// Perform visual validation for each field
		inputs.forEach(input => validateInput(input));
		
		return isValid;
	});
});

// Function to validate a single input
function validateInput(input) {
	const errorElement = document.getElementById(`${input.id}Error`); // Error message exists
	
	// Preserve server-side error messages if present
	if(input.validity.valid) {
		input.classList.remove("is-invalid");
		input.classList.add("is-valid");
		if(errorElement && !errorElement.getAttribute("data-server-error")) {
			errorElement.textContent = ""; // Remove client-side error message
		}
	}else {
		input.classList.remove("is-valid");
		input.classList.add("is-invalid");
		
		// Fallback to generic error message only if server-side message is not present
		if(errorElement && errorElement.textContent.trim() === "") {
			errorElement.textContent = "Invalid input"; // Generic fallback
		}
	}
}
