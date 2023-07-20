<%@include file="/include/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Update your Date-of-birth/Password</h1>
		<form name="form-box px-5 px-y" action=update method="post">
			<div class="jumbotron text-primary">

				<div class="row mb-3">

					<div class="col-sm-4"><input type="email" name="email" class="form-control-plaintext"
						value="<%=request.getAttribute("email")%>" readonly />
                        </div>
				</div>
				<div class=" row mb-3">
					<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-2">	<input type="text"
						class="form-control" name="password"
						value="<%=request.getAttribute("password")%>" /></div>
				</div>


				<div class="row mb-3">
					<label for="dateOfBirth" class="col-sm-2 col-form-label">DateOfBirth</label>
					<div class="col-sm-2">
					<input type="text"class="form-control" name="dateOfBirth"
						value="<%=request.getAttribute("dateOfBirth")%>" /> 
				</div>
				</div>
<div>
<input
						type="submit" value="update" class="btn btn-primary" />

</div>
			</div>

		</form>
	</div>

</body>
</html>
