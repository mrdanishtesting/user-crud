
<%@include file="/include/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="user_crud.payload.User"%>
<body>
	<%
int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
int numOfPage = Integer.parseInt(request.getAttribute("numOfPage").toString());
%>

	<div class="container">
		<div align="center">

			<h1>List of Values:</h1>
			<table class="table table-hover" border="1px">
				<tr>
					<th scope="col">id</th>
					<th scope="col">email</th>
					<th scope="col">password</th>
					<th scope="col">date of birth</th>
					<th scope="col">Country</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>

				<%
				List<User> users = (List<User>) request.getAttribute("listUser");
				if (users != null) {
					for (User user : users) {
				%>
				<tr>
					<th scope="row"><%=user.getId()%></th>
					<td><%=user.getEmail()%></td>
					<td><%=user.getPassword()%></td>
					<td><%=user.getDateOfBirth()%></td>
					<td><%=user.getCountry()%></td>


					<td><a href="UpdateReg?id=<%=user.getId()%>">Update</a></td>

					<td><a
						href="delete?email=<%=user.getEmail()%>" target="_blank">Delete</a></td>

				</tr>
				<%
}
}
%>
			</table>
		</div>
	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<%
			if (currentPage != 1) {
			%>
			<li class="page-item"><a class="page-link"
				href="listall?currentPage=<%=1%>" aria-label="previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<%
			}
			%>

			<%
			int start = currentPage - 1;
			int endPage = currentPage + 1;
			%>

			<%
			for (int i = start; i <= endPage; i++) {
				if (i >= 1 && i <= numOfPage) {
			%>
			<li class="page-item <%if (i == currentPage) {%>active<%}%>">
				<a class="page-link" href="listall?currentPage=<%=i%>"><%=i%></a>
			</li>
			<%
			}
			}
			%>

			<%
			if (currentPage != numOfPage) {
			%>
			<li class="page-item"><a class="page-link"
				href="listall?currentPage=<%=numOfPage%>" aria-label="next"> <span
					class="span1" aria-hidden="true">&raquo;</span>
			</a></li>
			<%
			}
			%>
		</ul>
	</nav>
</body>

</html>
