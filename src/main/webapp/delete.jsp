

<%@include file="/include/header.jsp"%>
<%@ page import="user_crud.payload.User"%>
<body>
	<%
	User users = (User) request.getAttribute("userByEmail");
	if (users != null) {
	%>
<%@include file="/include/menu.jsp"%>
	<section class="main">
		<div class="container1">

			<h1>delete registration page</h1>
			
			<form class="deleteform" action="delete" method="post">

				<div class="mb-3 row">
					<label for="email" class="col-sm-2 col-form-label"></label>
					<div class="col-sm-2">
						<input type="hidden" name="email" class="form-control-plaintext"
							id="email" value="<%=users.getEmail()%>">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-2">
						<input type=text readonly class="form-control-plaintext" id="id" name="id"
							value="<%=users.getId()%>" readonly >
					</div>
				</div>







				<div class="mb-3 row">
					<label for="password" class="col-sm-2 col-form-label">password</label>
					<div class="col-sm-2">
						<input type="text" name="password" class="form-control-plaintext"
							id="password" value="<%=users.getPassword()%>" readonly>
					</div>
				</div>


				<div class="mb-3 row">
					<label for="dateOfBirth" class="col-sm-2 col-form-label">Date-Of-Birth</label>
					<div class="col-sm-2">
						<input type="text" name="dateOfBirth"
							class="form-control-plaintext" id="dateOfBirth"
							value="<%=users.getDateOfBirth()%>" readonly>

					</div>
				</div>


				<div class="mb-3 row">
					<label for="country" class="col-sm-2 col-form-label">country</label>
					<div class="col-sm-2">
						<input type="text" name="country" class="form-control-plaintext"
							id="country" value="<%=users.getCountry()%>" readonly>
					</div>
				</div>


				<div>
					<input type="submit" value="delete" class="btn btn-primary" readonly>
				</div>

				<%
				}
				%>

			</form>
		</div>
	</section>
</body>
</html>
