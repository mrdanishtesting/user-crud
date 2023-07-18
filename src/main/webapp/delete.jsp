
<%@page import="javax.management.ValueExp"%>
<%@include file="/include/header.jsp"%>
<title>update Registration</title>
</head>
<body>
	<div class="container">


		<h1>delete registration page</h1>
		<form action="delete" method="post">

			<div class="mb-3 row">
				<label for="password" class="col-sm-2 col-form-label">ID</label>
				<div class="col-sm-2">
					<input type=text  class="form-control-plaintext" id="id"
						name="id" value="<%=request.getAttribute("id")%>">
				</div>
			</div>




			<div class="mb-3 row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-2">
					<input type="text" name="email" class="form-control-plaintext"
						id="staticEmail" value="<%=request.getAttribute("email")%>">
				</div>
			</div>



			<div class="mb-3 row">
				<label for="password" class="col-sm-2 col-form-label">password</label>
				<div class="col-sm-2">
					<input type="text"  name="password" class="form-control-plaintext"
						id="staticEmail" value="<%=request.getAttribute("password")%>">
				</div>
				</div>
				
				
				
				
				
				
				
				
				
				

				<div class="mb-3 row">
					<label for="dateOfBirth" class="col-sm-2 col-form-label">Date-Of-Birth</label>
					<div class="col-sm-2">
						<input type="text" name="dateOfBirth" class="form-control-plaintext"
							id="dateOfBirth"
							value="<%=request.getAttribute("dateOfBirth")%>">

					</div>
				</div>


			<div class="mb-3 row">
				<label for="country" class="col-sm-2 col-form-label">country</label>
				<div class="col-sm-2">
					<input type="text"  name="country" class="form-control-plaintext"
						id="country" value="<%=request.getAttribute("country")%>">
				</div>
			</div>


			<div>
				<input type="submit" value="delete" class="btn btn-primary">
			</div>
	


	</form>
	</div>
</body>
