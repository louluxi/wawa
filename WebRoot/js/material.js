$(document).ready(
		function() {
			$.jgrid.defaults.styleUI = 'Bootstrap';
			$("#tt")
					.jqGrid(
							{
								url : 'material/getAjaxData.action',
								datatype : "json",
								height : "auto",
								autowidth : true,
								multiselect : false,// 复选框
								shrinkToFit : true,
								rownumbers: true,
								rowNum : 20,
								rownumbers: true,
								rowList : [ 10, 20, 30,50,100 ],
								colNames : [ 'id', '物料编号', '供应商编码', '物料描述', '最终型号','物料组', '供应商名称','品牌',
												'产地', '最终产品', '工厂','一级类代码', '二级类代码', '同步日期', '操作' ],
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
									name : 'matnr',
									index : 'matnr',
									editable : true,
									width : 80
								}, {
									name : 'lifnr',
									index : 'lifnr',
									editable : true,
									width : 80
								},
								{
									name : 'maktx',
									index : 'maktx',
									editable : true,
									width : 80
								}, {
									name : 'zzzxh',
									index : 'zzzxh',
									editable : true,
									width : 80
								}, {
									name : 'matkl',
									index : 'matkl',
									editable : true,
									width : 80
								}, {
									name : 'name1',
									index : 'name1',
									editable : true,
									width : 90
								}, {
									name : 'zpp',
									index : 'zpp',
									editable : true,
									width : 100
								}, {
									name : 'zcd',
									index : 'zcd',
									editable : true,
									width : 80
								}, {
									name : 'zzzcp',
									index : 'zzzcp',
									editable : true,
									width : 80
								}, {
									name : 'werks',
									index : 'werks',
									editable : true,
									width : 90
								}, {
									name : 'zgjbs',
									index : 'zgjbs',
									editable : true,
									width : 100
								}, {
									name : 'zgjxl',
									index : 'zgjxl',
									editable : true,
									width : 80,
								}, {
									name : 'update_time',
									index : 'update_time',
									editable : true,
									width : 120,
								}, {
									name : 'opt',
									index : 'opt',
									editable : true,
									width : 100
								} ],
								pager : "#pl",
								viewrecords : true,
								caption : null,
								hidegrid : false,
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
			
			// Add responsive to jqGrid
			$(window).bind('resize', function() {
				var width = $('.jqGrid_wrapper').width();
				$('#tt').setGridWidth(width);
			});
		});

function searchInfo() {
	var matnr = $('#matnr').val();
	var zpp = $('#zpp').val();
	var zzzcp = $('#zzzcp').val();
	var zgjxl = $('#zgjxl').val();
	var maktx = $('#maktx').val();
	var startTime = $('#startTime').val();
	var endTime = $('#endTime').val();
	$("#tt").jqGrid('setGridParam', {
		url : "material/getAjaxData.action",
		postData : {
			'matnr' : matnr,
			'zpp' : zpp,
			'zzzcp' : zzzcp,
			'zgjxl' : zgjxl,
			'endTime' : endTime,
			'startTime' : startTime,
			'maktx' : maktx
		}, // 发送数据
		page : 1
	}).trigger("reloadGrid"); // 重新载入
}
function syncMaterialData(){
	window.location.href = 'material/syncMaterialData.action?menuId='+menuId;
}
function updateData(id) {
	window.location.href = 'material/getInfoById.action?opt=2&menuId='+menuId+'&id=' + id;
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
			url : "material/delete.action",
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
       title: '导入物料',
       shadeClose: true,
       shade: 0.8,
       area: ['380px', '230px'],
       content: 'material/toImport.action' //iframe的url
   }); 
}
function exportData(){
	window.location.href="material/exportData.action";
}