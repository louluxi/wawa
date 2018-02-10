$(document).ready(
				function() {
					$.jgrid.defaults.styleUI = 'Bootstrap';
					$("#tt").jqGrid(
					{
						url: 'productPrice/getAjaxData.action',
						datatype : "json",
						height : "auto",
						autowidth : true,
						multiselect : true,//复选框    
						shrinkToFit : false,
						rowNum : 20,
						rowList : [ 10, 20, 30, 50, 100 ],
						colNames : [ '序号','状态', '物料号码', '价格','申请人', '申请日期', '审核人', '审批人'],
								colModel : [ {
									name : 'id',
									index : 'id',
									editable : true,
									width : 50,
									hidden : true,
									key : true
								},{
									name : 'status',
									index : 'status',
									editable : true,
									width : 100,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'material_num',
									index : 'material_num',
									editable : true,
									sorttype : "string",
									width : 100
								},{
									name : 'price',
									index : 'price',
									editable : true,
									width : 90,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'applyer_name',
									index : 'applyer_name',
									editable : true,
									sorttype : "string",
									width : 140
								}, {
									name : 'apply_time',
									index : 'apply_time',
									editable : true,
									width : 100,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'examine_name',
									index : 'examine_name',
									editable : true,
									width : 150,
									sorttype : "string",
									formatter : "string"
								}, {
									name : 'approval_name',
									index : 'approval_name',
									editable : true,
									width : 120,
									sorttype : "string",
									formatter : "string"
								}],
						pager: "#pl",
		                viewrecords: true,
		                caption: "",
		                hidegrid: false,
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
					var applyer_name = $('#applyer_name').val();
					var material_num = $('#material_num').val();
					var status = $('#status').val();
					var startTime = $('#start').val();
					var endTime = $('#end').val();
		            $("#tt").jqGrid('setGridParam',{ 
		                url:"productPrice/getAjaxData.action", 
		                postData:{
		                	'endTime':endTime,
		                	'startTime':startTime,
		                	'applyer_name':applyer_name,
		                	'status':status,
		                	'material_num':material_num
		                	}, //发送数据 
		                page:1 
		            }).trigger("reloadGrid"); //重新载入 
				}
				function updateData(id) {
					window.location.href = 'product/getInfoById.action?opt=2&menuId='+menuId+'&id=' + id;
				}
				
				function doShenpi(id) {
					var ids=$("#tt").jqGrid("getGridParam","selarrrow");
				    if(ids.length == 0){
				    	swal("未选择！", "请先选择数据。", "error");
				    	return;
				    }
					var productIds = ids.join(",");
					$.ajax({
							type : "POST",
							url : "productPrice/enquiyShenpi.action",
							data : {
								productIds : productIds
							},
							dataType : "text",
							success : function(result) {
								var result = eval('(' + result + ')');
								if (result.result) {
									swal("审批成功！", "您已经成功审批。", "success");
								} else {
									swal("审批失败！", "审批失败！", "error");
								}
								searchInfo();
							}
						});
				}
				
				function doShenhe() {
					var ids=$("#tt").jqGrid("getGridParam","selarrrow");
				    if(ids.length == 0){
				    	swal("未选择！", "请先选择数据。", "error");
				    	return;
				    }
					var productIds = ids.join(",");
					$.ajax({
							type : "POST",
							url : "productPrice/enquiyShenhe.action",
							data : {
								productIds : productIds
							},
							dataType : "text",
							success : function(result) {
								var result = eval('(' + result + ')');
								if (result.result) {
									swal("审核成功！", "您已经成功审核。", "success");
								} else {
									swal("审核失败！", "审核失败！", "error");
								}
								searchInfo();
							}
						});
				}
				
				function enquiybh() {
					var ids=$("#tt").jqGrid("getGridParam","selarrrow");
				    if(ids.length == 0){
				    	swal("未选择！", "请先选择数据。", "error");
				    	return;
				    }
					var productIds = ids.join(",");
					$.ajax({
							type : "POST",
							url : "productPrice/enquiybh.action",
							data : {
								productIds : productIds
							},
							dataType : "text",
							success : function(result) {
								var result = eval('(' + result + ')');
								if (result.result) {
									swal("驳回成功！", "您已经成功驳回。", "success");
								} else {
									swal("驳回失败！", "驳回失败！", "error");
								}
								searchInfo();
							}
						});
				}
