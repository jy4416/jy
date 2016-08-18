/**
 * 列表JS
 */

/*
 * ========================= Query初始化 =========================
 */
$(document).ready(function() {
	initTable();
});

/*
 * 列表操作
 */
function initTable(){
	var table=$('#commTable').bootstrapTable({
				method : 'get',
				cache:false,
				url : BASE+'friends',
				pagination : true,
				showPaginationSwitch :false,
				pageSize : 5,
				pageList : [ 5, 10, 15,20],
				search : false,
				showExport : false,
				sidePagination : 'server',
				queryParams : function(params) {
					params.fName = $('#fName').val();
					params.email = $('#email').val();
					return params;
				},
				responseHandler:responseHandler,
				onPostBody : function() {
					$('#commTable').bootstrapTable("resetView");
					$(".btn").popover({
						trigger : 'hover'
					});
				}
	});
	
	//分页操作
	$('#togglePagBtn').click(function() {
		$('#commTable').bootstrapTable('togglePagination');
	});
	
	//查询操作
	$('#queryBtn').click(function() {
		$('#commTable').bootstrapTable('selectPage',1);
	});
	
	$(window).resize(function() {
		$('#commTable').bootstrapTable('resetView');
	});
	
	//操作事件
	window.operateEvents = {
			//更新
	    'click .update': function (e, value, row, index) {
	    	location.href=BASE + '/friends/'+row.fId;
	    },
	    	//删除
		'click .delete': function (e, value, row, index) {
			fId=row.fId;
			delOperate();
	    }
	};

}

//获得服务器端数据
function responseHandler(res) {
	
	if("error"==res.RET_CODE){
		showAlert(res.RET_MSG);
		return res;
	}
	
    return res;
}

/*添加表格【操作】的内容*/
function operateFormatter(value, row, index) {
	var content='<a '
			+' class="update btn btn-xs btn-primary" '
			+' role=button '
			+' href="javascript:void(0)"> '
			+' 更新 '
			+' </a> '
			+'<a '
			+' class="delete btn btn-xs btn-danger" '
			+' role=button '
			+' href="javascript:void(0)"> '
			+' 删除 '
			+' </a> '
			;
	return content;
}

/*添加表格【性别】的内容*/
function operateSexFormatter(value, row, index) {
	var sex=row.sex;
	var content;
	if(sex==1){
		content="男";
	}else{
		content="女";
	}
	return content;
}



/*删除操作*/

var fId;//组ID
function delOperate(){
	
	if(confirm("是否删除组？")){
		deleteTask();
	}
}
//删除信息
var deleteTask=function(){
	$.ajax({
		url : BASE + "/friends/"+fId,
		dataType : "json",
		async : true,
		data : {
			
		},
		type : "DELETE",
		beforeSend : function() {
			
		},
		error : function() {
			
		},
		success : function(data) {
			
			if(data.code=='success'){
				alert(data.msg);
				$('#commTable').bootstrapTable('refresh');
			}
			else{
				alert(data.RET_MSG);
			}
			
		}
	});
}
