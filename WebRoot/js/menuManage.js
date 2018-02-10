$(document).ready(function() {				
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("#tt").jqGrid({
		url : 'menu/getAjaxData.action?level=1',
		datatype : "json",
		height : "auto",
		autowidth : true,
		multiselect : false,// 复选框
		shrinkToFit : true,
		rowNum : 20,
		rownumbers: true,
		rowList : [ 10, 20, 30 ],
		colNames : [  '等级', '类型id','名称', '链接', '排序', '类型', '可见', '操作' ],
		colModel : [{
			name : 'level',
			index : 'level',
			editable : true,
			hidden : true,
			width : 80
		},{
			name : 'resource_type_id',
			index : 'resource_type_id',
			editable : true,
			hidden : true,
			width : 80
		},  {
			name : 'resource_name',
			index : 'resource_name',
			editable : true,
			width : 50
		}, {
			name : 'url',
			index : 'url',
			editable : true,
			width : 70
		}, {
			name : 'display_order',
			index : 'display_order',
			editable : true,
			width : 30
		}, {
			name : 'typeShow',
			index : 'typeShow',
			editable : true,
			width : 30
		}, {
			name : 'is_show',
			index : 'is_show',
			editable : true,
			width : 30
		}, {
			name : 'opt',
			index : 'opt',
			editable : true,
			width : 80
		} ],
		pager : "#pl",
		viewrecords : true,
		caption : null,
		hidegrid : false,
		gridComplete : function() {
			var ids = $("#tt").jqGrid(
					'getDataIDs');
			for ( var i = 0; i < ids.length; i++) {
				var cl = ids[i];
				var rowData = $("#tt").jqGrid(
						'getRowData', cl);
				var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("
						+ cl + ")'/>&nbsp;";
				var addAfter = "<input class='btn btn-outline btn-primary' type='button' value='添加下级' onclick='addAfter("
						+ cl
						+ ","
						+ rowData.level
						+ ")'/>&nbsp;";
				var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData("
						+ cl + ")'/>";
				var optStr = '';
				if(3 == rowData.resource_type_id){
					optStr = update + delet
				}else{
					optStr = update + addAfter + delet
				}
				$("#tt").jqGrid(
						'setRowData',
						ids[i],
						{
							opt : optStr
						});
			}
		},
		subGrid : true,// 开启子表格支持
		// 子表格的id；当子表格展开的时候，在主表格中会创建一个div元素用来容纳子表格，subgrid_id就是这个div的id
		subGridRowExpanded : function(
				subgrid_id, row_id) {// 子表格容器的id和需要展开子表格的行id
			var rowsData = $("#tt").jqGrid(
					'getRowData', row_id);
			if (rowsData.leaf != 'true') {
				bindSubGrid(subgrid_id, row_id);
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
function bindSubGrid(subgrid_id, collectLineId) {
var subgrid_table_id = subgrid_id + "_t";
var subgrid_pager_id = subgrid_id + "_pgr";
$("#" + subgrid_id).html(
"<table id='" + subgrid_table_id
	+ "' class='scroll'></table><div id='" + subgrid_pager_id
	+ "' class='scroll'></div>");
$("#" + subgrid_table_id)
.jqGrid(
	{
		url : 'menu/getAjaxData.action?parent_id=' + collectLineId,
		datatype : "json",
		height : 300,
		autowidth : true,
		multiselect : false,// 复选框
		shrinkToFit : true,
		rowNum : 20,
		rowList : [ 10, 20, 30 ],
		colNames : ['等级', '类型id', '名称', '链接', '排序', '类型', '可见', '操作' ],
		colModel : [ {
			name : 'level',
			index : 'level',
			editable : true,
			hidden : true,
			width : 80
		},{
			name : 'resource_type_id',
			index : 'resource_type_id',
			editable : true,
			hidden : true,
			width : 80
		}, {
			name : 'resource_name',
			index : 'resource_name',
			editable : true,
			width : 50
		}, {
			name : 'url',
			index : 'url',
			editable : true,
			width : 70
		}, {
			name : 'display_order',
			index : 'display_order',
			editable : true,
			width : 30
		}, {
			name : 'typeShow',
			index : 'typeShow',
			editable : true,
			width : 30
		}, {
			name : 'is_show',
			index : 'is_show',
			editable : true,
			width : 30
		}, {
			name : 'opt',
			index : 'opt',
			editable : true,
			width : 80
		} ],
		pager : "#" + subgrid_pager_id,
		viewrecords : true,
		caption : null,
		hidegrid : false,
		gridComplete : function() {
			var ids = $("#" + subgrid_table_id).jqGrid(
					'getDataIDs');
			for ( var i = 0; i < ids.length; i++) {
				var cl = ids[i];
				var rowData = $("#" + subgrid_table_id).jqGrid(
						'getRowData', cl);
				var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("
						+ cl + ")'/>&nbsp;";
				var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData("
						+ cl + ")'/>";
				var addAfter = "<input class='btn btn-outline btn-primary' type='button' value='添加下级' onclick='addAfter("
					+ cl
					+ ","
					+ rowData.level
					+ ")'/>&nbsp;";
				var optStr = '';
				if(3 == rowData.resource_type_id){
					optStr = update + delet
				}else{
					optStr = update + addAfter + delet
				}
				$("#" + subgrid_table_id).jqGrid('setRowData',
						ids[i], {
							opt : optStr
						});
			}
			// $(this).closest('.ui-jqgrid-view').find('div.ui-jqgrid-hdiv').hide();
		},
		subGrid : true,// 开启子表格支持
		// 子表格的id；当子表格展开的时候，在主表格中会创建一个div元素用来容纳子表格，subgrid_id就是这个div的id
		subGridRowExpanded : function(subgrid_id, row_id) {// 子表格容器的id和需要展开子表格的行id
			var rowsData = $("#" + subgrid_table_id).jqGrid(
					'getRowData', row_id);
			if (rowsData.leaf != 'true') {
				bindSubGrid(subgrid_id, row_id);
			}
		}
	});
}

function updateData(catId) {
	window.location.href = 'menu/getInfoById.action?opt=2&id=' + catId;
	searchInfo();
}
function addAfter(catId, level) {
	window.location.href = 'menu/getInfoById.action?opt=3&id=' + catId+ '&level=' + level;
	searchInfo();
}
function deleteData(catId) {
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
			url : "menu/delete.action",
			data : {
				ids : catId
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