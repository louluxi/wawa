$(document).ready(
		function() {
			$.jgrid.defaults.styleUI = 'Bootstrap';
			$("#tt")
					.jqGrid(
							{
								url : 'model/getAjaxData.action',
								datatype : "json",
								height : "auto",
								autowidth : true,
								multiselect : false,// 复选框
								shrinkToFit : true,
								rowNum : 20,
								rownumbers: true,
								rowList : [ 10, 20, 30 ],
								colNames : [ '序号', '工厂代码', '物料号', '产品型号', '需求数量','计量单位', 'BOM组件','子项物料描述', '更新时间', '操作' ],
								colModel : [ 
								 {
									name : 'id',
									index : 'id',
									editable : true,
									hidden:true,
									key:true,
									width : 80
								},
								{
									name : 'factory_code',
									index : 'factory_code',
									editable : true,
									width : 60
								}, {
									name : 'material_code',
									index : 'material_code',
									editable : true,
									width : 90
								}, {
									name : 'product_model',
									index : 'product_model',
									editable : true,
									width : 120
								}, {
									name : 'demand_num',
									index : 'demand_num',
									editable : true,
									width : 70
								}, {
									name : 'measurement_unit',
									index : 'measurement_unit',
									editable : true,
									width : 80
								}, {
									name : 'bom_assembly',
									index : 'bom_assembly',
									editable : true,
									width : 90
								}, {
									name : 'subitem_material_desc',
									index : 'subitem_material_desc',
									editable : true,
									width : 150
								}, {
									name : 'update_timestamp',
									index : 'update_timestamp',
									editable : true,
									width : 80,
									formatter : "datetime"
								}, {
									name : 'opt',
									index : 'opt',
									editable : true,
									width : 100
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
										var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData(" + cl + ")'/>";
										$("#tt").jqGrid('setRowData',ids[i],
												{
													opt : update + delet
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
		});

function searchInfo() {
	var material_code = $('#material_code').val();
	var product_model = $('#product_model').val();
	var bom_assembly = $('#bom_assembly').val();
	var subitem_material_desc = $('#subitem_material_desc').val();
	$("#tt").jqGrid('setGridParam', {
		url : "model/getAjaxData.action",
		postData : {
			'material_code' : material_code,
			'product_model' : product_model,
			'bom_assembly' : bom_assembly,
			'subitem_material_desc' : subitem_material_desc
		}, // 发送数据
		page : 1
	}).trigger("reloadGrid"); // 重新载入
}
function updateData(id) {
	window.location.href = 'model/getInfoById.action?opt=2&id=' + id;
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
			url : "model/delete.action",
			data : {
				ids : id
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
       title: '导入机型',
       shadeClose: true,
       shade: 0.8,
       area: ['380px', '230px'],
       content: 'model/toImport.action' //iframe的url
   }); 
}
function exportData(){
	window.location.href="model/exportData.action";
}