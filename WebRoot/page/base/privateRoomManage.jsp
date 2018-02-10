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
                        <li class="active"><a href="device/toLoadList.action">包房列表</a></li>
                    </ul>
					<!--查询-->
					 <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="room_id" class="sr-only">房间id</label>
                                <input type="text" placeholder="房间id" id="room_id" class="form-control">
                                <label for="room_name" class="sr-only">包房名称</label>
                                <input type="text" placeholder="包房名称" id="room_name" class="form-control">
                               <label for="userName" class="sr-only">创建人</label>
                                <input type="text" placeholder="创建人" id="userName" class="form-control">
                                <select class="form-control"  placeholder="包房类型"  id="room_type">
                                    <option value=''>包房类型</option>
                                    <s:iterator value="privateRoomTypeList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                                </select>
                                <select class="form-control"  placeholder="包房状态"  id="status">
                                    <option value=''>包房状态</option>
                                    <s:iterator value="privateRoomStrutsList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="privateRoom/toLoadList.action">刷新</a>
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
												url : 'privateRoom/getAjaxData.action',
												datatype : "json",
												height : "auto",
												autowidth : true,
												multiselect : false,//复选框    
												shrinkToFit:false,  
												autoScroll: true, 
												rowNum : 20,
												rownumbers: true,
												rowList : [ 10, 20, 30 ],
												colNames : [ 'ID','房间id',
														'创建人（房主）','包房名称', '包房类型',
														'包房状态', '包房时长', '每分钟收费', '每次抓取所需娃娃币', 
														'创建时间','更新时间','机构编码'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'room_id',
													index : 'room_id',
													editable : true,
													width : 200
												}, {
													name : 'userName',
													index : 'userName',
													editable : true,
													width : 120
												},{
													name : 'room_name',
													index : 'room_name',
													editable : true,
													width : 120
												}, {
													name : 'roomtype',
													index : 'roomtype',
													editable : true,
													width : 120
												},{
													name : 'privateStatus',
													index : 'privateStatus',
													editable : true,
													width : 80
												}, {
													name : 'duration',
													index : 'duration',
													editable : true,
													width : 80
												}, {
													name : 'money_minute',
													index : 'money_minute',
													editable : true,
													width : 100
												},{
													name : 'coin_once',
													index : 'coin_once',
													editable : true,
													width : 100
												},{
                                                    name : 'create_time',
                                                    index : 'create_time',
                                                    editable : true,
                                                    width : 200,
                                                    formatter : "datetime"
                                                }, {
                                                    name : 'update_timestamp',
                                                    index : 'update_timestamp',
                                                    editable : true,
                                                    width : 200,
                                                    formatter : "datetime"
                                                }, {
                                                    name : 'corp_code',
                                                    index : 'corp_code',
                                                    editable : true,
                                                    width : 90,
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
			var room_id = $('#room_id').val();
			var room_name = $('#room_name').val();
			var userName = $('#userName').val();
			var room_type = $('#room_type').val();
			var status = $('#status').val();
			$("#tt").jqGrid('setGridParam', {
				url : "privateRoom/getAjaxData.action",
				postData : {
					'room_id' : room_id,
					'room_name' : room_name,
					'userName' : userName,
					'room_type' : room_type,
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