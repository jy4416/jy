<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有组</title>
</head>
<body>
	<table border="1" width="50%" cellpadding="0" cellspacing="0">
		<th>组名</th>
		<th>详细</th>
		
		<c:forEach var="g" items="${groups}">
			<tr>
			<td>${g.gName}</td>
			<td>&nbsp;&nbsp;${g.gDetail}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>