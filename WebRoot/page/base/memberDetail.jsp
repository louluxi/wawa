<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员查看详情页</title>
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
                        <li>
                            <a href="member/toLoadList.action">会员管理管理列表</a>
                        </li>
                    </ul>
                    <div class="tab-content">		
		<div class="panel panel-primary">
		   <div class="panel-heading">
		      <h3 class="panel-title">会员个人信息</h3>
		   </div>
		  	 <div class="panel-body">
		      <table class="table table-hover table-bordered">
				 <tr class="text-center">
				    <td><label>用户代码：</label></td>
				    <td><div>${member.user_code}</div></td>
				    <td><label>名称：</label></td>
				    <td><div>${member.user_name}</div></td>
				 </tr>
				 <tr class="text-center">
				    <td><label>昵称：</label></td>
				    <td><div>${member.nick_name}</div></td>
				    <td><label>openid：</label></td>
				    <td><div>${member.openid}</div></td>
				 </tr class="text-center">
				 <tr class="text-center">
					  <td><label>unionid：</label></td>
					  <td><div>${member.unionid}</div></td>
					  <td><label>用户头像：</label></td>
					  <td><div>${member.user_icon}</div></td>
				 </tr>
				 <tr class="text-center">
					  <td><label>邮箱：</label></td>
					  <td><div>${member.user_email}</div></td>
					  <td><label>性别：</label></td>
					  <td><div>${member.gender}</div></td>
				 </tr>
				 <tr class="text-center">
					  <td><label>联系电话：</label></td>
					  <td><div>${member.user_tel}</div></td>
					  <td><label>用户地址：</label></td>
					  <td><div>${member.user_address}</div></td>
				 </tr>
				 <tr class="text-center">
					  <td><label>状态：</label></td>
					  <td><div>${member.status}</div></td>
					  <td><label>创建时间：</label></td>
					  <td><div>${member.create_time}</div></td>
				 </tr>
				</table>
		  	 </div>
		</div>
				<div class="nav nav-tabs">
					<ul class="nav nav-tabs" id="myTab">
						<li><a href="#zhanghu"   data-toggle="tab">账户</a></li>
						<li><a href="#dizhi"     data-toggle="tab">收货地址</a></li>
						<li><a href="#dingdang"  data-toggle="tab">订单列表</a></li>
						<li><a href="#chongzhi"  data-toggle="tab">充值流水</a></li>
						<li><a href="#usermerch"  data-toggle="tab">娃娃兑换流水</a></li>
					</ul>
				</div>
				<div class="tab-content">
					   <div class="jqGrid_wrapper tab-pane fade in active" id="zhanghu" >					  
							<table id="tt_account"></table>
							<div id="pl_account"></div>
						</div>
						
						<div class="jqGrid_wrapper tab-pane fade active"  id="dizhi" >
							<table id="tt_address"></table>
							<div id="pl_address"></div>
						</div>
						
						<div class="jqGrid_wrapper tab-pane fade active"  id="dingdang" >
							<table id="tt_order"></table>
							<div id="pl_order"></div>
						</div>
						<div class="jqGrid_wrapper tab-pane fade active"  id="chongzhi" >
							<table id="tt_record"></table>
							<div id="pl_record"></div>
						</div>
						<div class="jqGrid_wrapper tab-pane fade active"  id="usermerch" >
                            <table id="tt_userMerch"></table>
                            <div id="pl_userMerch"></div>
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
								$("#tt_account").jqGrid({
									url : 'userAccount/getAjaxData.action?user_id='+<s:property value="member.id"/>,
									datatype : "json",
									height : "auto",
									autowidth : true,
									multiselect : false,//复选框    
									shrinkToFit : true,
									rowNum : 20,
									rownumbers: true,
									rowList : [ 10, 20, 30 ],
									colNames : [ '序号', '账户类型',	'账户名称', '账户说明', '余额(个)'],
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
												name : 'account_type',
												index : 'account_type',
												editable : true,
												width : 50
											},
											{
												name : 'account_name',
												index : 'account_name',
												editable : true,
												width : 60
											},
											{
												name : 'account_desc',
												index : 'account_desc',
												editable : true,
												width : 60
											},
											{
												name : 'balance',
												index : 'balance',
												editable : true,
												width : 80,									
											}],
									pager : "#pl_account",
									viewrecords : true,
									caption : null,
									hidegrid : true,
									gridComplete : function() {
										var ids = $("#tt_account")
												.jqGrid(
														'getDataIDs');
										for (var i = 0; i < ids.length; i++) {									
											$("#tt_account").jqGrid(
															'setRowData',
															ids[i]);
										}
									}
								});
				                 /* 会员娃娃兑换记录 */
								 $("#tt_userMerch").jqGrid({
				                                    url : 'userMerch/getAjaxData.action?user_id='+<s:property value="member.id"/>,
				                                    datatype : "json",
				                                    height : "auto",
				                                    autowidth : true,
				                                    multiselect : false,//复选框    
				                                    shrinkToFit : true,
				                                    rowNum : 20,
				                                    rownumbers: true,
				                                    rowList : [ 10, 20, 30 ],
				                                    colNames : [ '序号', '房间id', '商品id','状态', '抓取流水id',
				                                                 '兑换id','配送id','抓取时间'
				                                                 
				                                                 ],
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
				                                                name : 'room_id',
				                                                index : 'room_id',
				                                                editable : true,
				                                                width : 50
				                                            },
				                                            {
				                                                name : 'merch_id',
				                                                index : 'merch_id',
				                                                editable : true,
				                                                width : 60
				                                            },
				                                            {
				                                                name : 'statusShow',
				                                                index : 'statusShow',
				                                                editable : true,
				                                                width : 60
				                                            },
				                                            {
				                                                name : 'grab_id',
				                                                index : 'grab_id',
				                                                editable : true,
				                                                width : 80,                                 
				                                            },
                                                            {
                                                                name : 'recharge_id',
                                                                index : 'recharge_id',
                                                                editable : true,
                                                                width : 60
                                                            },
                                                            {
                                                                name : 'order_id',
                                                                index : 'order_id',
                                                                editable : true,
                                                                width : 60
                                                            }, {
                                                                name : 'grab_time',
                                                                index : 'grab_time',
                                                                editable : true,
                                                                width : 90,
                                                                formatter : "datetime"
                                                            }],
				                                    pager : "#pl_userMerch",
				                                    viewrecords : true,
				                                    caption : null,
				                                    hidegrid : true,
				                                    gridComplete : function() {
				                                        var ids = $("#tt_userMerch")
				                                                .jqGrid(
				                                                        'getDataIDs');
				                                        for (var i = 0; i < ids.length; i++) {                                  
				                                            $("#tt_userMerch").jqGrid(
				                                                            'setRowData',
				                                                            ids[i]);
				                                        }
				                                    }
				                                });
				                 /* 收货地址 */
								$("#tt_address").jqGrid({
									url : 'userAddress/getAjaxData.action?user_id='+<s:property value="member.id"/>,
									datatype : "json",
									height : "auto",
									autowidth : true,
									multiselect : false,//复选框    
									shrinkToFit : true,
									rowNum : 20,
									rownumbers: true,
									rowList : [ 10, 20, 30 ],
									colNames : [ '序号', '省份', '城市', '县|区', '详细地址','收货人','联系电话','是否默认','创建时间'],
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
												name : 'province',
												index : 'province',
												editable : true,
												width : 50
											},
											{
												name : 'city',
												index : 'city',
												editable : true,
												width : 60
											},
											{
												name : 'area',
												index : 'area',
												editable : true,
												width : 60
											},
											{
												name : 'detail',
												index : 'detail',
												editable : true,
												width : 60
											},
											{
												name : 'receiver',
												index : 'receiver',
												editable : true,
												width : 60
											},
											{
												name : 'tel',
												index : 'tel',
												editable : true,
												width : 60
											},
											{
												name : 'is_default',
												index : 'is_default',
												editable : true,
												width : 60
											},
											{
												name : 'create_time',
												index : 'create_time',
												editable : true,
												width : 80,
											}],
									pager : "#pl_address",
									viewrecords : true,
									caption : null,
									hidegrid : true,
									gridComplete : function() {
										var ids = $("#tt_address")
												.jqGrid(
														'getDataIDs');
										for (var i = 0; i < ids.length; i++) {
											
											$("#tt_address").jqGrid(
															'setRowData',
															ids[i]);
										}
									}
								});
								/*用户订单  */
								
								$("#tt_order").jqGrid({
									url : 'userOrder/getAjaxData.action?user_id='+<s:property value="member.id"/>,
									datatype : "json",
									height : "auto",
									autowidth : true,
									multiselect : false,//复选框    
									shrinkToFit : true,
									rowNum : 20,
									rownumbers: true,
									rowList : [ 10, 20, 30 ],
									colNames : [ '序号', '订单类型',	'订单号', '订单状态', '创建时间' ],
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
												name : 'orderTypeShow',
												index : 'orderTypeShow',
												editable : true,
												width : 50
											},
											{
												name : 'order_code',
												index : 'order_code',
												editable : true,
												width : 60
											},
											{
												name : 'statusShow',
												index : 'statusShow',
												editable : true,
												width : 60
											},
											{
												name : 'create_time',
												index : 'create_time',
												editable : true,
												width : 80,
												formatter : "datetime"
											}],
									pager : "#pl_order",
									viewrecords : true,
									caption : null,
									hidegrid : true,
									gridComplete : function() {
										var ids = $("#tt_order")
												.jqGrid(
														'getDataIDs');
										for (var i = 0; i < ids.length; i++) {							
											$("#tt_order").jqGrid(
															'setRowData',
															ids[i]);
										}
									}
								});
								
								$("#tt_record").jqGrid({
									url : 'rechargeRecord/getAjaxData.action?user_id='+<s:property value="member.id"/>,
									datatype : "json",
									height : "auto",
									autowidth : true,
									multiselect : false,//复选框    
									shrinkToFit : true,
									rowNum : 20,
									rownumbers: true,
									rowList : [ 10, 20, 30 ],
									colNames : [ '序号', '渠道','订单金额(元)', '兑换娃娃币(个)','奖励娃娃币(个)','支付方式','支付金额(元)','类型', '充值时间' ],
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
												name : 'remark',
												index : 'remark',
												editable : true,
												width : 50
											},
											{
												name : 'order_money',
												index : 'order_money',
												editable : true,
												width : 60
											},
											{
												name : 'rechange_coin',
												index : 'rechange_coin',
												editable : true,
												width : 60
											},
											{
												name : 'reward_coin',
												index : 'reward_coin',
												editable : true,
												width : 60
											},
											{
												name : 'payStyleShow',
												index : 'payStyleShow',
												editable : true,
												width : 60
											},
											{
												name : 'pay_money',
												index : 'pay_money',
												editable : true,
												width : 60
											},
											{
												name : 'payTypeShow',
												index : 'payTypeShow',
												editable : true,
												width : 60
											},
											{
												name : 'recharge_time',
												index : 'recharge_time',
												editable : true,
												width : 80,
												formatter : "datetime"
											}],
									pager : "#pl_record",
									viewrecords : true,
									caption : null,
									hidegrid : true,
									gridComplete : function() {
										var ids = $("#tt_record")
												.jqGrid(
														'getDataIDs');
										for (var i = 0; i < ids.length; i++) {
											$("#tt_record").jqGrid(
															'setRowData',
															ids[i]);
										}
									}
								});
	
								// rownumbers添加序号列列头
								jQuery("#tt_account").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
								jQuery("#tt_address").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
								jQuery("#tt_order").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
								jQuery("#tt_record").jqGrid('setLabel', 'rn', '序号', {'text-align':'center','padding':'0'});
								// Add responsive to jqGrid
								$(window).bind('resize', function() {
									var width = $('.jqGrid_wrapper').width();
									$('#tt_account').setGridWidth(width);
									$('#tt_address').setGridWidth(width);
									$('#tt_order').setGridWidth(width);
									$('#tt_record').setGridWidth(width);
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