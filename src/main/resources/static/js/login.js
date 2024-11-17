document.addEventListener("DOMContentLoaded", function() {
	const showRegisterModal = document.getElementById("registerModal").getAttribute("data-show");
	if (showRegisterModal === "true") {
		const modal = new bootstrap.Modal(document.getElementById("registerModal"));
		modal.show();
	}

	const modalElement = document.getElementById("registerModal");
	const registrationForm = document.getElementById("signUpForm");

	// Event for the Modal close button
	modalElement.addEventListener("hidden.bs.modal", function() {
		// Reset the form
		registrationForm.reset();

		// Hides validation errors
		const errorElements = modalElement.querySelectorAll(".text-danger");
		errorElements.forEach(errorElement => {
			errorElement.textContent = ""; // Removes error content
		});

		// Remove error classes from fields (optional)
		const inputElements = registrationForm.querySelectorAll(".form-control");
		inputElements.forEach(inputElement => {
			inputElement.classList.remove("is-invalid");
		});
	});
});