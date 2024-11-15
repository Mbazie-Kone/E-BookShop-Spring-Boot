// Use data-* attributes to pass data directly to HTML elements
document.addEventListener("DOMContentLoaded", function() {
	
	const appConfigElement = document.getElementById('appConfig');
	const hasErrors = appConfigElement.dataset.hasErrors === 'true'; // HTML data is always strings
	
	if(hasErrors) {
		const modal = new bootstrap.Modal(document.getElementById('registerModal'));
		modal.show();
	}
});