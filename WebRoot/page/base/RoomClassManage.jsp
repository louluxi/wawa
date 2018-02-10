<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>轮播图管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="roomClass/toLoadList.action">房间类别列表</a></li>
                        <li><a href="roomClass/getInfoById.action?opt=1">房间类别新增</a></li>
                    </ul>
                     <!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="class_name" class="sr-only">类别名称：</label>
                                <input type="text" placeholder="类别名称" id="class_name" class="form-control">                         
                            </div>
                          
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询&nbsp;
                            </button>
                             
                        </form>
                    </div>
                    <a class="btn btn-primary" href="roomClass/toLoadList.action">刷新</a>
                    <!-- 主体表格 -->
						<div class="jqGrid_wrapper">
							<table id="tt"></table>
							<div id="pl"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Page-Level Scripts -->
	<script>
		$(document)
				.ready(
						function() {
							$.jgrid.defaults.styleUI = 'Bootstrap';
							$("#tt")
									.jqGrid(
											{
												url : 'roomClass/getAjaxData.action',
												datatype : "json",
												height : "auto",
												autowidth : true,
												multiselect : false,//复选框    
												shrinkToFit:false,  
												autoScroll: true, 
												rowNum : 20,
												rownumbers: true,
												rowList : [ 10, 20, 30 ],
												colNames : ['ID',
														'类别名称', '图标', '序号',
														'创建时间','更新时间','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'class_name',
													index : 'class_name',
													editable : true,
													width : 90
												}, {
													name : 'class_icon',
													index : 'class_icon',
													editable : true,
													width : 550
												}, {
													name : 'class_sort',
													index : 'class_sort',
													editable : true,
													width : 70
												}, {
													name : 'createtime',
													index : 'createtime',
													editable : true,
													width : 150,
													formatter:"datetime",
												}, {
                                                    name : 'update_timestamp',
                                                    index : 'update_timestamp',
                                                    editable : true,
                                                    width : 150,
                                                    formatter : "datetime"
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
													var ids = $("#tt").jqGrid(
															'getDataIDs');
													for (var i = 0; i < ids.length; i++) {
														var cl = ids[i];
														var update = "<input class='btn btn-outline btn-success' type='button' value='编辑' onclick='updateData("
																+ cl
																+ ")'/>&nbsp;";
														var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData("
																+ cl + ")'/>";
														$("#tt")
																.jqGrid(
																		'setRowData',
																		ids[i],
																		{
																			opt : update
																					+ delet
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
			var class_name = $('#class_name').val();
			$("#tt").jqGrid('setGridParam', {
				url : "roomClass/getAjaxData.action",
				postData : {
					'class_name' : class_name
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function updateData(catId) {
			window.location.href = 'roomClass/getInfoById.action?opt=2&id=' + catId;
			searchInfo();
		}
       //删除
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
					url : "roomClass/delete.action",
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