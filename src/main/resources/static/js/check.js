function checkForm(form) {
	if (form.login.value == "") {
		alert("Error: Login cannot be blank!");
		form.login.focus();
		return false;
	}
	re = /^\w+$/;
	if (!re.test(form.login.value) || (form.login.value.length > 30)) {
		alert("Error: Login must contain only letters, numbers and underscores,and be less then 30 simbols!");
		form.login.focus();
		return false;
	}

	re = /[a-zA-Z]/;
	if (!re.test(form.login.value)) {
		alert("Error: login must contain at least one letter (a-z,A-Z)!");
		form.passw.focus();
		return false;
	}
	

	if ((form.password1.value != "")
			&& (form.password1.value == form.password2.value)) {
		if ((form.password1.value.length < 6)
				|| (form.password1.value.length > 30)) {
			alert("Error: Password must contain at least six characters and no more then 30!");
			form.password1.focus();
			return false;
		}
		if (form.password1.value == form.login.value) {
			alert("Error: Password must be different from Login!");
			form.password1.focus();
			return false;
		}
		re = /[0-9]/;
		if (!re.test(form.password1.value)) {
			alert("Error: password must contain at least one number (0-9)!");
			form.password1.focus();
			return false;
		}
		re = /[a-zA-Z]/;
		if (!re.test(form.password1.value)) {
			alert("Error: password must contain at least one letter (a-z,A-Z)!");
			form.password1.focus();
			return false;
		}
	} else {
		alert("Error: Please check that you've entered and confirmed your password!");
		form.password1.focus();
		return false;
	}

	return true;
}