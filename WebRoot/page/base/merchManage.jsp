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
                        <li class="active"><a href="user/toLoadList.action">商品列表</a></li>
                        <li><a href="merch/getInfoById.action?opt=1">商品新增</a></li>
                    </ul>
                    <!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="merch_name" class="sr-only">商品名称</label>
                                <input type="text" placeholder="商品名称" id="merch_name" class="form-control">  
                                <label for="batch_num" class="sr-only">批次号</label>
                                <input type="text" placeholder="批次号" id="batch_num" class="form-control">                         
                                <select class="form-control"  placeholder="商品状态"  id="status">
                                    <option value=''>请选择商品状态</option>
                                    <s:iterator value="merchStrutsList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="merch/toLoadList.action">刷新</a>
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
												url : 'merch/getAjaxData.action',
												datatype : "json",
												height : "auto",
												autowidth : true,
												multiselect : false,//复选框    
												shrinkToFit:false,  
												autoScroll: true, 
												rowNum : 20,
												rownumbers: true,
												rowList : [ 10, 20, 30 ],
												colNames : ['id',
														'批次号', '商品类别', '商品名称','商品图标','商品详情图片',
														 '商品价格', '商品数量', '兑换价', '进货来源', '商品状态', '采购人',
														'采购时间','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'batch_num',
													index : 'batch_num',
													editable : true,
													width : 100
												}, {
													name : 'mechTypeName',
													index : 'mechTypeName',
													editable : true,
													width : 80
												},{
													name : 'merch_name',
													index : 'merch_name',
													editable : true,
													width : 120
												},{
                                                    name : 'icon_path',
                                                    index : 'icon_path',
                                                    editable : true,
                                                    width : 120
                                                },{
                                                    name : 'merch_desc_img',
                                                    index : 'merch_desc_img',
                                                    editable : true,
                                                    width : 120
                                                },{
													name : 'price',
													index : 'price',
													editable : true,
													width : 80
												}, {
													name : 'merch_num',
													index : 'merch_num',
													editable : true,
													width : 80
												}, {
													name : 'exchange_coin',
													index : 'exchange_coin',
													editable : true,
													width : 60
												}, {
													name : 'origin',
													index : 'origin',
													editable : true,
													width : 100
												}, {
													name : 'statusShow',
													index : 'statusShow',
													editable : true,
													width : 70
												}, {
													name : 'purchaser',
													index : 'purchaser',
													editable : true,
													width : 90
												}, {
													name : 'purchase_time',
													index : 'purchase_time',
													editable : true,
													width : 150,
													formatter:"datetime", 
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
			var merch_name = $('#merch_name').val();
			var batch_num = $('#batch_num').val();
			var status = $('#status').val();
			$("#tt").jqGrid('setGridParam', {
				url : "merch/getAjaxData.action",
				postData : {
					'merch_name' : merch_name,
					'batch_num' : batch_num,
					'status' : status,
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function updateData(catId) {
			window.location.href = 'merch/getInfoById.action?opt=2&id=' + catId;
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
					url : "merch/delete.action",
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