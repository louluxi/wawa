$(function() {  
   $.ajax({  
       type : "POST",
		url : "category/getSearchList.action",
        async: false,
		dataType : "json",
		success : function(result) {  
			$("#test_data").bsSuggest({
			    idField: "id",  
			    keyField: "secondCatCodeName",
	            twoWayMatch: true,
	            multiWord: false,
	            showHeader: true,       //显示多个字段的表头
	            effectiveFields: ['secondCatCodeName','firstCatCodeName'],
	            effectiveFieldsAlias:{secondCatCodeName: "二级类代码-描述", firstCatCodeName: "一级类代码-描述"},   
	            data: {
	                'value': result
	            },
	            onSelected:function(result){
	                // Check if the result is not null
	                if(result!=null){
	                  $("#category_id").val(result.id); 
	                }
	              }
	        }).on('onSetSelectValue', function (e, keyword) {  
	            console.log('onSetSelectValue: ', keyword);  
                if(result!=null){
                  $("#category_id").val(keyword.id); 
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
           }  
       };  
       $('#treeview').treeview(options);  
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
				$('#codeDesc').text("系统中不存在该采购员（代码：" + objVal + "）!");
				$('#userCode').val("");
			} else {
				$('#codeDesc').text("验证通过");
				$('#userId').val(result.user.id);
			}
		}
	});
}
function getNext(parent_id) {
	$.ajax({
		type : "POST",
		url : "category/getCategoryData.action",
		data : {
			parent_id : parent_id
		},
		dataType : "text",
		success : function(result) {
			var result = eval('(' + result + ')');
			$("#secondCat").empty();
			$("#secondCat").prepend(
					"<option value='' hassubinfo='true'>请选择小分类</option>");
			var html = "";
			for ( var i = 0; i < result.length; i++) {
				var cate = result[i];
				html = html + "<option value='" + cate.id
						+ "' hassubinfo='true'>" + cate.cat_code + "</option>"
			}
			$("#secondCat").append(html); // 为Select追加一个Option(下拉项)
			$("#secondCat").trigger("chosen:updated");
		}
	});
}
function getThird(parent_id) {
	$.ajax({
		type : "POST",
		url : "category/getCategoryData.action",
		data : {
			parent_id : parent_id
		},
		dataType : "text",
		success : function(result) {
			var result = eval('(' + result + ')');
			$("#thirdCat").empty();
			$("#thirdCat").prepend(
					"<option value='' hassubinfo='true'>请选择子类</option>");
			var html = "";
			for ( var i = 0; i < result.length; i++) {
				var cate = result[i];
				html = html + "<option value='" + cate.id
						+ "' hassubinfo='true'>" + cate.cat_code + "</option>"
			}
			$("#thirdCat").append(html); // 为Select追加一个Option(下拉项)
			$("#thirdCat").trigger("chosen:updated");
		}
	});
}
function fieldAdd(obj) {
	$(obj).addClass("vis");
	var str = '<div><input type="text" name="param_name" placeholder="技术数据描述" class="addField" />';
		str = str + '<input type="text" name="remark" placeholder="技术数据备注" class="addField" />';
		str = str + '<span class="glyphicon glyphicon-plus addIcon" onclick="fieldAdd(this);"></span>';
		str = str + '<span class="glyphicon glyphicon-remove removeIcon" onclick="fieldRemove(this)"></span></div>';
	$("div#create").append(str);
}

function fieldRemove(obj) {
	$(obj).parent().prev().children("span").removeClass("vis");
	$(obj).parent().remove();
}