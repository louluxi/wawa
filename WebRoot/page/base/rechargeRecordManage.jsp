<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>充值流水管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="rechargeChannel/toLoadList.action">充值流水列表</a></li>
                    </ul>
                    <!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="room_id" class="sr-only">房间id :</label>
                                <input type="text" placeholder="房间id" id="room_id" class="form-control">                 
                            </div>
                            <div class="form-group">
                                <label for="user_id" class="sr-only">用户id :</label>
                                <input type="text" placeholder="用户id" id="user_id" class="form-control">                 
                            </div>
                            <div class="form-group">
                                <label for="recharge_user_id" class="sr-only">充值人id:</label>
                                <input type="text" placeholder="充值人id" id="recharge_user_id" class="form-control">                 
                            </div>
                            <select class="form-control"  placeholder="充值套餐"  id="meal_id">
                                    <option value=''>充值套餐选择</option>
                                    <s:iterator value="mealList" var="dict">
                                            <option value='<s:property value="#dict.id"/>'><s:property value="#dict.name"/></option>
                                    </s:iterator>
                            </select>
                            <select class="form-control"  placeholder="支付方式"  id="pay_type">
                                    <option value=''>支付方式选择</option>
                                    <s:iterator value="payTypeList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            <select class="form-control"  placeholder="支付类型"  id="type">
                                    <option value=''>支付类型选择</option>
                                    <s:iterator value="payStyleList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="rechargeRecord/toLoadList.action">刷新</a>
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
												url : 'rechargeRecord/getAjaxData.action',
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
														'房间id', '用户id','用户姓名', '套餐id',
														'充值订单id', '充值人id','充值人姓名','订单金额',
														'兑换娃娃币','奖励娃娃币','支付方式','支付金额','类型',
														'充值时间','机构编码','操作'],
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
                                                    width : 100
                                                },{
													name : 'user_id',
													index : 'user_id',
													editable : true,
													width : 100
												}, {
													name : 'userName',
													index : 'userName',
													editable : true,
													width : 100
												}, {
													name : 'meal_id',
													index : 'meal_id',
													editable : true,
													width : 100
												}, {
													name : 'recharge_order_id',
													index : 'recharge_order_id',
													editable : true,
													width : 100
												}, {
													name : 'recharge_user_id',
													index : 'recharge_user_id',
													editable : true,
													width : 80
												}, {
                                                    name : 'rechargeuserName',
                                                    index : 'rechargeuserName',
                                                    editable : true,
                                                    width : 80
                                                }, {
                                                    name : 'order_money',
                                                    index : 'order_money',
                                                    editable : true,
                                                    width : 80
                                                }, {
                                                    name : 'exchange_coin',
                                                    index : 'exchange_coin',
                                                    editable : true,
                                                    width : 80
                                                }, {
                                                    name : 'reward_coin',
                                                    index : 'reward_coin',
                                                    editable : true,
                                                    width : 80
                                                }, {
                                                    name : 'payStyleShow',
                                                    index : 'payStyleShow',
                                                    editable : true,
                                                    width : 80
                                                }, {
                                                    name : 'pay_money',
                                                    index : 'pay_money',
                                                    editable : true,
                                                    width : 80
                                                }, {
                                                    name : 'payTypeShow',
                                                    index : 'payTypeShow',
                                                    editable : true,
                                                    width : 80
                                                },{
													name : 'recharge_time',
													index : 'recharge_time',
													editable : true,
													width : 150,
													formatter:"datetime",
												}, {
                                                    name : 'corp_code',
                                                    index : 'corp_code',
                                                    editable : true,
                                                    width : 90,
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
														var delet = "<input class='btn btn-outline btn-warning' type='button' value='删除' onclick='deleteData("
																+ cl + ")'/>";
														$("#tt")
																.jqGrid(
																		'setRowData',
																		ids[i],
																		{
																			opt : delet
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
			var user_id = $('#user_id').val();
			var recharge_user_id = $('#recharge_user_id').val();
			var pay_type = $('#pay_type').val();
			var type = $('#type').val();
			var meal_id = $('#meal_id').val();
			$("#tt").jqGrid('setGridParam', {
				url : "rechargeRecord/getAjaxData.action",
				postData : {
					'room_id' : room_id,
					'user_id' : user_id,
					'recharge_user_id' : recharge_user_id,
					'pay_type' : pay_type,
					'type' : type,
					'meal_id' : meal_id,
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

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
					url : "rechargeChannel/delete.action",
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