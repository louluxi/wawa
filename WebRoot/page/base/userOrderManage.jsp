<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>会员订单查看</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<script type="text/javascript">
  $(function(){
    $('.date_picker').date_input();
  })
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="userOrder/toLoadList.action">会员订单列表</a></li>
                    </ul>
					<!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="user_code" class="sr-only">用户代码</label>
                                <input type="text" placeholder="用户代码" id="user_code" class="form-control">
                                <label for="user_code" class="sr-only">昵称</label>
                                <input type="text" placeholder="昵称" id="nick_name" class="form-control">
                                <select class="form-control"  placeholder="订单状态"  id="status">
                                    <option value=''>订单状态</option>
                                    <s:iterator value="orderStrutsList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                                </select>
                                <label for="beginTime" class="sr-only">创建订单最小时间</label>
                                <input  name="meal.validity_start"  placeholder="创建订单最小时间" style="width:200px; line-height:15px;  display:inline-block" type="text" class="form-control date_picker" id="beginTime"  />
                                <label for="endTime" class="sr-only">创建订单最大时间</label>~至~
                               <input  name="meal.validity_start"  placeholder="创建订单最大时间" style="width:200px; line-height:15px;  display:inline-block" type="text" class="form-control date_picker" id="endTime"  />
                            </div>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="userOrder/toLoadList.action">刷新</a>
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
												url : 'userOrder/getAjaxData.action',
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
														'用户代码', '昵称', '微信号',
														'商品名称', '订单状态', '订单号', '收货地址', '订单时间', '发货单号', '快递公司','发货人',
														'发货时间','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'user_code',
													index : 'user_code',
													editable : true,
													width : 80
												}, {
													name : 'nick_name',
													index : 'nick_name',
													editable : true,
													width : 80
												},{
													name : 'wechat',
													index : 'wechat',
													editable : true,
													width : 120
												}, {
													name : 'merch_name',
													index : 'merch_name',
													editable : true,
													width : 120
												},{
													name : 'statusShow',
													index : 'statusShow',
													editable : true,
													width : 80
												}, {
													name : 'order_code',
													index : 'order_code',
													editable : true,
													width : 80
												}, {
													name : 'detail',
													index : 'detail',
													editable : true,
													width : 60
												},{
                                                    name : 'create_time',
                                                    index : 'create_time',
                                                    editable : true,
                                                    width : 90,
                                                    formatter : "datetime"
                                                }, {
													name : 'express_no',
													index : 'express_no',
													editable : true,
													width : 70
												}, {
													name : 'express_company',
													index : 'express_company',
													editable : true,
													width : 90
												}, {
													name : 'sender_name',
													index : 'sender_name',
													editable : true,
													width : 80
												},{
                                                    name : 'send_time',
                                                    index : 'send_time',
                                                    editable : true,
                                                    width : 90,
                                                    formatter : "datetime"
                                                },  {
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
														var update = "<input class='btn btn-outline btn-success' type='button' value='订单处理' onclick='updateData("
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
			var user_code = $('#user_code').val();
			var nick_name = $('#nick_name').val();
			var status = $('#status').val();
			var beginTime = $('#beginTime').val();
			var endTime = $('#endTime').val();
			$("#tt").jqGrid('setGridParam', {
				url : "userOrder/getAjaxData.action",
				postData : {
					'user_code' : user_code,
					'nick_name' : nick_name,
					'status' : status,
					'beginTime' : beginTime,
					'endTime' : endTime
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function updateData(catId) {
			window.location.href = 'userOrder/getInfoById.action?opt=2&id=' + catId;
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
					url : "userOrder/delete.action",
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