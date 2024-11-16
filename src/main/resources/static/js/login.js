document.addEventListener("DOMContentLoaded", function() {
	const showRegisterModal = document.getElementById("registerModal").getAttribute("data-show");
	if (showRegisterModal === "true") {
		const modal = new bootstrap.Modal(document.getElementById("registerModal"));
		modal.show();
	}

	const form = document.getElementById("registrationForm");
	const inputs = form.querySelectorAll("input");

	inputs.forEach(input => {
		// Ascolta l'evento 'input' per validare in tempo reale
		input.addEventListener("input", function() {
			validateInput(input);
		});

		// Ascolta l'evento 'blur' per validare al termine dell'interazione
		input.addEventListener("blur", function() {
			validateInput(input);
		});
	});
});

function validateInput(input) {
	const errorMessage = input.dataset.errorMessage; // Messaggio di errore personalizzato
	const errorElement = document.getElementById(`${input.id}Error`); // Elemento di errore associato

	// Controlla se il campo è valido
	if (input.validity.valid) {
		// Campo valido
		input.classList.remove("is-invalid");
		input.classList.add("is-valid");
		errorElement.textContent = ""; // Rimuovi messaggi di errore
	} else {
		// Campo non valido
		input.classList.remove("is-valid");
		input.classList.add("is-invalid");

		// Mostra un messaggio di errore generico o specifico
		if (input.validity.valueMissing) {
			errorElement.textContent = errorMessage;
		} else if (input.validity.typeMismatch) {
			errorElement.textContent = "Invalid format";
		} else if (input.validity.tooShort) {
			errorElement.textContent = errorMessage;
		}
	}
}