<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>套餐管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="meal/toLoadList.action">套餐列表</a></li>
                        <li><a href="meal/getInfoById.action?opt=1">新增套餐</a></li>
                    </ul>
					<!--查询-->
					 <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="price" class="sr-only">套餐价格</label>
                                <input type="text" placeholder="套餐价格" id="price" class="form-control">
                                <label for="device_name" class="sr-only">套餐名称</label>
                                <input type="name" placeholder="套餐名称" id="name" class="form-control">                      
                                <select class="form-control"  placeholder="套餐状态"  id="status">
                                    <option value=''>请选择套餐状态</option>
                                    <s:iterator value="mealStrutsList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            </div>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="meal/toLoadList.action">刷新</a>
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
												url : 'meal/getAjaxData.action',
												datatype : "json",
												height : "auto",
												autowidth : true,
												multiselect : false,//复选框    
												shrinkToFit:false, 									 
												autoScroll: true, 
												rowNum : 20,
												rownumbers: true,
												rowList : [ 10, 20, 30 ],
												colNames : ['充值套餐ID',
														'套餐价格', '娃娃币','奖励娃娃币',
														'套餐名称','套餐描述', 
														'套餐状态', '有效期起', 
														'有效期至', '创建时间',
														'更新时间','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'price',
													index : 'price',
													editable : true,
													width : 80
												},{
													name : 'doll_coin',
													index : 'doll_coin',
													editable : true,
													width : 80
												},{
                                                    name : 'reward_coin',
                                                    index : 'reward_coin',
                                                    editable : true,
                                                    width : 80
                                                },{
													name : 'name',
													index : 'name',
													editable : true,
													width : 80
												},{
													name : 'remark',
													index : 'remark',
													editable : true,
													width : 120
												}, {
													name : 'stateShow',
													index : 'stateShow',
													editable : true,	
													width : 120
												},{
													name : 'validity_start',
													index : 'validity_start',
													editable : true,
													width : 150
												}, {
													name : 'validity_end',
													index : 'validity_end',
													editable : true,
													width : 150
												}, {
													name : 'create_time',
													index : 'create_time',
													editable : true,
													width : 150
												}, {
													name : 'update_timestamp',
													index : 'update_timestamp',
													editable : true,
													width : 150
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
			var price = $('#price').val();
			var name = $('#name').val();
			var status = $('#status').val();
			$("#tt").jqGrid('setGridParam', {
				url : "meal/getAjaxData.action",
				postData : {
					'price' : price,
					'name' : name,
					'status' : status,
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function updateData(catId) {
			window.location.href = 'meal/getInfoById.action?opt=2&id=' + catId;
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
					url : "meal/delete.action",
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