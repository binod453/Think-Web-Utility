/*
 * client side validation
 */

$(document).ready(function() {
	$("#verifyPassword").click(function() {
		$error = 0;

		if ($("#passwordField").val().length == 0) {
			$("#passError").css("display", "block");
			$("#passwordError").css("display", "none");
			$error = 1;
		} else {
			$("#passError").css("display", "none");
		}

		if ($("#confirmPassword").val().length == 0) {
			$("#cpassError").css("display", "block");
			$("#passwordError").css("display", "none");
			$error = 1;
		} else {
			$("#cpassError").css("display", "none");
		}

		if ($error == 1) {
			return false;
		} else {
			if ($("#passwordField").val() != $("#confirmPassword").val()) {
				$("#passError").css("display", "none");
				$("#cpassError").css("display", "none");
				$("#passwordError").css("display", "block");
				$error = 1;
			}
			if ($error == 1) {
				return false;
			}
		}

		$.ajax({ 
			type : "POST", 
			url : "changePassword", 
			data : $('#changePassword').serialize() 
		}).done(function(msg) {
			//alert("Data Saved: " + msg);
		});
	});
	
	$("#closeChangePassword").click(function() {
		$.get( "/userLogin" );
	});
});

function isValidEmail(email) {
	var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	if (filter.test(email)) {
		return true;
	}
	return false;
}

function isvalidmob(telephone) {
	// var reg = /^(\+){0,1}\d{1,10}$/;
	var reg = /^[0-9+ -]{1,20}$/;
	if (reg.test(telephone)) {
		return true;
	}
	return false;
}

function validatepostCode(postcode) {
	var reg = /^[a-zA-Z0-9\-]*$/;
	if (reg.test(postcode)) {
		return true;
	}
	return false;
}

function validateAlphabetic(alphabetic) {
	var reg = /^[a-zA-Z\-\s]*$/;

	if (reg.test(alphabetic)) {
		return true;
	}
	return false;

}

