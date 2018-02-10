<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>app版本管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<div class="ibox-content">
					 <ul class="nav nav-tabs">
                        <li class="active"><a href="version/toLoadList.action">app版本管理列表</a></li>
                        <li><a href="version/getInfoById.action?opt=1">app版本新增</a></li>
                    </ul>
                     <!--查询-->
                     <div class="ibox-title">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label for="version_code" class="sr-only"> 版本号：</label>
                                <input type="text" placeholder="版本号" id="version_code" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label for="version_child_code" class="sr-only">子版本号：</label>
                                <input type="text" placeholder="子版本号" id="version_child_code" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label for="download_url" class="sr-only">下载地址：</label>
                                <input type="text" placeholder="下载地址" id="download_url" class="form-control">                         
                            </div>
                            <select class="form-control"  placeholder="状态"  id="status">
                                    <option value=''>app版本状态</option>
                                    <s:iterator value="statusList" var="dict">
                                            <option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
                                    </s:iterator>
                            </select> 
                            <button class="btn btn-primary" type="button" onclick="searchInfo()">
                                <i class="fa fa-search"></i>&nbsp;查询&nbsp;
                            </button>
                             
                        </form>
                    </div>
                    <a class="btn btn-primary" href="version/toLoadList.action">刷新</a>
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
												url : 'version/getAjaxData.action',
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
														'版本号', '子版本号', '平台',
														'下载地址', 'git版本号',
														'状态','创建时间','操作'],
												colModel : [ {
													name : 'id',
													index : 'id',
													editable : true,
													hidden : true,
													key : true,
													width : 80
												},{
													name : 'version_code',
													index : 'version_code',
													editable : true,
													width : 90
												}, {
													name : 'version_child_code',
													index : 'version_child_code',
													editable : true,
													width : 90
												}, {
													name : 'platform',
													index : 'platform',
													editable : true,
													width : 70
												}, {
													name : 'download_url',
													index : 'download_url',
													editable : true,
													width : 250
												}, {
													name : 'tag',
													index : 'tag',
													editable : true,
													width : 70
												},  {
                                                    name : 'status',
                                                    index : 'status',
                                                    editable : true,
                                                    width : 70,
                                                    formatter:function(cellvalue, options, rowObject){
                                                        return "<select onchange='checkField(this.value,"+options.rowId+")'><option value='0' " +(cellvalue==0?"selected='selected'":"") + ">待定</option><option value='1' "+(cellvalue==1?"selected='selected'":"") + ">上架</option><option value='2' "+(cellvalue==2?"selected='selected'":"") + ">下架</option></select>";  
                                                    }
                                                },{
													name : 'create_time',
													index : 'create_time',
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
			var version_code = $('#version_code').val();
			var version_child_code = $('#version_child_code').val();
			var download_url = $('#download_url').val();
			var status = $('#status').val();
			$("#tt").jqGrid('setGridParam', {
				url : "version/getAjaxData.action",
				postData : {
					'version_code' : version_code,
					'version_child_code' : version_child_code,
					'download_url' : download_url,
					'status' : status
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
       //更新
		function updateData(catId) {
			window.location.href = 'version/getInfoById.action?opt=2&id=' + catId;
			searchInfo();
		}
       //更改版本状态
		function checkField (val,rowid) {
	           $.ajax({
	              type : "POST",
	              url : "version/updatePutaway.action",
	              data : {
	                  stauts : val,
	                  id : rowid
	              },
	              dataType : "text",
	              success : function(result) {
	                  var result = eval('(' + result + ')');
	                  if (result.result) {
	                      swal("更新成功！", "您已经更新了此版本的状态。", "success");
	                  } else {
	                      swal("更新失败！", "请联系系统管理员。", "error");
	                  }
	                  searchInfo();
	              }
	          }); 
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
					url : "version/delete.action",
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