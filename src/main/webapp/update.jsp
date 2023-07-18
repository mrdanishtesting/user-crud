<%@include file="/include/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Update your Date-of-birth/Password</h1>
		<form name="form-box" action=update method="post">
			<div class="jumbotron text-primary">

				<div class="row mb-3">

					<input type="email" name="email" class="form-control-plaintext"
						value="<%=request.getAttribute("email")%>" readonly />

				</div>
				<div class=" row mb-3">
					<label for="password">Password</label>
				<div class="col-sm-">	<input type="text"
						class="form-control-sm-2" name="password"
						value="<%=request.getAttribute("password")%>" /></div>
				</div>


				<div>
					<label for="dateOfBirth">DateOfBirth</label><input type="text"
						class="form-control-sm-2" name="dateOfBirth"
						value="<%=request.getAttribute("dateOfBirth")%>" /> 
				</div>
<div>
<input
						type="submit" value="update" class="btn btn-primary" />

</div>
			</div>

		</form>
	</div>

</body>
