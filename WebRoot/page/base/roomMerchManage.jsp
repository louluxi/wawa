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
                        <li class="active"><a href="device/toLoadList.action">房间商品列表</a></li>
                    </ul>
					<!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="roomCode" class="sr-only">房间编号</label>
                                <input type="text" placeholder="房间编号" id="roomCode" class="form-control">
                                <label for="roomName" class="sr-only">房间名称</label>
                                <input type="text" placeholder="房间名称" id="roomName" class="form-control">
                                <label for="merch_num" class="sr-only">小于此数量</label>
                                <input type="text" placeholder="小于此数量" id="merch_num" class="form-control">                          
                                <select class="form-control"  placeholder="房间类别"  id="classID">
                                    <option value=''>房间类别</option>
                                    <s:iterator value="roomClassList" var="roomClass">
                                            <option value='<s:property value="#roomClass.id"/>'><s:property value="#roomClass.class_name"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="roomMerch/toLoadList.action">刷新</a>
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
												url : 'roomMerch/getAjaxData.action',
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
														'房间编号', '商品名称', '商品名称',
														'商品数量', '房间类别'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'roomCode',
													index : 'roomCode',
													editable : true,
													width : 80
												}, {
													name : 'roomName',
													index : 'roomName',
													editable : true,
													width : 200
												},{
													name : 'merchName',
													index : 'merchName',
													editable : true,
													width : 200
												}, {
													name : 'merch_num',
													index : 'merch_num',
													editable : true,
													width : 120
												},{
													name : 'className',
													index : 'className',
													editable : true,
													width : 100
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
			var roomCode = $('#roomCode').val();
			var roomName = $('#roomName').val();
			var merch_num = $('#merch_num').val();
			var classID = $('#classID').val();
			$("#tt").jqGrid('setGridParam', {
				url : "roomMerch/getAjaxData.action",
				postData : {
					'roomCode' : roomCode,
					'roomName' : roomName,
					'merch_num' : merch_num,
					'classID' : classID,
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       
	</script>
</body>
</html>