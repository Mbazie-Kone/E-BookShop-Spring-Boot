document.addEventListener("DOMContentLoaded", function() {
	const showRegisterModal = document.getElementById("registerModal").getAttribute("data-show");
	if(showRegisterModal === "true") {
		const modal = new bootstrap.Modal(document.getElementById("registerModal"));
		modal.show();
	}
})