$(document).ready(function(){
	$('#birthday').datepicker({
		dateFormat : 'yy-mm-dd',
		changeYear : true, 
		changeMonth : true, 
		monthNamesShort : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', 
		'八月', '九月', '十月', '十一月', '十二月' ], 
		dayNamesMin: ['日','一','二','三','四','五','六'], 
		prevText : '<i class="fa fa-chevron-left"></i>',
		nextText : '<i class="fa fa-chevron-right"></i>',
		onSelect : function(selectedDate) {
		
		}
	});
	
	
	setForm();
	// 提交
	$('#submitBtn').click(function() {
		$("#commForm").submit();
	});
});

function setForm(){
	$("#commForm").validate({
		rules:{
			fName:{
				required:true
			},
			email:{
				email:true
			},
			birthday:{
				dateISO:true
			}
		},
		messages:{
			fName:{
				required:"请输入名称"
			},
			email:{
				email:"请输入正确的邮箱格式"
			},
			birthday:{
				dateISO:"请输入正确的日期格式(yyyy-MM-dd)"
			}
			
		},
		submitHandler : function(form) {
			$(form).ajaxSubmit({
				type:"POST",
				success : function(data) {
					if ("success" == data.code) {
						location.href=BASE+"friends";
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