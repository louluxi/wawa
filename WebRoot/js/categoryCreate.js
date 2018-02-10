$(function() {  
   $.ajax({  
       type : "POST",
		url : "category/getAllList.action?level=1",
        async: false,
		dataType : "json",
		success : function(result) {  
			$("#test_data").bsSuggest({
			    idField: "cat_name",  
			    keyField: "cat_code",
	            twoWayMatch: true,
	            multiWord: false,
	            showHeader: true,       //显示多个字段的表头
	            effectiveFields: ['cat_code','cat_name'],
	            effectiveFieldsAlias:{cat_code: "一级类代码", cat_name: "一级类描述"},   
	            data: {
	                'value': result
	            },
	            onSelected:function(result){
	                // Check if the result is not null
	                if(result!=null){
	                  $("#parentName").val(result.id); 
	                }
	              }
	        }).on('onSetSelectValue', function (e, keyword) {  
	            console.log('onSetSelectValue: ', keyword);  
                if(result!=null){
                	$("#parentName").val(keyword.id); 
                }
	        });
       }  
   }); 
});   
function checkUserCode(objVal) {
	$.ajax({
		type : "POST",
		url : "user/checkCode.action",
		data : {
			user_code : objVal
		},
		dataType : "json",
		success : function(result) {
			// var result = eval('('+result+')');
			if (result.result == 'false') {
				$('#alt').text("系统中不存在该采购员（编码：" + objVal + "）!");
				$('#user_code').val("");
			} else {
				$('#alt').text("验证通过");
				$('#user_id').val(result.user.id);
			}
		}
	});
}
function checkCatCode(objVal) {
	$.ajax({
		type : "POST",
		url : "category/checkCode.action",
		data : {
			cat_code : objVal
		},
		dataType : "json",
		success : function(result) {
			// var result = eval('('+result+')');
			if (result.result == 'false') {
				$('#catDesc').text("验证通过");
			} else {
				$('#catDesc').text("系统中已存在该品类编码,请重新输入！");
				$('#cat_code').val("");
			}
		}
	});
}
function checkParentCatCode(objVal) {
	$.ajax({
		type : "POST",
		url : "category/checkCode.action",
		data : {
			cat_code : objVal
		},
		dataType : "json",
		success : function(result) {
			// var result = eval('('+result+')');
			if (result.result == 'false') {
				$('#parentCodeDesc').text("验证通过");
			} else {
				$('#parentCodeDesc').text("系统中已存在该品类编码,请重新输入！");
				$('#parentCodeDesc').val("");
			}
		}
	});
}