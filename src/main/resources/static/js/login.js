document.addEventListener("DOMContentLoaded", function() {
	const registerModalElement = document.getElementById("registerModal");
	if(registerModalElement) {
		const showRegisterModal = registerModalElement.getAttribute("data-show");
		if (showRegisterModal === "true") {
			const modal = new bootstrap.Modal(registerModalElement);
			modal.show();
		}
	}

	const form = document.getElementById("registrationForm");
	if (form) {
	    const inputs = form.querySelectorAll("input");

	    inputs.forEach(input => {
	        input.addEventListener("input", () => validateInput(input));
	        input.addEventListener("blur", () => validateInput(input));
	    });
		
		}

	});

	function validateInput(input) {
	    const errorElement = document.getElementById(`${input.id}Error`);
	    if (!errorElement) {
	        console.warn(`No error element found for input: ${input.id}`);
	        return;
	    }

	    const errorMessage = input.dataset.errorMessage || "Invalid input";

	    if (input.validity.valid) {
	        input.classList.remove("is-invalid");
	        input.classList.add("is-valid");
	        errorElement.textContent = "";
	    } else {
	        input.classList.remove("is-valid");
	        input.classList.add("is-invalid");

	        if (input.validity.valueMissing) {
	            errorElement.textContent = errorMessage;
	        } else if (input.validity.typeMismatch) {
	            errorElement.textContent = "Invalid format";
	        } else if (input.validity.tooShort) {
	            errorElement.textContent = errorMessage;
	        }
	    }
	}