<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.ResultSet,java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Users</title>
</head>
<body>
List User
<% ResultSet rs = (ResultSet)request.getAttribute("rs"); %>
<% try { while (rs.next()) {%>
<h4> <%= rs.getString(2) %></h4>
<% } } catch (SQLException se) {
	se.printStackTrace();
} %>

</body>
</html>