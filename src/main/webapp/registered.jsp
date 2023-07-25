

<%@include file="/include/header.jsp"%>
<%@ page import="user_crud.payload.User"%>
<body>
	<%
	String status = request.getAttribute("status").toString();
	String msg = request.getAttribute("msg").toString();
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

	</div>
	<%
	User users = (User) request.getAttribute("byemail");
	if (users != null) {
	%>
<%@include file="/include/menu.jsp"%>
	<section class="main">
		<div class="container1">

			<h1>your Details</h1>
			
			<form class="deleteform" class="form-box">

				<div class="mb-3 row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-2">
						<input type="text" name="email" class="form-control-plaintext"
							id="email" value="<%=users.getEmail()%>"readonly>
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


				
				<%
				}
				%>

			</form>
		</div>
	</section>
</body>
</html>
