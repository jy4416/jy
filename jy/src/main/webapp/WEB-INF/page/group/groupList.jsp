<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/common.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title></title>

<!-- 自定义css -->
<link href="${resourcesUrl}/css/customer.css" rel="stylesheet" />
</head>

<!-- Body -->
<body>

	<!-- MAIN PANEL -->
	<div>
		<!-- 路径导航开始 -->

		<ol class="breadcrumb">
			<li><a href="#">通讯录管理</a></li>
			<li class="active">组列表</li>
			
		</ol>
		
		<!-- 路径导航结束 -->

		<!-- 主体内容开始 -->
		<div id="container" class="content" style="padding-left:20px;padding-right:20px">
			<!-- 第一行开始 -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<!-- 表单开始 -->
				<form action="" class="form-horizontal">
					<!-- panel开始 -->
					<div class="panel panel-info">
						<div class="panel-heading"><i class="fa fa-search"></i>&nbsp;&nbsp;查询</div>
						<!-- panel-body开始 -->
						<div class="panel-body">
							
								<div class="row">

									<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
										<div class="form-group">
											<label for="taskName" class="col-sm-3 control-label">组名称</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="gName"
													placeholder="组名称">
											</div>
										</div>
									</div>

									
								</div>

						</div>
						<!-- panel-body结束 -->
						<div class="panel-footer text-right">
						<button type="button" name="retBtn" id="resetBtn"
								class="btn btn-default" onclick="location.href='${base}/friends'">返回</button>
							<button type="reset" name="resetBtn" id="resetBtn"
								class="btn btn-warning">重置</button>
							<button type="button" name="queryBtn" class="btn btn-primary"
								id="queryBtn">查询</button>
							<button type="button" name="addBtn" class="btn btn-info"
								id="addBtn" onclick="location.href='${base}/groups/new'">添加组</button>
							

						</div>
					</div>
					<!-- panel结束 -->
					</form>
					<!--表单结束 -->
				</div>
			
			</div>
			<!-- 第一行结束 -->

						<!-- 第二行开始 -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<!-- panel开始 -->
					<div class="panel panel-info">
						<div class="panel-heading"><i class="fa  fa-list"></i>&nbsp;&nbsp;组列表</div>

						<table id="commTable" data-sort-name="builddate"
							data-sort-order="desc"
							class="table table-striped table-bordered table-hover text-center">
							<thead>
								<tr>
									<th class="text-center" data-field="gName">组名称</th>
									<th class="text-center" data-field="gDetail">详细</th>
									<th class="text-center" data-formatter="operateFormatter"
										data-events="operateEvents"><i
										class="fa fa-fw fa-cog txt-color-blue hidden-md hidden-sm hidden-xs"></i>
										操作</th>
								</tr>
							</thead>
						</table>
						
						
					</div>
					<!-- panel结束 -->
				</div>
			</div>
			<!-- 第二行结束 -->

	
			</div>
		
		</div>
		<!-- END MAIN PANEL -->
	

		<!-- 包含footer，引入公用 JS -->
		<%@ include file="/WEB-INF/page/common/footer.jsp"%>
		<%@ include file="/WEB-INF/page/common/table.jsp"%>

		<!-- 用户自定义js -->
		<script src="${resourcesUrl}/js/group/groupList.js"></script>
</body>
</html>
