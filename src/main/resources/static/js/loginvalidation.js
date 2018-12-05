function checkForm(form) {
	if (form.login.value == "") {
		alert("Error: Login cannot be blank!");
		form.login.focus();
		return false;
	}
	re = /[a-zA-Z]+/;
	if (!re.test(form.login.value) || (form.login.value.length > 30)) {
		alert("Error: Login must contain only letters, numbers and underscores,and be less then 30 simbols!");
		form.login.focus();
		return false;
	}

	var emailIn = form.mail.value;
	if (emailIn == "") {
		alert("Error:Email cannot be blank!");
		form.email.focus();
		return false;
	}
	re = /^\w+@\w+\\.[a-z]{2,3}$/;
	if (!re.test(emailIn) || (emailIn.length > 30)) {
		alert("Error: Email doesn't match the pattern or it's too long. Email should contain less then 30 simbols!");
		form.email.focus();
		return false;
	}

	if ((form.password1.value != "")
			&& (form.password1.value == form.password2.value)) {
		if ((form.password1.value.length < 6)
				|| (form.password1.value.length > 30)) {
			alert("Error: Password must contain at least six characters and no more then 30!"
					+ emailIn);
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