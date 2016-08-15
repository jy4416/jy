<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/page/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

	<!-- 导航条 -->
		<nav class="navbar navbar-default">
		    <div class="navbar-header" style="padding-left:20px">
		     
    		</div>
		</nav>
		<div id="container" class="">
			<div class="row">
			  <div class="col-xs-12 col-sm-12 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4" >
			  		<div class="panel panel-primary">
					  <div class="panel-heading">登录</div>
					  <div class="panel-body">
					    	<form action="${base}/login" id="loginForm" autocomplete="off" method="post">
					    		<div class="form-group">
								    <label for="userName" >用户名</label>
								    <input type="text" class="form-control" autocomplete="off"
								    id="userName" name="userName" placeholder="请输入用户名">
								 </div>
								 <div class="form-group">
								    <label for="passWord" >密码</label>
								    <input type="password" class="form-control" autocomplete="off"
								    id="passWord" name="passWord" placeholder="请输入密码">
								 </div>
								 <div id="tipInfo"></div>
								 <div class="form-inline text-right">
								  <button type="reset" class="btn btn-default">重置</button>
								   <button type="button" id="loginBtn" class="btn btn-primary">提交</button>
								 </div>
					    	</form>
					  </div>
					</div>
			  </div>
			 
			</div>
			
		</div>
	
<%@include file="/WEB-INF/page/common/footer.jsp" %>
<script type="text/javascript" src="${resourcesUrl}/js/login.js"></script>
</body>
</html>