$(document).ready(
		function() {
			$.jgrid.defaults.styleUI = 'Bootstrap';
			$("#tt")
					.jqGrid(
							{
								url : 'factory/getAjaxData.action?root=123',
								datatype : "json",
								height : "auto",
								autowidth : true,
								multiselect : false,// 复选框
								shrinkToFit : true,
								rowNum : 20,
								rownumbers: true,
								rowList : [ 10, 20, 30 ],
								colNames : [ 'id', '是否有子节点', '等级', '公司代码','公司简称',
												'公司描述','采购组','备注', '更新时间', '操作' ],
										colModel : [ {
											name : 'id',
											index : 'id',
											editable : true,
											hidden : true,
											key : true,
											width : 80
										}, {
											name : 'leaf',
											index : 'leaf',
											editable : true,
											hidden : true,
											width : 80
										}, {
											name : 'level',
											index : 'level',
											editable : true,
											hidden : true,
											width : 80
										}, {
											name : 'factory_code',
											index : 'factory_code',
											editable : true,
											width : 80
										}, {
											name : 'abbreviation',
											index : 'abbreviation',
											editable : true,
											width : 80
										}, {
											name : 'factory_name',
											index : 'factory_name',
											editable : true,
											width : 150
										}, {
											name : 'purchase_group',
											index : 'purchase_group',
											editable : true,
											width : 50
										}, {
											name : 'remark',
											index : 'remark',
											editable : true,
											width : 100
										}, {
											name : 'update_timestamp',
											index : 'update_timestamp',
											editable : true,
											formatter : "datetime",
											width : 90
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
										var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("+ cl + ")'/>&nbsp;";
										var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData(" + cl + ")'/>";
										var bs = "";
										if($('#buttonString').val().indexOf("编辑") > 0){
											bs += update;
										}
										if($('#buttonString').val().indexOf("删除") > 0){
											bs += delet;
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
		});

function searchInfo() {
	var factory_code = $('#factory_code').val();
	var factory_name = $('#factory_name').val();
	if (factory_code == "" && factory_name == "") {
		$("#tt").jqGrid('setGridParam', {
			url : "factory/getAjaxData.action?root=123",
			postData : {
				'factory_code' : factory_code,
				'factory_name' : factory_name
			}, // 发送数据
			page : 1
		}).trigger("reloadGrid"); // 重新载入
	} else {
		$("#tt").jqGrid('setGridParam', {
			url : "factory/getAjaxData.action",
			postData : {
				'factory_code' : factory_code,
				'factory_name' : factory_name
			}, // 发送数据
			page : 1
		}).trigger("reloadGrid"); // 重新载入
	}

}
function updateData(factoryId) {
	window.location.href = 'factory/getInfoById.action?opt=2&menuId='+menuId+'&id=' + factoryId;
}
function addAfter(factoryId, level) {
	window.location.href = 'factory/getInfoById.action?opt=3&menuId='+menuId+'&id=' + factoryId + '&level=' + level;
}
function deleteData(factoryId) {
	swal({
		title : "您确定要删除这条信息吗",
		text : "删除后将无法恢复，请谨慎操作！",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "删除",
		cancelButtonText : "取消",
		closeOnConfirm : false
	}, function() {
		$.ajax({
			type : "POST",
			url : "factory/delete.action",
			data : {
				ids : factoryId
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
       title: '导入工厂',
       shadeClose: true,
       shade: 0.8,
       area: ['380px', '230px'],
       content: 'factory/toImport.action' //iframe的url
   }); 
}
function exportData(){
	window.location.href="factory/exportData.action?level=2";
}