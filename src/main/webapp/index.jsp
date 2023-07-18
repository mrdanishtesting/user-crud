<%@include file="/include/header.jsp"%>

<title>Login Page</title>

<body>
	<section class="main">
		<div class="container">

			<h1>LoginPage</h1>
			<h2>Here you can login.....</h2>
			<form name="myForm" class="form-box" onsubmit="return validate();"
				action="loggin" method="post">

				<div class="mb-3 row">
					<label for="email" class="col-sm-1 col-form-label">EMAIL:</label>
					<div class="col-sm-5">
						<input type="email" class="form-control" name="email" id="email"
							placeholder="Enter Email!!!">
					</div>
				</div>

				<div class="mb-3 row">

					<label for="password" class="col-sm-1 col-form-label">PASSWORD:</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" name="password"
							id="password" placeholder="Enter Password!!!">
					</div>
				</div>

				<div>
					<input type="submit" class="btn btn-primary" value="Login">
				</div>
			</form>
		</div>
	</section>



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
				document.getElementById("password").classList
						.remove("is-invalid");
				document.getElementById("password").classList.add("is-valid");
			}

			return true;
		}

		function validateEmail(email) {
			var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			return re.test(email);
		}
	</script>

</body>
