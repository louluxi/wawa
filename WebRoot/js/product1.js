$(document).ready(
				function() {
					$.jgrid.defaults.styleUI = 'Bootstrap';
					$("#tt").jqGrid(
					{
						url: 'product/getAjaxData.action?is_deleted=N',
						datatype : "json",
						height : "auto",
						autowidth : true,
						multiselect : true,//复选框    
						shrinkToFit : false,
						rowNum : 20,
						rowList : [ 10, 20, 30, 50, 100 ],
						colNames : [ '序号', '三级品类代码', '三级品类描述','供应商代码', '供应商名称', '物料号码', '物料描述','供应商物料编号',
									'供应商型号','品牌中文', '品牌英文', '产地', '最终用户','最终产品', '最终型号', '操作' ],
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
								}, {
									name : 'opt',
									index : 'opt',
									editable : true,
									width : 230,
									sortable : false
								} ],
						pager: "#pl",
		                viewrecords: true,
		                caption: "",
		                hidegrid: false,
						gridComplete : function() {
							var ids = $("#tt").jqGrid('getDataIDs');
							for ( var i = 0; i < ids.length; i++) {
								var cl = ids[i];
								var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("+ cl + ")'/>";
								var delet = "<input class='btn btn-outline btn-warning' style='margin-left: 3px;' type='button' value='删除' onclick='deleteData(" + cl + ")'/>";
								var examine = "<input class='btn btn-outline btn-primary' style='margin-left: 3px;' type='button' value='审核' onclick='examineData("+ cl + ")'/>";
								var approval = "<input class='btn btn-outline btn-default' style='margin-left: 3px;' type='button' value='审批' onclick='approvalData(" + cl + ")'/>";
								var bs = "";
								if($('#buttonString').val().indexOf("编辑") > 0){
									bs += update;
								}
								if($('#buttonString').val().indexOf("删除") > 0){
									bs += delet;
								}
								if($('#buttonString').val().indexOf("审核") > 0){
									bs += examine;
								}
								if($('#buttonString').val().indexOf("审批") > 0){
									bs += approval;
								}
								$("#tt").jqGrid('setRowData',ids[i],
										{
											opt : bs
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
				
				function searchInfo(){
					var cat_code = $('#cat_code').val();
					var cat_name = $('#cat_name').val();
					var supplier_code = $('#supplier_code').val();
					var material_num = $('#material_num').val();
					var startTime = $('#start').val();
					var endTime = $('#end').val();
					var user_type = $("input.user_type:checked")[0].value;
					var showNull ="";
					var isNull ="";
					if("3" == user_type){
						showNull = "1111";
						isNull = "1111";
						user_type = "";
					}else{
						isNull = "111";
					}
					
		            $("#tt").jqGrid('setGridParam',{ 
		                url:"product/getAjaxData.action?is_deleted=N", 
		                postData:{
		                	'endTime' : endTime,
		                	'startTime' : startTime,
		                	'cat_code' : cat_code,
		                	'cat_name' : cat_name,
		                	'supplier_code' : supplier_code,
		                	'material_num' : material_num,
		                	'isNull' : isNull,
		                	'showNull' : showNull,
							'user_type' : user_type
						}, //发送数据 
		                page:1 
		            }).trigger("reloadGrid"); //重新载入 
				}
				
				function exportData(){
					var ids = $('#tt').jqGrid('getGridParam', 'selarrrow');
					if(ids.length > 0){
						var productIds = ids.join(",");
						$('#productIds').val(productIds);
					}else{
						var cat_code = $('#cat_code').val();
						var cat_name = $('#cat_name').val();
						var supplier_code = $('#supplier_code').val();
						var material_num = $('#material_num').val();
						var startTime = $('#start').val();
						var endTime = $('#end').val();
						var user_type = $("input.user_type:checked")[0].value;
						var isNull = "";
						if($("input.isNull").prop("checked") == true) 
						{
							isNull = "111";
						}
						$("#cat_code1").val(cat_code);
						$("#cat_name1").val(cat_name);
						$("#supplier_code1").val(supplier_code);
						$("#material_num1").val(material_num);
						$("#startTime1").val(startTime);
						$("#endTime1").val(endTime);
						$("#isNull1").val(isNull);
						$("#user_type1").val(user_type);
					}
					$('#sform').submit();
				}
				
				function changeIsNull(){
					$('#isNull').attr('checked', true);
				}
				
				function updateData(id) {
					window.location.href = 'product/getInfoById.action?opt=2&menuId='+menuId+'&id=' + id;
				}
				function approvalData(id) {
					window.location.href = 'product/getInfoById.action?opt=5&menuId='+menuId+'&id=' + id;
				}
				function examineData(id) {
					window.location.href = 'product/getInfoById.action?opt=4&menuId='+menuId+'&id=' + id;
				}
				function deleteData(id) {
					swal({
						title : "您确定要删除这条信息吗",
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
									swal("删除成功！", "您已经删除了这条信息。", "success");
								} else {
									swal("删除失败！", "请联系系统管理员。", "error");
								}
								searchInfo();
							}
						});
					});
				}
				function toImport(){
					 //iframe层
				   layer.open({
				       type: 2,
				       title: '导入产品',
				       shadeClose: true,
				       shade: 0.8,
				       area: ['800px', '400px'],
				       content: 'product/toImport.action' //iframe的url
				   }); 
				}
				/*function exportData(){
					layer.open({
					       type: 2,
					       title: '导出产品',
					       shadeClose: true,
					       shade: 0.8,
					       area: ['800px', '400px'],
					       content: 'product/toExport.action' //iframe的url
					   }); 
				}*/
