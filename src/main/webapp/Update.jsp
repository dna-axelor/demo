<%@page import="com.rest.jsp.hibernate.EmpData"%>
<%@page import="java.util.List"%>
<%@ page language="java" %>
<%@page import="java.util.Iterator"%>
<%@page import="com.rest.jsp.Dao.DisplayDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 80%;
}

td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	text-color:white
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit]:hover {
	background-color: #45a049;
}

button {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

a:link, a:visited {
	background-color: #f44336;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 4px;
}

a:hover, a:active {
	background-color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
		
			DisplayDao dd = new DisplayDao();
			String n = request.getParameter("id");
			List results=dd.get(n);
			
			for (Iterator iterator = results.iterator(); iterator.hasNext();) {
				
				EmpData emp = (EmpData) iterator.next();
				
			
			
			
%>

	<form method="GET" action="http://localhost:8080/resteasy-jsp/update_save.jsp">
		<table border="5" align="center">
			<tr>

				 <th align="center" colspan="2" height="50"><font color="white">Register</font></th>

			</tr>
			<tr>
				<td><label><b>Id:</b></label></td>
				<td><input type="text" id="id" name="id" value="<%=emp.getId()%>"/></td>
			</tr>

			<tr>
				<td><label><b>Name:</b></label></td>
				<td><input type="text" id="name" name="name" value="<%=emp.getName()%>"/></td>
			</tr>

			<tr>
				<td><label><b>Company:</b></label></td>
				<td><input type="text" id="company" name="company" value="<%=emp.getCompany()%>"/></td>
			</tr>
			<tr>
				<td><button type="submit"><b>Submit</b></button></a>
						
					</td>
				<td><a href="http://localhost:8080/resteasy-jsp/display.jsp"><b>List</b></a></td>
				<!--  ><td><a href="/resteasy-jsp/employee/test/run">Test</a></td>-->
			</tr>
		</table>


	
	
	<%
			}
	%>
	</form>
</body>
</html>