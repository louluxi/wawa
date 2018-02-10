$(function(){
	initDatagrid();
});
function initDatagrid(){ 
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("#tt")
			.jqGrid(
					{
						url : 'messageSend/getAjaxData.action?send_status=saved',
						datatype : "json",
						height : "auto",
						autowidth : true,
						multiselect : false,// 复选框
						shrinkToFit : true,
						rowNum : 20,
						rownumbers: true,
						rowList : [ 10, 20, 30 ],
						colNames : [ '序号', '主题', '品类', '品牌', '机型', '日期','操作' ],
						colModel : [ {
							name : 'id',
							index : 'id',
							editable : true,
							hidden : true,
							key : true,
							width : 80
						}, {
							name : 'title',
							index : 'title',
							editable : true,
							width : 230
						}, {
							name : 'category',
							index : 'category',
							editable : true,
							width : 70
						}, {
							name : 'brand',
							index : 'brand',
							editable : true,
							width : 70
						}, {
							name : 'model',
							index : 'model',
							editable : true,
							width : 70
						}, {
							name : 'trigger_time',
							index : 'trigger_time',
							editable : true,
							width : 100
						}, {
							name : 'opt',
							index : 'opt',
							editable : true,
							width : 80
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
								$("#tt").jqGrid('setRowData',ids[i],
								{
									opt : update + delet
								});
							}
						}
					});
	// rownumbers添加序号列列头
	jQuery("#tt").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
	$("#tt").jqGrid('navGrid', '#pl', {}, {
		height : 200,
		reloadAfterSubmit : true
	});
	// Add responsive to jqGrid
	$(window).bind('resize', function() {
		var width = $('.jqGrid_wrapper').width();
		$('#tt').setGridWidth(width);
	});
}
function searchInfo(){
	var title = $('#title').val();
	var category = $('#category').val();
	var brand = $('#brand').val();
	var model = $('#model').val();
    $("#tt").jqGrid('setGridParam',{ 
        url:"messageSend/getAjaxData.action", 
        postData:{
        	'title':title,
        	'category':category,
        	'brand':brand,
        	'model':model
        }, //发送数据 
        page:1 
    }).trigger("reloadGrid"); //重新载入 
}


function updateData(mesId) {
	window.location.href = 'messageSend/getInfoById.action?opt=2&id=' + mesId;
}
function deleteData(mesId) {
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
			url : "messageSend/delete.action",
			data : {
				ids : mesId
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
