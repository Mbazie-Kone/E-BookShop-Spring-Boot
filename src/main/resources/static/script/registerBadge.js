document.addEventListener("DOMContentLoaded", function() {
	
	let usernameErrorDiv = document.getElementById("usernameError");
	if(usernameErrorDiv && !usernameErrorDiv.classList.contains("d-none")) {
		showDialog(usernameErrorDiv, "Error in username field")
	}
	
	let passwordErrorDiv = document.getElementById("passwordError");
		if(passwordErrorDiv && !passwordErrorDiv.classList.contains("d-none")) {
			showDialog(passwordErrorDiv, "Error in password field")
	}
	
})