function validateAlphaNumericAll(alphanum) {
	var reg = /^[A-Za-z0-9\.\-\s\!\@\#\$\%\^\''\*\(\)\=\+\,]*$/;

	if (reg.test(alphanum)) {
		return true;
	}
	return false;

}

function validateAlphaNumeric(alphanum) {
	var reg = /^[A-Za-z0-9\.\-\s\,]*$/;

	if (reg.test(alphanum)) {
		return true;
	}
	return false;

}

function validateAlphaNumericAllWithMore(alphanum) {
	var reg = /^[A-Za-z0-9\.\-\&\;\/\?\]\[\s\!\@\#\$\%\^\''\*\(\)\=\+\,\:\_]*$/;
	if (reg.test(alphanum)) {
		return true;
	}
	return false;

}

function validateDOI(doi){
	var reg=/^10.\d{4,9}\/[-._;()\/:A-Z0-9]+$/i;	
	if (reg.test(doi)) {
		return true;
	}
	return false;
}

function trim(x) {
	return x.replace(/^\s+|\s+$/gm, '');
}

function displayMessage(msg) {
	$("#alertMessage").text(msg);
	$("#greenAlert").show();
	$("#greenAlert").fadeTo(2000, 500).slideUp(500, function() {
		$("#greenAlert").slideUp(500);
	});
}

function saveUser(method, userId) {

	$error = 0;

	if ($("#firstName").val().length == 0) {
		$("#firstNameError").css("display", "block");
		$("#firstName").focus();
		$error = 1;
	} else {
		$("#firstNameError").css("display", "none");
	}

	if ($("#lastName").val().length == 0) {
		$("#lastNameError").css("display", "block");
		$("#lastName").focus();
		$error = 1;
	} else {
		$("#lastNameError").css("display", "none");
	}

	if ($("#phoneNumber").val().length != 0 && !isvalidmob($("#phoneNumber").val())) {
		$("#phoneError").css("display", "block");
		$("#phoneNumber").focus();
		$error = 1;
	} else {
		$("#phoneError").css("display", "none");
	}

	if (userId == 0) {
		$passError = 1;
		if ($("#passwordField").val().length == 0) {
			$("#passwordError").css("display", "block");
			$("#passwordField").focus();
			$error = 1;
		} else {
			$("#passwordError").css("display", "none");
			$passError = 0;
		}

		if ($("#confirmPasswordField").val().length == 0) {
			$("#confirmPasswordError").css("display", "block");
			$("#confirmPasswordField").focus();
			$error = 1;
		} else {
			$("#confirmPasswordError").css("display", "none");
			$passError = 0;
		}

		if ($passError == 0) {
			if ($("#passwordField").val() != $("#confirmPasswordField").val()) {
				$("#passwordError").css("display", "none");
				$("#confirmPasswordError").css("display", "none");
				$("#passMatchError").css("display", "block");
				$error = 1;
			} else {
				$("#passwordError").css("display", "none");
				$("#confirmPasswordError").css("display", "none");
				$("#passMatchError").css("display", "none");
			}
		}
	}

	if ($("#role").val().length == 0) {
		$("#roleError").css("display", "block");
		$("#role").focus();
		$error = 1;
	} else {
		$("#roleError").css("display", "none");
	}

	if ($("#country").val().length == 0) {
		$("#countryError").css("display", "block");
		$("#country").focus();
		$error = 1;
	} else {
		$("#countryError").css("display", "none");
	}

	if (userId != 0) {
		if ($error == 0) {
			if (method == 'myAccount') {
				$("#myAccountPage").attr("action", "saveUser");
				$("#myAccountPage").submit();
			} else {
				$("#createUpdateUser").attr("action", "saveUser");
				$("#createUpdateUser").submit();
			}
		} else {
			$("#myAccountPage").removeAttr("action");
			return false;
		}
	} else {
		if ($("#email").val().length == 0) {
			$("#emailError").css("display", "block");
			$("#emailValidError").css("display", "none");
			$("#emailExist").css("display", "none");
			$("#email").focus();
			$error = 1;
		} else if (!isValidEmail($("#email").val())) {
			$("#emailValidError").css("display", "block");
			$("#emailError").css("display", "none");
			$("#emailExist").css("display", "none");
			$("#email").focus();
			$error = 1;
		} else {
			if ($error == 1) {
				$("#emailValidError").css("display", "none");
				$("#emailError").css("display", "none");
				$("#emailExist").css("display", "none");
				return false;
			} else {
				$username = $("#email").val();
				$.ajax({ url : "checkUserExist?username=" + $username, success : function(result) {
					if (result == true) {
						$("#emailExist").css("display", "block");
						$("#emailValidError").css("display", "none");
						$("#emailError").css("display", "none");
						$("#email").focus();
						return false;
					} else {
						$("#createUpdateUser").attr("action", "saveUser");
						$("#createUpdateUser").submit();
					}
				} });
			}
		}
	}
}

function saveCustomer(method, customerId) {

	$error = 0;

	if ($("#customerName").val().length == 0) {
		$("#customerNameError").css("display", "block");
		$("#customerNameName").focus();
		$error = 1;
	} else {
		$("#customerNameError").css("display", "none");
	}

	if ($("#address").val().length == 0) {
		$("#addressError").css("display", "block");
		$("#address").focus();
		$error = 1;
	} else {
		$("#addressError").css("display", "none");
	}

	if ($("#addZipcode").val().length == 0) {
		$("#addZipcodeError").css("display", "block");
		$("#addZipcode").focus();
		$error = 1;
	} else {
		$("#addZipcodeError").css("display", "none");
	}

	if ($("#phoneNo").val().length != 0 && !isvalidmob($("#phoneNo").val())) {
		$("#phoneNoError").css("display", "block");
		$("#phoneNo").focus();
		$error = 1;
	} else {
		$("#phoneNoError").css("display", "none");
	}

	if ($("#addCity").val().length == 0) {
		$("#addCityError").css("display", "block");
		$("#addCity").focus();
		$error = 1;
	} else {
		$("#addCityError").css("display", "none");
	}

	if ($("#addState").val().length == 0) {
		$("#addStateError").css("display", "block");
		$("#addState").focus();
		$error = 1;
	} else {
		$("#addStateError").css("display", "none");
	}

	if ($("#country").val().length == 0) {
		$("#countryError").css("display", "block");
		$("#country").focus();
		$error = 1;
	} else {
		$("#countryError").css("display", "none");
	}

	if ($error == 1) {
		return false;
	}

	if (method == 'customerpage') {
		$("#customerForm").attr("action", "saveCustomer");
		$("#customerForm").submit();
	}

}
//blank check for ckeditor field
function isBlankField(field) {
	// alert("'"+field+"'");
	var isBlank = true;
	var arr = new Array();
	arr = field.split("&nbsp;");
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] == '' || arr[i] == ' ' || arr[i] == "<p>" || arr[i] == "</p>") {
			continue;
		} else {
			isBlank = false;
			break;
		}
	}
	return isBlank;
}
