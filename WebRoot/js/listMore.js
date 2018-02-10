var send_type = '';
$(function(){
	send_type = $('#send_type').val();
	initDatagrid();
});
function initDatagrid(){ 
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("#tt")
			.jqGrid(
					{
						url : 'messageSend/getAjaxData.action?flag=1&send_type='+send_type,
						datatype : "json",
						height : "auto",
						autowidth : true,
						multiselect : false,// 复选框
						shrinkToFit : true,
						rowNum : 20,
						rownumbers: true,
						rowList : [ 10, 20, 30 ],
						colNames : [ '序号', '主题', '品类', '品牌', '机型', '发布人', '发布日期', '操作' ],
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
							width : 260
						}, {
							name : 'category',
							index : 'category',
							editable : true,
							width : 50
						}, {
							name : 'brand',
							index : 'brand',
							editable : true,
							width : 50
						}, {
							name : 'model',
							index : 'model',
							editable : true,
							width : 50
						}, {
							name : 'send_user',
							index : 'send_user',
							editable : true,
							width : 50
						}, {
							name : 'send_time',
							index : 'send_time',
							editable : true,
							width : 90
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
								var rowData = $("#tt").jqGrid('getRowData', cl);
								var update = "<input class='btn btn-outline btn-success' type='button' value='查看详情' onclick='loadDetails("+ cl + ")'/>&nbsp;";
								$("#tt").jqGrid('setRowData',ids[i],
								{
									opt : update
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
}
function loadDetails(id) {
	window.location.href = "messageSend/getInfoById.action?id="+id+"&opt=3";
};


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




