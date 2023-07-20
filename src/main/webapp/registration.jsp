
<%@include file="/include/header.jsp"%>

<body>

	<%
	String status = (String) request.getAttribute("status");
	String msg = (String) request.getAttribute("msg");

	if (status != null && status.equals("success")) {
	%>
	<div   id="success-alert" class="alert alert-success" role="alert">
		<%
		} else {
		%>
		<div class="alert alert-danger" role="alert">
			<%
			}
			%>
			<strong><%=msg%></strong>
		</div>
	</div>
	<!---  navbar--------->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<a class="navbar-brand" href="listall?currentPage=1">listall</a> <a
			class="navbar-brand" href="logout">logout</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="createReg">Sign-in</a></li>

				<li class="nav-item dropdown"></li>
			</ul>

		</div>

	</nav>
	<!--  navbar--------->
	<section class="main">
		<h1>Create Registration</h1>
		<p class="fw-light">
			<i><q>On WebSites the value of well-designed registration
					forms is frequently under rated</q>. However,the <q>registration</q>
				form is the first way that potential consumers can get in touch with
				your business, particularly when it comes to digital customer
				acquisition. A registration form is a document with a set of fields
				that a person fills out and sends to a business or individual to
				register for an event, program, membership, list, and so on.</i> <i>Using
				the online registration form, you may gather contact information and
				encourage people to interact with you. For the purpose of enrolling
				customers in subscriptions, services, or other programs or plans,
				businesses utilize registration forms.</i>
		</p>

		<div class="col-lg-5 col-md-10 col-sm-12">
			<form name="myFormRegistration" class="form-box1 px-0 py-3"
				action="createReg" method="post">
				<h2>Register</h2>

				<div class="col mb-3 row">
					<label for="email" class="col-sm-1 col-form-label"></label>
					<div class="col-sm-10">
						<input type="email" class="form-control" name="email"
							placeholder="enterEmail!!!">
					</div>
				</div>

				<div class="mb-3 row">

					<label for="password" class="col-sm-1 col-form-label"></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password"
							placeholder="enterPassword!!!">
					</div>
				</div>

				<div class="mb-3 row">
					<label for="confirmpassword" class="col-sm-1 col-form-label"></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="confirmPassword"
							placeholder="reEnterpassword!!!">
					</div>
				</div>
				<div class="col mb-3 row">
					<label for="dateOfBirth" class="col-sm-1 col-form-label"></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dateOfBirth"
							placeholder="enterDateOfBirth!!!">
					</div>
				</div>
				<div class="col mb-3 row">
					<label for="country" class="col-sm-1 col-form-label"></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="country"
							placeholder="entercountry!!!">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="views" class="col-sm-1 col-form-label"></label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="3" cols="1">give your views</textarea>


					</div>
				</div>
				<input type="submit" class="btn btn-primary" value="save">
			</form>
		</div>

	</section>

</body>

<script type="text/javascript">

$(document).ready(function() {
  $("#success-alert").hide();
  $("#myWish").function showAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
      $("#success-alert").slideUp(500);
    });
  });
});


</script>

</html>