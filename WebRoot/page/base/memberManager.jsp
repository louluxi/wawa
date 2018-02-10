<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>会员管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="member/toLoadList.action">会员列表</a></li>
                    </ul>
					<!--查询-->
					 <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="user_code" class="sr-only">用户ID</label>
                                <input type="text" placeholder="用户ID" id="user_code" class="form-control">
                                <label for="nick_name" class="sr-only">用户昵称</label>
                                <input type="text" placeholder="用户昵称" id="nick_name" class="form-control">     
                                <label for="register_time" class="sr-only">注册时间</label>
                                <input type="text" placeholder="注册时间" id="register_time" class="form-control">                                                      
                                <select class="form-control"  placeholder="用户状态"  id="status">
                                    <option value=''>请选择用户状态</option>
                                    <s:iterator value="strutsList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            </div>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询
                            </button>
                        </form>
                    </div>
                    <a class="btn btn-primary" href="member/toLoadList.action">刷新</a>
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
												url : 'member/getAjaxData.action',
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
														'用户ID', '用户昵称', '用户性别',
														'电话号码', '国家', '用户状态', '注册时间', '机构编码','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 100
												},{
													name : 'user_code',
													index : 'user_code',
													editable : true,
													width : 100
												},{
													name : 'nick_name',
													index : 'nick_name',
													editable : true,
													width : 110
												},{
													name : 'genderShow',
													index : 'genderShow',
													editable : true,
													width : 110
												},{
													name : 'user_tel',
													index : 'user_tel',
													editable : true,
													width : 110
												},{
													name : 'user_nationality',
													index : 'user_nationality',
													editable : true,
													width : 120
												}, {
													name : 'strutsShow',
													index : 'strutsShow',
													editable : true,	
													width : 120
												}, {
													name : 'register_time',
													index : 'register_time',
													editable : true,
													width : 120
												}, {
													name : 'corp_code',
													index : 'corp_code',
													editable : true,
													width : 120
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
														var update = "<input class='btn btn-outline btn-success' type='button' value='会员查看' onclick='lookData("
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
			var register_time = $('#register_time').val();
			var status = $('#status').val();
			$("#tt").jqGrid('setGridParam', {
				url : "member/getAjaxData.action",
				postData : {
					'user_code' : user_code,
					'nick_name' : nick_name,
					'register_time' :register_time,
					'status' : status,
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function lookData(catId) {
			window.location.href = 'member/getInfoById.action?opt=2&id=' + catId;
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
					url : "member/delete.action",
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