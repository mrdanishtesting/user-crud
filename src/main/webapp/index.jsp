<%@include file="/include/header.jsp"%>

<title>Login Page</title>

<body>

	<section class="main">
		<h1 class="text-center mb-4">Loginn</h1>
		<div class="container1">
			<div class="col-lg-4 col-md-10 col-sm-12">
				<form name="myForm" class="form-box px-6 py-4"
					onsubmit="return validate();" action="login" method="post">

					<h2 class="text-center mb-4">Sign In .</h2>

					<div class="mb-3 row">
						<label for="email" class="col-sm-1 col-form-label"></label>
						<div class="col-sm-10">
							<input type="email" class="form-control" name="email" id="email"
								placeholder="Enter Email!!!">
						</div>
					</div>

					<div class="mb-3 row">

						<label for="password" class="col-sm-1 col-form-label"></label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="Enter Password!!!">
						</div>
					</div>

					<div class="buttonHolder">
						<input type="submit" class="btn btn-primary me-md-5"
							value="Signin">
					</div>
				</form>
			</div>
		</div>
	</section>


</body>
<script>
	function validate() {
		var email = document.myForm.email.value;
		var password = document.myForm.password.value;

		if (email === "" || !validateEmail(email)) {
			document.getElementById("email").classList.add("is-invalid");

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
</script>


