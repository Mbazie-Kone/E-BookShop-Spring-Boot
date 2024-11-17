document.addEventListener("DOMContentLoaded", function() {
	const showRegisterModal = document.getElementById("registerModal").getAttribute("data-show");
	if (showRegisterModal === "true") {
		const modal = new bootstrap.Modal(document.getElementById("registerModal"));
		modal.show();
	}

	const modalElement = document.getElementById("registerModal");
	const registrationForm = document.getElementById("signUpForm");

	// Evento per il pulsante di chiusura del Modal
	modalElement.addEventListener("hidden.bs.modal", function() {
		// Resetta il form
		registrationForm.reset();

		// Nasconde gli errori di validazione
		const errorElements = modalElement.querySelectorAll(".text-danger");
		errorElements.forEach(errorElement => {
			errorElement.textContent = ""; // Rimuove il contenuto degli errori
		});

		// Rimuove le classi di errore dai campi (opzionale)
		const inputElements = registrationForm.querySelectorAll(".form-control");
		inputElements.forEach(inputElement => {
			inputElement.classList.remove("is-invalid");
		});
	});
});