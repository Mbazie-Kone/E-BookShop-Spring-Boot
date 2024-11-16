document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("signUpForm");
    const inputs = form.querySelectorAll("input");

    inputs.forEach(input => {
        input.addEventListener("input", function () {
            validateInput(input);
        });

        input.addEventListener("blur", function () {
            validateInput(input);
        });
    });
	
	form.addEventListener("submit", function (event) {
	    if (!form.checkValidity()) {
	        event.preventDefault(); // Block the submission of the form if it is invalid
			isValid = false;
	    }
		
		const password = document.getElementById("reg_password").value;
		const confirmPassword = document.getElementById("confirmPassword").value;

		if (password !== confirmPassword) {
			event.preventDefault(); // Blocca l'invio se le password non corrispondono
		    document.getElementById("confirmPasswordError").textContent = "Passwords do not match.";
		    document.getElementById("confirmPassword").classList.add("is-invalid");
		    isValid = false;
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
