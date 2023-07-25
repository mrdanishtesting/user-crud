


<link rel="stylesheet" type="text/css" href="css/exception.css" />
<body>
	<h1>HTTP STATUS 404</h1>

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
    <div class="container error-container">
        <h1 class="text-center">Oops! Something went wrong.</h1>
        <p class="text-center">We're sorry, but an unexpected error occurred.</p>
        <p class="text-center">Please try again later.</p>
    </div>
</body>
</html>