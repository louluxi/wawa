<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<!-- jqgrid-->
<link href="css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<style type="text/css">
input.btn.btn-outline.btn-success {
	margin-left: 5px; 
}
</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li class="active"><a href="role/toLoadList.action">角色列表</a></li>
						<li><a href="role/getInfoById.action?opt=1">角色添加</a></li>
					</ul>
					
					
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
													url : 'role/getAjaxData.action',
													datatype : "json",
													height : "auto",
													autowidth : true,
													multiselect : false,//复选框    
													shrinkToFit : true,
													rowNum : 20,
													rownumbers: true,
													rowList : [ 10, 20, 30 ],
													colNames : [ '序号', '角色编码',	'角色名称', '角色描述', '更新时间', '操作' ],
													colModel : [
															{
																name : 'id',
																index : 'id',
																editable : true,
																hidden : true,
																key : true,
																width : 30
															},
															{
																name : 'role_id',
																index : 'role_id',
																editable : true,
																width : 50
															},
															{
																name : 'role_name',
																index : 'role_name',
																editable : true,
																width : 60
															},
															{
																name : 'role_desc',
																index : 'role_desc',
																editable : true,
																width : 60
															},
															{
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
														var ids = $("#tt")
																.jqGrid(
																		'getDataIDs');
														for (var i = 0; i < ids.length; i++) {
															var cl = ids[i];
															var update = "<input class='btn btn-outline btn-success' type='button' value='修改' onclick='updateData("
																	+ cl
																	+ ")'/>&nbsp;";
															var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData("
																	+ cl
																	+ ")'/>";
															$("#tt").jqGrid(
																			'setRowData',
																			ids[i],
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
					$("#tt").jqGrid('setGridParam', {
						url : "role/getAjaxData.action?root=123",
						page : 1
					}).trigger("reloadGrid"); // 重新载入

			}
			function distribute() {
				window.location.href = 'role/getInfoById.action?opt=4';
			}
			function updateData(catId) {
				window.location.href = 'role/getInfoById.action?opt=2&id=' + catId;
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
						url : "role/delete.action",
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