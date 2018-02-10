$(document).ready(
		function() {
			$.jgrid.defaults.styleUI = 'Bootstrap';
			$("#tt")
					.jqGrid(
							{
								url : 'material/getAjaxAlertData.action',
								datatype : "json",
								height : "auto",
								autowidth : true,
								multiselect : true,// 复选框
								shrinkToFit : true,
								rownumbers: true,
								rowNum : 20,
								rownumbers: true,
								rowList : [ 10, 20, 30 ],
								colNames : [ 'id', '物料编号', '供应商编码','供应商名称', '物料描述'],
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
								},
								{
									name : 'lifnr',
									index : 'lifnr',
									editable : true,
									width : 80
								},
								{
									name : 'name1',
									index : 'name1',
									editable : true,
									width : 80
								}, {
									name : 'maktx',
									index : 'maktx',
									editable : true,
									width : 80
								}],
								pager : "#pl",
								viewrecords : true,
								caption : null,
								hidegrid : false,
								onSelectRow : function(id, state) {
									if(state) {
										var rowData = $("#tt").jqGrid('getRowData', id);
										$("#material").append('<div class="sty" id="'+id+'"><span>' + rowData.matnr + "-" + rowData.maktx + '</span><span class="glyphicon glyphicon-remove removeIcon" onclick="remove(this)"></span></div>');
									} else {
										$("#material #" + id).remove();
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
	var maktx = $('#maktx').val();
	$("#tt").jqGrid('setGridParam', {
		url : "material/getAjaxAlertData.action",
		postData : {
			'matnr' : matnr,
			'maktx' : maktx
		}, // 发送数据
		page : 1
	}).trigger("reloadGrid"); // 重新载入
}

function remove(obj) {
	var id = $(obj).parent().attr("id");
	jQuery("#tt").setSelection(id,true);  
	$(obj).parent().remove();
}

function getChecked() {
	var ids=$("#tt").jqGrid("getGridParam","selarrrow");
    var materials = "";
	for(var i = 0;i<ids.length;i++){
		var rowData = $("#tt").jqGrid('getRowData',ids[i]);
		materials = materials + rowData.matnr + "-" + rowData.maktx + ",";
	}
	materials = materials.substring(0,materials.length - 1);
	if($("#merge").is(":checked")) {
		var new_arr = [];
		var myArray = materials.split(",");
		for(var i=0;i<myArray.length;i++) {
			var items=myArray[i];
			if($.inArray(items,new_arr)==-1) {
				new_arr.push(items);
			}
		}
		materials = new_arr.join(",");
		if(window.parent.document.getElementById("sel").value == "1" && new_arr.length > 1) {
			swal("请注意","只能选择单物料！","error");
		} else {
			window.parent.document.getElementById("material").value=materials;
			window.parent.materialChange();
			window.parent.layer.closeAll();
		}
	}else{
		if(window.parent.document.getElementById("sel").value == "1" && ids.length > 1) {
			swal("请注意","只能选择单物料！","error");
		} else {
			window.parent.document.getElementById("material").value=materials;
			window.parent.materialChange();
			window.parent.layer.closeAll();
		}
	}
}

function clearSelect() {
	window.parent.document.getElementById("material").value="";
	window.parent.layer.closeAll();
}
function syncMaterialData(){
	window.location.href = 'material/syncMaterialData.action?menuId='+menuId;
}
function updateData(id) {
	window.location.href = 'material/getInfoById.action?opt=2&menuId='+menuId+'&id=' + id;
}
