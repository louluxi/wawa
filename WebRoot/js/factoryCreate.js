function checkCatCode(objVal) {
	$.ajax({
		type : "POST",
		url : "factory/checkCode.action",
		data : {
			factory_code : objVal
		},
		dataType : "json",
		success : function(result) {
			// var result = eval('('+result+')');
			if (result.result == 'false') {
				$('#codeDesc').text("验证通过");
			} else {
				$('#codeDesc').text("系统中已存在该工厂编码,请重新输入！");
				$('#factory_code').val("");
			}
		}
	});
}