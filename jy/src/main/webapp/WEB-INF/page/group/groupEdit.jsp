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
		<div id="container" class="content">
			<!-- 表单开始 -->
			<form action="${base}/groups/${group.gId}" class="form-horizontal" id="commForm">
				<!-- 待编辑区 panel开始 -->
				<div class="panel panel-info">
					<div class="panel-heading">
						<i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑
					</div>
					<!-- panel-body开始 -->
					<div class="panel-body">

						<div class="form-group">
							<label for="gName" class="col-sm-3 control-label">组名称</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="gName"
									name="gName" placeholder="组名称" value="">
							</div>
						</div>

						<div class="form-group">
							<label for="gDetail" class="col-sm-3 control-label">详细</label>
							<div class="col-sm-5">
								<textarea rows="10" cols="5" class="form-control" id="gDetail" name="gDetail">
								</textarea>
								
							</div>
						</div>
						
						
						<!-- 隐藏域 -->
						<input type="hidden" id="gId" name="gId" value="${gId }">
						
					</div>
					<!-- panel-body结束 -->
					<!-- panel-footer开始 -->
					<div class="panel-footer text-right">
						<button type="button" name="returnBtn" class="btn btn-default"
							id="returnBtn" onclick="location.href='${base}groups'">返回</button>
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
	<script src="${resourcesUrl}/js/group/groupEdit.js"></script>
</body>
</html>
