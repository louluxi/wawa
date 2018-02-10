var data1 = [];  
$(function() {  
	 $.ajax({  
	       type : "POST",
			url : "category/getSearchList.action?third=123",
	        async: false,
			dataType : "json",
			success : function(result) {  
				$("#test_data").bsSuggest({
				    idField: "thirdId",  
				    keyField: "thirdCatCodeName",
		            twoWayMatch: true,
		            multiWord: false,
		            showHeader: true,       //显示多个字段的表头
		            effectiveFields: ['thirdCatCodeName','secondCatCodeName','firstCatCodeName'],
		            effectiveFieldsAlias:{thirdCatCodeName: "三级类代码-描述",secondCatCodeName: "二级类代码-描述", firstCatCodeName: "一级类代码-描述"},   
		            data: {
		                'value': result
		            },
		            onSelected:function(result){
		                // Check if the result is not null
		                if(result!=null){
		                  $("#templateId").val(result.id); 
		                  getSkill(result.thirdId);
		                }
		              }
		        }).on('onSetSelectValue', function (e, keyword) {  
		        	if(result!=null){
	                  $("#templateId").val(keyword.id); 
	                  getSkill(keyword.id);
	                }
		        });
	       }  
	   }); 
    $("#catName").click(function() {  
       var options = {  
           bootstrap2 : false,  
           showTags : true,  
           levels : 1,  
           ExpandDepth:0,
           showCheckbox : false,  
           checkedIcon : "glyphicon glyphicon-check",  
           data : data1,  
           onNodeSelected : function(event, data) {  
               $("#catName").val(data.text);  
               $("#catId").val(data.id);  
               $("#treeview").hide();  
               getSkill(data.id);
           }  
       };  
       $('#treeview').treeview(options);  
   });   
});  
function getSkill(catId) {
	$.ajax({  
	       type : "POST",
			url : "product/getSkill.action?id=" + catId,
			dataType : "json",
			success : function(result) {  
				$('#skillDiv').html('');
				var html="";
				for(var i =0;i<result.length;i++){
					html = html + '<div class="form-group col-md-6">';
					html = html + '<input type="hidden" name="paramIds" value="'+result[i].id+'"/>';
					html = html + '<label class="col-sm-3 control-label">'+result[i].param_name+'：</label>';
					html = html + '<div class="col-sm-8 input-group">';
					html = html + '<input type="text" name="paramValues" class="form-control" placeholder="'+result[i].param_name+'">'
					html = html + '</div></div>';
				}
				$('#skillDiv').html(html);
	       }  
	   }); 
}
function checkBrandCode(objVal) {
	$.ajax({
		type : "POST",
		url : "brand/checkCode.action",
		data : {
			brand_code : objVal
		},
		dataType : "json",
		success : function(result) {
			if (result.result == 'false') {
				$('#codeDesc').text("系统中不存在该品牌编码,请重新输入！");
				$('#brand_code').val("");
			} else {
				$('#brandId').val(result.brand.id);
				$('#codeDesc').text("验证通过");
			}
		}
	});
}