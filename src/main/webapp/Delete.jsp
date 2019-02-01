<%@page import="com.rest.jsp.Dao.DisplayDao"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deleting......</title>

</head>
<body>
	<%
		if (request.getParameter("id") == null) {
			out.println("Invalid id.");
		} else {
			DisplayDao dd = new DisplayDao();
			String n = request.getParameter("id");
			if (dd.delete(n)) {

				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("location", "http://localhost:8080/resteasy-jsp/display.jsp");
			}
		}
	%>
</body>
</html>