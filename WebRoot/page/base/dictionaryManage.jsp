<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>字典管理</title>
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<!-- jqgrid-->
<link href="css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<style type="text/css">
#searchForm {
	padding-left: 25px; 
}
input.btn.btn-outline.btn-primary {
	margin-left: 5px; 
}
</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li class="active"><a href="dictionary/toLoadList.action">字典列表</a></li>
						<li><a href="dictionary/getInfoById.action?opt=1">字典添加</a></li>
					</ul>

					<div class="ibox-title">
						<form role="form" class="form-inline">
							<div class="form-group">
								<label for="dictId" class="sr-only">字典名称</label> <input
									type="text" placeholder="字典名称" id="dictId" class="form-control">
								<label for="dictName" class="sr-only">字典内容</label> <input
									type="text" placeholder="字典内容" id="dictName"
									class="form-control">
							</div>
							<button class="btn btn-primary " type="button" onclick="searchInfo()">
								<i class="fa fa-search"></i>&nbsp;查询
							</button>
						</form>
					</div>
					
					<div class="ibox-content">
						<div class="jqGrid_wrapper">
							<table id="tt"></table>
							<div id="pl"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

		<!-- 全局js -->
		<script src="js/jquery.min.js?v=2.1.4"></script>
		<script src="js/bootstrap.min.js?v=3.3.6"></script>
		<!-- Peity -->
		<script src="js/plugins/peity/jquery.peity.min.js"></script>
		<!-- jqGrid -->
		<script src="js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
		<script src="js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
		<!-- 自定义js -->
		<script src="js/content.js?v=1.0.0"></script>

		<!-- Page-Level Scripts -->
		<script>
			$(document).ready(function() {
								$.jgrid.defaults.styleUI = 'Bootstrap';
								$("#tt").jqGrid({
													url : 'dictionary/getAjaxData.action',
													datatype : "json",
													height : "auto",
													autowidth : true,
													multiselect : true,//复选框    
													shrinkToFit : true,
													rowNum : 20,
													rowList : [ 10, 20, 30 ],
													colNames : [ '序号', '字典代码',
															'字典内容', '字典说明', '更新时间',
															'操作' ],
													colModel : [
															{
																name : 'id',
																index : 'id',
																editable : true,
																width : 30
															},
															{
																name : 'dictId',
																index : 'dictId',
																editable : true,
																width : 50
															},
															{
																name : 'dictName',
																index : 'dictName',
																editable : true,
																width : 60
															},
															{
																name : 'descript',
																index : 'descript',
																editable : true,
																width : 70
															},
															{
																name : 'update_timestamp',
																index : 'update_timestamp',
																editable : true,
																width : 60,
																formatter : "datetime"
															}, {
																name : 'opt',
																index : 'opt',
																editable : true,
																width : 120
															} ],
													pager : "#pl",
													viewrecords : true,
													caption : null,
													add : true,
													edit : true,
													addtext : 'Add',
													edittext : 'Edit',
													hidegrid : false,
													gridComplete : function() {
														var ids = $("#tt")
																.jqGrid(
																		'getDataIDs');
														for (var i = 0; i < ids.length; i++) {
															var cl = ids[i];
															var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("
																+ cl + ")'/>&nbsp;";
															var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData("
																+ cl + ")'/>";
															var insert = "<input class='btn btn-outline btn-primary' type='button' value='添加键值' onclick='addValue("
																	+ cl
																	+ ")'/>";
															$("#tt")
																	.jqGrid(
																			'setRowData',
																			ids[i],
																			{
																				opt : update
																						+ delet
																						+ insert
																			});
														}
													}
												});
								$("#tt").jqGrid('navGrid', '#pl', {
									edit : true,
									add : true,
									del : true,
									search : true
								}, {
									height : 200,
									reloadAfterSubmit : true
								});
								// Add responsive to jqGrid
								$(window).bind('resize', function() {
									var width = $('.jqGrid_wrapper').width();
									$('#tt').setGridWidth(width);
								});
							});
			
			function searchInfo() {
				var dictId = $('#dictId').val();
				var dictName = $('#dictName').val();
				if (dictId == "" && dictName == "") {
					$("#tt").jqGrid('setGridParam', {
						url : "dictionary/getAjaxData.action?root=123",
						postData : {
							'dictId' : dictId,
							'dictName' : dictName
						}, // 发送数据
						page : 1
					}).trigger("reloadGrid"); // 重新载入
				} else {
					$("#tt").jqGrid('setGridParam', {
						url : "dictionary/getAjaxData.action",
						postData : {
							'dictId' : dictId,
							'dictName' : dictName
						}, // 发送数据
						page : 1
					}).trigger("reloadGrid"); // 重新载入
				}

			}
			function updateData(catId) {
				window.location.href = 'dictionary/getInfoById.action?opt=2&id=' + catId;
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
						url : "dictionary/delete.action",
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
		</script>
</body>
</html>