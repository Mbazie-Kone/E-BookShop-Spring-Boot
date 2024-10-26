document.addEventListener('DOMContentLoaded', function() {
	const modalBtn = document.getElementById('modalBtn');
	const registrationModal = new bootstrap.Modal(document.getElementById('registrationModal'));
	
	modalBtn.addEventListener('click', function(){
		registrationModal.show();
	});
});