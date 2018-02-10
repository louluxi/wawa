function checkBrandCode(objVal) {
	$.ajax({
		type : "POST",
		url : "brand/checkCode.action",
		data : {
			brand_code : objVal
		},
		dataType : "json",
		success : function(result) {
			if (result.result != 'false') {
				$('#codeDesc').text("系统中已存在该品牌编码,请重新输入！");
				$('#brand_code').val("");
			} else {
				$('#codeDesc').text("验证通过");
			}
		}
	});
}