<%@page import="java.awt.desktop.UserSessionEvent"%>
<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> --%>
<link rel="stylesheet" type="text/css" href="css/update.css"/>

<%@include file="/include/header.jsp"%>
<%@ page import="user_crud.payload.User"%>


<body>
<%User users = (User)request.getAttribute("userById"); %>

	<div class="container">
	
		<h1>Update your Date-of-birth/Password</h1>
	
		<form name="form-box" action="UpdateReg" method="post">
			<div class="jumbotron text-primary">

				<div class="row mb-3">
					<div class="col-sm-4">
						<input type="hidden" name="id" class="form-control"
							value="<%=users.getId()%>" />
					</div>
				</div>


				<div class="row mb-3">
					<label for="email" class="col-sm-2 col-form-label">email</label>
					<div class="col-sm-4">
						<input type="email" name="email" class="form-control"
							value= "<% out.print(users.getEmail()); %>" />
					</div>
				</div>


				<div class="row mb-3">
					<label for="password" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-4">
						<input type="text" name="password" class="form-control"
							value="<%=users.getPassword() %>" />
					</div>
				</div>
				<div class=" row mb-3">
					<label for="dateOfBirth" class="col-sm-2 col-form-label">DateOfBirth</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="dateOfBirth"
							value="<%=users.getDateOfBirth() %>" />
					</div>
				</div>


				<div class="row mb-3">
					<label for="country" class="col-sm-2 col-form-label">country</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="country"
							value="<%=users.getCountry()%>" />
					</div>
				</div>
				<div>
					<input type="submit" value="update" class="btn btn-primary" />

				</div>
			</div>
		</form>
</div>
	
</body>
</html>
