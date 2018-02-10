<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li class="active"><a href="user/toLoadList.action">用户列表</a></li>
						<li><a href="user/getInfoById.action?opt=1">用户新增</a></li>
					</ul>

					<div class="ibox-title">
						<form role="form" class="form-inline">
							<div class="form-group">
								<label for="user_code" class="sr-only">用户帐号</label>
								<input type="text" placeholder="用户帐号" id="user_code" class="form-control">
								<label for="business_name" class="sr-only">企业名称</label>
								<input type="text" placeholder="企业名称" id="business_name" class="form-control">
								<label for="user_code" class="sr-only">姓名</label>
								<input type="text" placeholder="姓名" id="user_name" class="form-control">
								<select class="form-control"  placeholder="用户类型"  id="user_type">
									<option value=''>用户类型</option>
				          			<s:iterator value="userTypeList" var="dict">
	                                      	<option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
				          			</s:iterator>
                                </select>
                                <select class="form-control"  placeholder="用户类型"  id="status">
                                	<option value=''>用户类型</option>
				          			<s:iterator value="genderList" var="dict">
	                                      	<option value='<s:property value="#dict.dictId"/>'><s:property value="#dict.dictName"/></option>
				          			</s:iterator>
                                </select>
							</div>
							<button class="btn btn-primary" type="button" onclick="searchInfo()">
								<i class="fa fa-search"></i>&nbsp;查询
							</button>
							<a class="btn btn-primary" href="user/toLoadList.action">刷新</a>
						</form>
					</div>
					<div class="ibox-title">
                          <button class="btn btn-warning" type="button" onclick="replace()">
                                &nbsp;替换所有用户二维码
                            </button>
                       </form>
                    </div>
					<div class="ibox-title">
						<button class="btn btn-success " type="button" onclick="toImport()"><span class="bold">导入</span>	</button>
						<button class="btn btn-warning " type="button" onclick="exportData()"><span class="bold">导出</span></button>
					</div>
					<div class="ibox-content">
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
												url : 'user/getAjaxData.action',
												datatype : "json",
												height : "auto",
												autowidth : true,
												multiselect : false,//复选框    
												shrinkToFit:false,  
												autoScroll: true, 
												rowNum : 20,
												rownumbers: true,
												rowList : [ 10, 20, 30 ],
												colNames : [ '序号', '用户账号',
														'企业名称', '企业邮箱', '部门',
														'职务', '姓名','微信用户名', '性别','年龄', '联系电话', '联系人邮箱', '用户类型', '状态','二维码图片','邀请码','更新时间',
														'操作' ],
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
													name : 'business_name',
													index : 'business_name',
													editable : true,
													width : 200
												},{
													name : 'business_email',
													index : 'business_email',
													editable : true,
													width : 120
												}, {
													name : 'department',
													index : 'department',
													editable : true,
													width : 120
												},{
													name : 'post',
													index : 'post',
													editable : true,
													width : 80
												}, {
													name : 'user_name',
													index : 'user_name',
													editable : true,
													width : 80
												},  {
                                                    name : 'nick_name',
                                                    index : 'nick_name',
                                                    editable : true,
                                                    width : 80
                                                }, {
													name : 'genderShow',
													index : 'genderShow',
													editable : true,
													width : 60
												}, {
                                                    name : 'user_age',
                                                    index : 'user_age',
                                                    editable : true,
                                                    width : 60
                                                },{
													name : 'user_tel',
													index : 'user_tel',
													editable : true,
													width : 90
												}, {
													name : 'user_email',
													index : 'user_email',
													editable : true,
													width : 70
												}, {
													name : 'typeShow',
													index : 'typeShow',
													editable : true,
													width : 90
												}, {
													name : 'statusShow',
													index : 'statusShow',
													editable : true,
													width : 90
												}, {
                                                    name : 'shareIcon',
                                                    index : 'shareIcon',
                                                    editable : true,
                                                    width : 90
                                                }, {
                                                    name : 'invitate_code',
                                                    index : 'invitate_code',
                                                    editable : true,
                                                    width : 90
                                                }, {
													name : 'update_timestamp',
													index : 'update_timestamp',
													editable : true,
													width : 90,
													formatter : "datetime"
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
			var user_code = $('#user_code').val();
			var business_name = $('#business_name').val();
			var user_name = $('#user_name').val();
			var user_type = $('#user_type').val();
			var status = $('#status').val();
			$("#tt").jqGrid('setGridParam', {
				url : "user/getAjaxData.action",
				postData : {
					'user_code' : user_code,
					'business_name' : business_name,
					'user_name' : user_name,
					'user_type' : user_type,
					'status' : status
				}, // 发送数据
				page : 1
			}).trigger("reloadGrid"); // 重新载入

		}
		
		function toImport(){
			 //iframe层
		    layer.open({
		        type: 2,
		        title: '导入用户',
		        shadeClose: true,
		        shade: 0.8,
		        area: ['380px', '230px'],
		        content: 'user/toImport.action' //iframe的url
		    }); 
		}
		function exportData(){
			window.location.href="user/exportData.action";
		}
		
		function updateData(catId) {
			window.location.href = 'user/getInfoById.action?opt=2&id=' + catId;
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
					url : "user/delete.action",
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
		function replace() {
            swal({
                title : "您确定要替换所有用户的二维码信息吗?",
                text : "替换后将无法恢复，请谨慎操作!替换需要时间，请耐心等候，请勿重复操作！",
                type : "warning",
                showCancelButton : true,
                confirmButtonColor : "#DD6B55",
                confirmButtonText : "替换",
                cancelButtonText : "取消",
                closeOnConfirm : false
            }, function() {
                $.ajax({
                    type : "POST",
                    url : "user/replaceAllIcon.action",
                    dataType : "text",
                    success : function(result) {
                        var result = eval('(' + result + ')');
                        if (result.result) {
                            swal("替换成功！", "您已经替换所有用户的二维码。", "success");
                        } else {
                            swal("替换失败！", "请联系系统管理员。", "error");
                        }
                        searchInfo();
                    }
                });
            });
        }
	</script>
</body>
</html>