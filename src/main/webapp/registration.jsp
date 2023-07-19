  <%@include file="/include/header.jsp"%> 
  <%@include file="/include/menu.jsp" %>
<title>create registration</title>
</head>
<body>

<!---  navbar--------->

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="login">Registration</a>
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
		
				<li class="nav-item dropdown">
  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
    Dropdown
  </a>
  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
    <li><a class="dropdown-item" href="/login">Create</a></li>
    <li><a class="dropdown-item" href="listall?currentpage=1">Read</a></li>
    <li><hr class="dropdown-divider"></li>
    <li><a class="dropdown-item" href="#">Something else here</a></li>
  </ul>
</li>
<li class="nav-item">
  <a class="nav-link enabled" href="#" tabindex="-1" aria-disabled="false"></a>
</li>

			</ul>
			
		</div>
	</div>
</nav>



<!--  navbar--------->

<div class="container">
	


	<%
	String status = (String) request.getAttribute("status");
	String msg = (String) request.getAttribute("msg");

	if (status != null && status.equals("success")) {
	%>

	<div class="alert alert-success" role="alert">
		<%
		} else {
		%>
		<div class="alert alert-danger" role="alert">
			<%
			}
			%>
			<strong><%=msg%></strong>

		</div>

		<h1>Create Registration</h1>
		<p>
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


		<form name="myFormRegistration" action="createReg" onsubmit="return false" method="post">

			<div class="row mb-3">
				<label for="email" class="col-sm-2 col-form-label">EMAIL:</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" name="email"
						placeholder="enterEmail!!!">
				</div>
			</div>

			<div class="mb-3 row">

				<label for="password" class="col-sm-2 col-form-label">PASSWORD:</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" name="password"
						placeholder="enterPassword!!!">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="confirmpassword" class="col-sm-2 col-form-label">C:PASSWORD</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" name="confirmPassword"
						placeholder="reEnterpassword!!!">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="dateOfBirth" class="col-sm-2 col-form-label">DATE:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="dateOfBirth"
						placeholder="enterDateOfBirth!!!">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="country" class="col-sm-2 col-form-label">COUNTRY:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="country"
						placeholder="entercountry!!!">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="views" class="col-sm-2 col-form-label">Your-Views</label>
				<div class="col-sm-5">
					<textarea class="form-control form-control-sm" rows="3" cols="1">give your views</textarea>


				</div>
			</div>
			<input type="submit" class="btn btn-primary" value="save">
		</form>
	</div>
</div>
</body>
<script type="text/javascript">

function validate(){
	
var email=document.myFormRegistration.email.value;
var password=document.myFormRegistration.password.value;
var confirmPassword=document.myFormregistration.confirmPassword.value;
var dateOfBirth =document.myFormRegistration.dateOfBirth.value;
var country=document.myFormRegistration.country.value;
	
	if(email===""||!validateEmail("email")){
		document.getElementById("email").classList.add("is-invalid");
		return false;
		else{
			document.getElementById("email").classList.remove("is-invalid");
			document.getElementById("email").classList.add("is-valid");
			
		}
		
	}
	
	
	
}









</script>










</html>