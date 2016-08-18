<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String contextPath=request.getContextPath();
String url=request.getRequestURL().toString();
url=url.substring(0, url.indexOf(contextPath)+contextPath.length()+1);
String resources=url+"resources";

%>
<c:set var="base" value="<%=url%>" />
<c:set var="resourcesUrl" value="<%=resources%>" />

<script type="text/javascript">

	var BASE='${base}';

</script>

<!-- Basic Styles
<link rel="stylesheet" type="text/css" 
	href="${resources}/common/css/bootstrap.min.css">
	
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
-->

<link rel="stylesheet" type="text/css" 
	href="${resourcesUrl}/common/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" 
	href="${resourcesUrl}/common/css/jquery-ui.css">