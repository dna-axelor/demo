<%@page import="java.util.Iterator"%>
<%@page import="com.rest.jsp.hibernate.EmpData"%>
<%@page import="java.util.List"%>

<HTML>
<HEAD>
<TITLE>Displaying Information</TITLE>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}

* {
	box-sizing: border-box;
}
</style>
</HEAD>

<BODY>
	<H1>Data of Interns</H1>

	<%@ page import="com.rest.jsp.Dao.DisplayDao"%>
	<%
		DisplayDao Dd = new DisplayDao();
		List results = Dd.Display();
		Iterator iterator = results.iterator();
	%>



	<TABLE BORDER="1">
		<TR>
			<TH>ID</TH>
			<TH>Name</TH>
			<TH>Company</TH>
			<TH colspan=2>Operation</TH>

		</TR>
		<%
			while (iterator.hasNext()) {
		%>
		<%
			EmpData emp = (EmpData) iterator.next();
		%>
		<TR>
			<TD><%=emp.getId()%></td>
			<TD><%=emp.getName()%></TD>
			<TD><%=emp.getCompany()%></TD>
			<td><a href="http://localhost:8080/resteasy-jsp/Delete.jsp?id=<%=emp.getId()%>" onClick="check()">Delete</a></td>
				<td><a href="http://localhost:8080/resteasy-jsp/Update.jsp?id=<%=emp.getId()%>">Update</a></td>
		</TR>
		<%
			}
		%>
	</TABLE>
	<script type='text/javascript'>
		function check() {
			
			 alert("Deleted.");
			
		}
	</script>
	
	</BODY>
</HTML>
