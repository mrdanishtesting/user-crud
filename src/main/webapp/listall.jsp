 <%@include file="/include/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="user_crud.payload.User"%>

<title>ListallPage</title>

</head>
<body>




<%
int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
int numOfPage = Integer.parseInt(request.getAttribute("numOfPage").toString());
%>

<div class="container">
<div align="center">

<h1>List of Values:</h1>
<table  class="table table-hover" border="1px">
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


<td><form action="UpdateReg" method="post">
<input type="hidden" name="email" value="<%=user.getEmail()%>">
<input type="hidden" name="password"
value="<%=user.getPassword()%>"> <input type="hidden"
name="dateOfBirth" value="<%=user.getDateOfBirth()%>">
<button type="submit" class="btn btn-outline-primary">update</button>
</form></td>

<td><a
href="delete?email=<%=user.getEmail()%>&id=<%=user.getId()%>&password=<%=user.getPassword()%>&dateOfBirth=<%=user.getDateOfBirth()%>&country=<%=user.getCountry()%>">Delete</a></td>

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
        <% if (currentPage != 1) { %>
            <li class="page-item">
                <a class="page-link" href="listall?currentPage=<%=1%>" aria-label="previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        <% } %>

        <% int startPage = currentPage - 1;
           int endPage = currentPage + 1;
        %>

        <% for (int i = startPage; i <= endPage; i++) {
            if (i >= 1 && i <= numOfPage) {
        %>
                <li class="page-item <% if (i == currentPage) { %>active<% } %>">
                    <a class="page-link" href="listall?currentPage=<%=i%>"><%=i%></a>
                </li>
        <% } } %>

        <% if (currentPage != numOfPage) { %>
            <li class="page-item">
                <a class="page-link" href="listall?currentPage=<%=numOfPage%>" aria-label="next">
                    <span class="span1" aria-hidden="true">&raquo;</span>
                </a>
            </li>
        <% } %>
    </ul>
</nav>


</body>

