/**
 * 组编辑JS
 */

/*
 * ========================= Query初始化 =========================
 */
$(document).ready(function() {
	initForm();
	getGroup();
});

/**
 * 初始化form
 */
function initForm() {
	// 设置from
	setFrom();
	// 提交
	$('#submitBtn').click(function() {
		$("#commForm").submit();
	});
}

// 设置form
function setFrom() {
	
	// 校验form
	var vform = $("#commForm").validate({
		rules : {
			gName : {
				required : true
			}
		},
		messages : {
			gName : {
				required : '请输入组名!'
			}
		},
		submitHandler : function(form) {
			$(form).ajaxSubmit({
				type:"put",
				success : function(data) {
					if ("success" == data.code) {
						location.href=BASE+"/groups";
					} 
					else {
						alert(data.msg);
					}
				}
			});
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
			element[0].focus();
			return false;
		}
	});
	
}

//获得组信息
var getGroup=function(){
	$.ajax({
		url : BASE + "groups/"+$("#gId").val(),
		dataType : "json",
		type:"get",
		async : true,
		data : {
			
		},
		beforeSend : function() {
			
		},
		error : function() {
			
		},
		success : function(data) {
			
			if(data.code=='success'){
				//写入组
				$("#gName").val(data.obj.gName);
				$("#gDetail").val(data.obj.gDetail);
			}
			else{
				alert(data.msg);
			}
			
		}
	});
}
