$(document).ready(
				function() {
					$.jgrid.defaults.styleUI = 'Bootstrap';
					$("#tt").jqGrid(
					{
						url: 'product/getAjaxData.action?is_deleted=Y',
						datatype : "json",
						height : "auto",
						autowidth : true,
						multiselect : true,//复选框    
						shrinkToFit : false,
						rowNum : 20,
						rowList : [ 10, 20, 30, 50, 100 ],
						colNames : [ '序号', '三级品类代码', '三级品类描述','供应商代码', '供应商名称', '物料号码', '物料描述','供应商物料编号',
									'供应商型号','品牌中文', '品牌英文', '产地', '最终用户','最终产品', '最终型号', '审核状态'],
								colModel : [ {
									name : 'id',
									index : 'id',
									editable : true,
									width : 50,
									hidden : true,
									key : true
								},{
									name : 'cat_code',
									index : 'cat_code',
									editable : true,
									width : 100,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'cat_name',
									index : 'cat_name',
									editable : true,
									sorttype : "string",
									width : 100
								},{
									name : 'supplier_code',
									index : 'supplier_code',
									editable : true,
									width : 90,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'supplier_name',
									index : 'supplier_name',
									editable : true,
									sorttype : "string",
									width : 140
								}, {
									name : 'material_num',
									index : 'material_num',
									editable : true,
									width : 100,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'material_desc',
									index : 'material_desc',
									editable : true,
									width : 150,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'supplier_num',
									index : 'supplier_num',
									editable : true,
									width : 120,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'supplier_model',
									index : 'supplier_model',
									editable : true,
									width : 90,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'brand_cn',
									index : 'brand_cn',
									width : 100,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'brand_en',
									index : 'brand_en',
									width : 100,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'origin',
									index : 'origin',
									editable : true,
									width : 60,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'final_user',
									index : 'final_user',
									editable : true,
									width : 80,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'wgbez',
									index : 'wgbez',
									editable : true,
									sorttype : "string",
									width : 90
								}, {
									name : 'lastxh',
									index : 'lastxh',
									editable : true,
									width : 80,
									sorttype : "string",
									formatter : "string"
								},  {
									name : 'status',
									index : 'status',
									editable : true,
									width : 120,
									sorttype : "string",
									formatter : "string"
								}],
						pager: "#pl",
		                viewrecords: true,
		                caption: "",
		                hidegrid: false,
						gridComplete : function() {
							var ids = $("#tt").jqGrid('getDataIDs');
							for ( var i = 0; i < ids.length; i++) {
								var cl = ids[i];
								var rowData = $("#tt").jqGrid('getRowData',ids[i]);
								var status = rowData.status;
								var ss = "用户已删除";
								if(parseInt(status) == 7){
									ss = "删除待审核";
								}
								if(parseInt(status) == 8){
									ss = "删除待审批";
								}
								$("#tt").jqGrid('setRowData',ids[i],
										{
											status : ss
								});
								
							}
						}
					});
					// rownumbers添加序号列列头
					jQuery("#tt").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
					// Add responsive to jqGrid
					$(window).bind('resize', function() {
						var width = $('.jqGrid_wrapper').width();
						$('#tt').setGridWidth(width);
					});
					

					$('#start').date_input();
		            $('#end').date_input();
				});
				
				var left1;
				var left2;
				var i = 0;
				function cl(obj) {
					i++;
					var ob = $(obj).next("div.date_selector");
					var count = parseInt(ob.css("left")) - 499;
					ob.removeAttr("style");
					ob.css("display","block").css("position","absolute").css("top","30px")
					if(i == 1) {
						left1 = count;
						ob.css("left", left1);
					} else if(left1 != count) {
						left2 == count;
						ob.css("left", left2);
					}
					$("div.date_selector").not(ob).removeAttr("style");
				}
				function searchInfo(){
					var cat_code = $('#cat_code').val();
					var cat_name = $('#cat_name').val();
					var startTime = $('#start').val();
					var endTime = $('#end').val();
		            $("#tt").jqGrid('setGridParam',{ 
		                url:"product/getAjaxData.action?is_deleted=Y", 
		                postData:{'endTime':endTime,'startTime':startTime,'cat_code':cat_code,'cat_name':cat_name}, //发送数据 
		                page:1 
		            }).trigger("reloadGrid"); //重新载入 
				}
				function updateData(id) {
					window.location.href = 'product/getInfoById.action?opt=2&menuId='+menuId+'&id=' + id;
				}
				function deleteData(id) {
					swal({
						title : "您确定要提交删除这些数据吗",
						text : "删除后将无法恢复，请谨慎操作！",
						type : "warning",
						showCancelButton : true,
						confirmButtonColor : "#DD6B55",
						confirmButtonText : "删除",
						cancelButtonText: "取消",
						closeOnConfirm : false
					}, function() {
						$.ajax({
							type : "POST",
							url : "product/delete.action",
							data : {
								id : id
							},
							dataType : "text",
							success : function(result) {
								var result = eval('(' + result + ')');
								if (result.result) {
									swal("删除成功！", "您已经删除了这些数据。", "success");
								} else {
									swal("删除失败！", "请联系系统管理员。", "error");
								}
								searchInfo();
							}
						});
					});
				}
				
				function doDelete(id) {
					var ids=$("#tt").jqGrid("getGridParam","selarrrow");
				    if(ids.length == 0){
				    	swal("未选择！", "请先选择数据。", "error");
				    	return;
				    }
					swal({
						title : "您确定要申请删除这些数据吗",
						text : "请谨慎操作！",
						type : "warning",
						showCancelButton : true,
						confirmButtonColor : "#DD6B55",
						confirmButtonText : "确定",
						cancelButtonText: "取消",
						closeOnConfirm : false
					}, function() {
						for(var i = 0;i<ids.length;i++){
							$.ajax({
								type : "POST",
								url : "product/doDelete.action",
								data : {
									id : ids[i]
								},
								dataType : "text",
								success : function(result) {
									var result = eval('(' + result + ')');
									if (result.result) {
										swal("提交删除成功！", "请等待审核人员审核。", "success");
									} else {
										swal("提交删除失败！", "请联系系统管理员。", "error");
									}
									searchInfo();
								}
							});
						}
					});
				}
				
				function doShenpi(id) {
					var ids=$("#tt").jqGrid("getGridParam","selarrrow");
				    if(ids.length == 0){
				    	swal("未选择！", "请先选择数据。", "error");
				    	return;
				    }
					swal({
						title : "您确定要删除这些数据吗",
						text : "删除后将无法恢复，请谨慎操作！",
						type : "warning",
						showCancelButton : true,
						confirmButtonColor : "#DD6B55",
						confirmButtonText : "删除",
						cancelButtonText: "取消",
						closeOnConfirm : false
					}, function() {
						for(var i = 0;i<ids.length;i++){
							$.ajax({
								type : "POST",
								url : "product/doShenpi.action",
								data : {
									id : ids[i]
								},
								dataType : "text",
								success : function(result) {
									var result = eval('(' + result + ')');
									if (result.result) {
										swal("删除成功！", "您已成功删除这些数据", "success");
									} else {
										swal("删除失败！", "请联系系统管理员。", "error");
									}
									searchInfo();
								}
							});
						}
					});
				}
				
				function doShenhe() {
					var ids=$("#tt").jqGrid("getGridParam","selarrrow");
				    if(ids.length == 0){
				    	swal("未选择！", "请先选择数据。", "error");
				    	return;
				    }
					swal({
						title : "您确定要审核通过这些数据吗",
						text : "请谨慎操作！",
						type : "warning",
						showCancelButton : true,
						confirmButtonColor : "#DD6B55",
						confirmButtonText : "确定",
						cancelButtonText: "取消",
						closeOnConfirm : false
					}, function() {
						for(var i = 0;i<ids.length;i++){
							$.ajax({
								type : "POST",
								url : "product/doShenhe.action",
								data : {
									id : ids[i]
								},
								dataType : "text",
								success : function(result) {
									var result = eval('(' + result + ')');
									if (result.result) {
										swal("审核成功！", "请等待审批人员审批", "success");
									} else {
										swal("审核失败！", "请联系系统管理员。", "error");
									}
									searchInfo();
								}
							});
						}
					});
				}
