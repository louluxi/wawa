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
                        <li class="active"><a href="feedBack/toLoadList.action">反馈列表</a></li>
                    </ul>
                     <!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="q_code" class="sr-only">反馈人编码：</label>
                                <input type="text" placeholder="反馈人编码" id="q_code" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label for="q_name" class="sr-only">反馈人名称：</label>
                                <input type="text" placeholder="反馈人名称" id="q_name" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label for="r_code" class="sr-only">处理人编码：</label>
                                <input type="text" placeholder="处理人编码" id="r_code" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label for="r_name" class="sr-only">处理人名称：</label>
                                <input type="text" placeholder="处理人名称" id="r_name" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label for="title" class="sr-only">标题查询：</label>
                                <input type="text" placeholder="标题查询" id="title" class="form-control">                         
                            </div>
                            <select class="form-control"  placeholder="状态"  id="r_staus">
                                    <option value=''>反馈意见处理状态</option>
                                    <s:iterator value="feeBackStatusList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select>
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询&nbsp;
                            </button>
                             
                        </form>
                    </div>
                    <a class="btn btn-primary" href="feedBack/toLoadList.action">刷新</a>
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
												url : 'feedBack/getAjaxData.action',
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
														'反馈人编码', '反馈人名称', '反馈标题',
														'反馈内容', '反馈时间','处理人编码',
														'处理人名称','回复内容','备注',
														'处理状态','处理时间','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'q_code',
													index : 'q_code',
													editable : true,
													width : 90
												}, {
													name : 'q_name',
													index : 'q_name',
													editable : true,
													width : 550
												}, {
													name : 'title',
													index : 'title',
													editable : true,
													width : 70
												}, {
													name : 'q_content',
													index : 'q_content',
													editable : true,
													width : 250
												}, {
													name : 'q_date',
													index : 'q_date',
													editable : true,
													width : 150,
                                                    formatter:"datetime",
												}, {
													name : 'r_code',
													index : 'r_code',
													editable : true,
												}, {
                                                    name : 'r_name',
                                                    index : 'r_name',
                                                    editable : true,
                                                    width : 150,
                                                }, {
                                                    name : 'r_content',
                                                    index : 'r_content',
                                                    editable : true,
                                                    width : 150,
                                                },{
                                                    name : 'remark',
                                                    index : 'remark',
                                                    editable : true,
                                                    width : 150,
                                                },{
                                                    name : 'stausShow',
                                                    index : 'stausShow',
                                                    editable : true,
                                                    width : 150,
                                                },{
                                                    name : 'r_date',
                                                    index : 'r_date',
                                                    width : 150,
                                                    formatter:"datetime",
                                                },{
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
																			opt :  delet
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
			var title = $('#title').val();
			var r_staus = $('#r_staus').val();
			var q_code = $('#q_code').val();
			var q_name = $('#q_name').val();
			var r_code = $('#r_code').val();
			var r_name = $('#r_name').val();
			$("#tt").jqGrid('setGridParam', {
				url : "feedBack/getAjaxData.action",
				postData : {
					'title' : title,
					'r_staus' : r_staus,
					'q_code' : q_code,
					'q_name' : q_name,
					'r_code' : r_code,
					'r_name' : r_name,
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
					url : "feedBack/delete.action",
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