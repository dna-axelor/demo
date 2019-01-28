<%@ page import="java.sql.*"%>

<%
	Class.forName("org.postgresql.Driver");
%>

<HTML>
<HEAD>
<TITLE>Displaying Information</TITLE>
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

	<%
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Student", "axelor",
				"axelor");

		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery("select * from DataEmp");
	%>

	<TABLE BORDER="1">
		<TR>
			<TH>ID</TH>
			<TH>Name</TH>
			<TH>Company</TH>

		</TR>
		<%
			while (resultset.next()) {
		%>
		<TR>
			<TD><%=resultset.getString(1)%></td>
			<TD><%=resultset.getString(3)%></TD>
			<TD><%=resultset.getString(2)%></TD>
		</TR>
		<%
			}
		%>
	</TABLE>
</BODY>
</HTML>
