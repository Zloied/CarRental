function checkForm(form) {
			if (form.login.value == "") {
				alert("Error: Login cannot be blank!");
				form.login.focus();
				return false;
			}
			re = /^\w+$/;
			if (!re.test(form.login.value)) {
				alert("Error: Login must contain only letters, numbers and underscores!");
				form.login.focus();
				return false;
			}
			re = /[a-zA-Z]/;
			if (!re.test(form.login.value)) {
				alert("Error: login must contain at least one letter (a-z,A-Z)!");
				form.passw.focus();
				return false;
			}

			if (form.passw.value != "") {
				if ((form.passw.value.length < 6)||(form.passw.value.length > 30)) {
					alert("Error: Password must contain at least six characters!");
					form.passw.focus();
					return false;
				}
				if (form.passw.value == form.login.value) {
					alert("Error: Password must be different from Login!");
					form.passw.focus();
					return false;
				}
				re = /[0-9]/;
				if (!re.test(form.passw.value)) {
					alert("Error: password must contain at least one number (0-9)!");
					form.passw.focus();
					return false;
				}
				re = /[a-zA-Z]/;
				if (!re.test(form.passw.value)) {
					alert("Error: password must contain at least one letter (a-z,A-Z)!");
					form.passw.focus();
					return false;
				}
			} else {
				alert("Error: Please check that you've entered !");
				form.passw.focus();
				return false;
			}

			return true;
		}