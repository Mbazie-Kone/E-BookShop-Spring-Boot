document.addEventListener("DOMContentLoaded", function() {
	
	let usernameErrorDiv = document.getElementById("usernameError");
	if(usernameErrorDiv && !usernameErrorDiv.classList.contains("d-none")) {
		showDialog(usernameErrorDiv, "Error in Username field")
	}
	
})