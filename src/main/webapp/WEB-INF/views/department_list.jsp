<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department List</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>List of Department</h2>
	<table>
		<tr>
			<td>ID</td>
			<td>Department Name</td>
			<td>Status</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<c:forEach items="${department}" var="temp">
			<tr>
				<td>${temp.dept_id}</td>
				<td>${temp.dept_name}</td>
				<td>${temp.status}</td>
				<td><a
					href="<c:url value='/edit-${temp.dept_id}-department' />">edit</a></td>
				<td><a
					href="<c:url value='/delete-${temp.dept_id}-department' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>