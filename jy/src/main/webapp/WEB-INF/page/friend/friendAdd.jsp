<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp"%>

<!DOCTYPE html>
<html>
<!-- Head -->
<head>
<meta charset="utf-8" />
<title>通讯录管理</title>
</head>
<!-- Body -->
<body>
	<!-- MAIN PANEL -->
	<div>
		<!-- 路径导航开始 -->
		<ol class="breadcrumb">
			<li><a href="${base}/groups/index">通讯录管理</a></li>
			<li class="active">编辑组</li>
		</ol>
		<!-- 路径导航结束 -->

		<!-- 主体内容开始 -->
		<div id="container" class="content" style="padding-left:20px;padding-right:20px">
			<!-- 表单开始 -->
			<form action="${base}/friends" class="form-horizontal" id="commForm">
				<!-- 待编辑区 panel开始 -->
				<div class="panel panel-info">
					<div class="panel-heading">
						<i class="fa fa-pencil"></i>&nbsp;&nbsp;添加
					</div>
					<!-- panel-body开始 -->
					<div class="panel-body">

						<div class="form-group">
							<label for="fName" class="col-sm-3 control-label">姓名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="fName"
									name="fName" placeholder="联系人名称" >
							</div>
						</div>
						
						<div class="form-group">
							<label  class="col-sm-3 control-label">性别</label>
							<div class="col-sm-1">
								<div class="radio">
									<label> <input type="radio" id="sex" name="sex" value="1" checked>
										男
									</label>
								</div>
							</div>
							<div class="col-sm-1">
								<div class="radio">
									<label> <input type="radio" value="0" id="sex" name="sex" >
										女
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="birthday" class="col-sm-3 control-label">生日</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="birthday"
									name="birthday" placeholder="日期" >
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-3 control-label">邮箱</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="email"
									name="email" placeholder="邮箱" >
							</div>
						</div>
							<div class="form-group">
							<label for="mobile" class="col-sm-3 control-label">电话</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="mobile"
									name="mobile" placeholder="电话" >
							</div>
						</div>
						
						<div class="form-group">
							<label for="mobile" class="col-sm-3 control-label">地址</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="fAddress"
									name="fAddress" placeholder="地址" >
							</div>
						</div>
						<div class="form-group">
							<label for="fDetail" class="col-sm-3 control-label">详细</label>
							<div class="col-sm-5">
								<textarea rows="10" cols="5" class="form-control" id="fDetail" name="fDetail"></textarea>
								
							</div>
						</div>
						
					</div>
					<!-- panel-body结束 -->
					<!-- panel-footer开始 -->
					<div class="panel-footer text-right">
						<button type="button" name="returnBtn" class="btn btn-default"
							id="returnBtn" onclick="location.href='${base}/friends'">返回</button>
						<button type="reset" name="resetBtn" id="resetBtn"
							class="btn btn-warning">重置</button>
						<button type="button" name="submitBtn" class="btn btn-primary"
							id="submitBtn">提交</button>
					</div>
					<!-- panel-footer结束 -->
				</div>
				<!-- 待编辑区panel结束 -->
			</form>
			<!--表单结束 -->
		</div>
		<!-- 主体内容结束 -->
	</div>
	<!-- END MAIN PANEL -->

	<!-- 包含footer，引入公用 JS -->
	<%@ include file="/WEB-INF/page/common/footer.jsp"%>

	<!--自定义JS-->
	<script src="${resourcesUrl}/js/friend/friendAdd.js"></script>
</body>
</html>
