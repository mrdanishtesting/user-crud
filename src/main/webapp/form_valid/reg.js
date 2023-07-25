



function validate() {
	var email = document.myForm.email.value;
	var password = document.myForm.password.value;

	if (email === "" || !validateEmail(email)) {
		document.getElementById("email").classList.add("is-invalid");
		return false;
	} else {
		document.getElementById("email").classList.remove("is-invalid");
		document.getElementById("email").classList.add("is-valid");
	}

	if (password === "") {
		document.getElementById("password").classList.add("is-invalid");
		return false;
	} else {
		document.getElementById("password").classList.remove("is-invalid");
		document.getElementById("password").classList.add("is-valid");
	}

	return true;
}

function validateEmail(email) {
	var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return re.test(email);
}

