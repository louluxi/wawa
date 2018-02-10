<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>设备管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="device/toLoadList.action">设备列表</a></li>
                        <li><a href="device/getInfoById.action?opt=1">设备新增</a></li>
                    </ul>
					<!--查询-->
					 <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="device_code" class="sr-only">设备编号</label>
                                <input type="text" placeholder="设备编号" id="device_code" class="form-control">
                                <label for="device_name" class="sr-only">设备名称</label>
                                <input type="text" placeholder="设备名称" id="device_name" class="form-control">
                                <select class="form-control"  placeholder="设备类型"  id="device_type">
                                    <option value=''>设备类型</option>
                                    <s:iterator value="deviceTypeList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                                </select>
                                <select class="form-control"  placeholder="状态"  id="status">
                                    <option value=''>状态</option>
                                    <s:iterator value="deviceStatusList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="device/toLoadList.action">刷新</a>
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
												url : 'device/getAjaxData.action',
												datatype : "json",
												height : "auto",
												autowidth : true,
												multiselect : false,//复选框    
												shrinkToFit:false,  
												autoScroll: true, 
												rowNum : 20,
												rownumbers: true,
												rowList : [ 10, 20, 30 ],
												colNames : ['设备ID',
														'设备类型', '设备编号', '序列号',
														'批次号', '设备名称', 'IP', '端口号', '通信类型', '价格', '进货来源','设备状态',
														'备注','创建时间','更新时间','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'deviceType',
													index : 'deviceType',
													editable : true,
													width : 80
												}, {
													name : 'device_code',
													index : 'device_code',
													editable : true,
													width : 100
												},{
													name : 'device_num',
													index : 'device_num',
													editable : true,
													width : 80
												}, {
													name : 'batch_num',
													index : 'batch_num',
													editable : true,
													width : 110
												},{
													name : 'device_name',
													index : 'device_name',
													editable : true,
													width : 80
												}, {
													name : 'ip',
													index : 'ip',
													editable : true,
													width : 120
												}, {
													name : 'port',
													index : 'port',
													editable : true,
													width : 80
												}, {
													name : 'communication_type',
													index : 'communication_type',
													editable : true,
													width : 90
												}, {
													name : 'price',
													index : 'price',
													editable : true,
													width : 70
												}, {
													name : 'origin',
													index : 'origin',
													editable : true,
													width : 90
												}, {
													name : 'deviceStruts',
													index : 'deviceStruts',
													editable : true,
													width : 80
												}, {
													name : 'remark',
													index : 'remark',
													editable : true,
													width : 150,
												}, {
                                                    name : 'create_time',
                                                    index : 'create_time',
                                                    editable : true,
                                                    width : 100,
                                                    formatter : "datetime"
                                                }, {
                                                    name : 'update_timestamp',
                                                    index : 'update_timestamp',
                                                    editable : true,
                                                    width :100,
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
			var device_type = $('#device_type').val();
			var device_code = $('#device_code').val();
			var device_name = $('#device_name').val();
			var status = $('#status').val();
			$("#tt").jqGrid('setGridParam', {
				url : "device/getAjaxData.action",
				postData : {
					'device_type' : device_type,
					'device_code' : device_code,
					'device_name' : device_name,
					'status' : status,
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function updateData(catId) {
			window.location.href = 'device/getInfoById.action?opt=2&id=' + catId;
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
					url : "device/delete.action",
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