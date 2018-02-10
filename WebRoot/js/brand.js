$(document).ready(
		function() {
			$.jgrid.defaults.styleUI = 'Bootstrap';
			$("#tt")
					.jqGrid(
							{
								url : 'brand/getAjaxData.action',
								datatype : "json",
								height : "auto",
								autowidth : true,
								multiselect : false,// 复选框
								shrinkToFit : true,
								rowNum : 20,
								rownumbers: true,
								rowList : [ 10, 20, 30 ],
								colNames : [ 'id', '品牌',
										'品牌英文', '产地', '备注', '更新时间',
										'操作' ],
								colModel : [ {
									name : 'id',
									index : 'id',
									editable : true,
									hidden : true,
									key : true,
									width : 80
								},{
									name : 'brand_name',
									index : 'brand_name',
									editable : true,
									width : 80
								}, {
									name : 'brand_eng',
									index : 'brand_eng',
									editable : true,
									width : 90
								}, {
									name : 'producing_area',
									index : 'producing_area',
									editable : true,
									width : 90
								}, {
									name : 'brand_remark',
									index : 'brand_remark',
									editable : true,
									width : 90
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
								pager : "#pl",
								viewrecords : true,
								caption : null,
								hidegrid : true,
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
	var brand_name = $('#brand_name').val();
	var brand_eng = $('#brand_eng').val();
	var producing_area = $('#producing_area').val();
	$("#tt").jqGrid('setGridParam', {
		url : "brand/getAjaxData.action",
		postData : {
			'brand_name' : brand_name,
			'brand_eng' : brand_eng,
			'producing_area' : producing_area
		}, // 发送数据
		page : 1
	}).trigger("reloadGrid"); // 重新载入
}
function updateData(id) {
	window.location.href = 'brand/getInfoById.action?opt=2&menuId='+menuId+'&id=' + id;
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
			url : "brand/delete.action",
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
        title: '导入品牌',
        shadeClose: true,
        shade: 0.8,
        area: ['380px', '230px'],
        content: 'brand/toImport.action' //iframe的url
    }); 
}
function exportData(){
	window.location.href="brand/exportData.action";
}