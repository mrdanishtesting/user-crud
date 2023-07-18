<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@include file="/include/header.jsp"%>
<title>exception</title>
</head>
<body>
<h1>exception occurs!!!!!!!!!!!!!!</h1>
<%
 String status=request.getAttribute("status").toString();
  String msg= request.getAttribute("msg").toString();
  if(status!=null&& status.equals("success")){
%> 

<div class="alert alert-success" role="alert">


<%}else{%>
	
<div class="alert alert-danger" role="alert">

<%} %>

<strong><%=msg%></strong>
	</div>
	
</div>


</body>
</html>