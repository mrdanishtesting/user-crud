
<%@include file="/include/header.jsp"%>
<body>
   
	<section class="main">
		<h1 class="text-center mb-4">lOGIN PAGE</h1>
		<p id="1"></p>
		<div class="container1">
			<div class="col-lg-4 col-md-10 col-sm-12">
				<form name="myForm"  onsubmit="return validate();" class="form-box px-0 py-3"
					 action="login" method="post">

					<h2 class="text-center mb-4" >Sign In .</h2>

					<div class="mb-4 row">
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
						<input type="submit"  class="btn btn-primary me-md-3"
							value="Signin">
					</div>
		
					
					<div><a href="createReg">Create-Registration</a><p>if you already register go for signin</p> </div>
				</form>
			</div>
		</div>
	</section>
	

</body>
<script type="text/javascript"><%@include file="/form_valid/formvalid.js" %></script>



</html>