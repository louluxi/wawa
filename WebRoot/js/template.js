$(document).ready(
				function() {
					$.jgrid.defaults.styleUI = 'Bootstrap';
					$("#tt").jqGrid(
					{
						url: 'template/getAjaxData.action',
						datatype : "json",
						height : "auto",
						autowidth : true,
						multiselect : false,//复选框    
						shrinkToFit : true,
						rowNum : 20,
						rownumbers: true,
						rowList : [ 10, 20, 30 ],
						colNames : [ 'id', '一级类代码', '一级类描述', '二级类代码', '二级类描述', '三级类代码', '三级类描述', '模板说明', '创建时间', '操作' ],
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
							name : 'firstCode',
							index : 'firstCode',
							editable : true,
							width : 100
						}, {
							name : 'firstName',
							index : 'firstName',
							editable : true,
							width : 100
						},
						{
							name : 'secondCode',
							index : 'secondCode',
							editable : true,
							width : 100
						}, {
							name : 'secondName',
							index : 'secondName',
							editable : true,
							width : 100
						},
						{
							name : 'cat_code',
							index : 'cat_code',
							editable : true,
							width : 100
						}, {
							name : 'cat_name',
							index : 'cat_name',
							editable : true,
							width : 100
						}, {
							name : 'remark',
							index : 'remark',
							editable : true,
							width : 150
						},
						{
							name : 'update_time',
							index : 'update_time',
							editable : true,
							width : 100
						}, {
							name : 'opt',
							index : 'opt',
							editable : true,
							width : 150
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
				function searchInfo(){
					var name = $('#name').val();
					var searchPKey = $('#searchPKey').val();
		            $("#tt").jqGrid('setGridParam',{ 
		                url:"template/getAjaxData.action", 
		                postData:{'searchPKey':searchPKey}, //发送数据 
		                page:1 
		            }).trigger("reloadGrid"); //重新载入 
				}
				function updateData(id) {
					window.location.href = 'template/getInfoById.action?opt=2&menuId='+menuId+'&id=' + id;
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
							url : "template/delete.action",
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
