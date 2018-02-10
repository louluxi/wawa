<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<script src="js/jquery.min.js?v=2.1.4"></script>
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link href="css/plugins/treeview/bootstrap-treeview.css"
	rel="stylesheet">
<script src="js/plugins/treeview/bootstrap-treeview.js"></script>
<style type="text/css">
.control-group {
	height: 30px;
	width: 100%;
	margin: 5%;
}

label.control-label {
	position: relative;
	top: 8px;
	text-align: right;
}

.form-group {
	margin: 5%;
}
textarea.form-control {
	margin-bottom: 5%; 
}
</style>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li><a href="user/toLoadList.action">用户列表</a></li>
						<li><a href="user/getInfoById.action?opt=1">用户添加</a></li>
						<li class="active"><a href="user/getInfoById.action?opt=4">用户审核</a></li>
					</ul>

					<div class="ibox-content" style="padding: 25px 360px 35px 360px;">
						<form role="form" class="form-inline" action="" method="POST">
							<div class="form-group" style="width: 400px;">
								<div class="control-group">
									<label class="col-sm-3 control-label">品类：</label>
									<div class="col-sm-8">
										<input type="hidden" id="catId" name="template.category_id"
											value='<s:property value="template.category_id"/>' /> <input
											id="catName" type="text"
											value='<s:property value="template.cat_name"/>'
											onclick="$('#treeview').show()" class="form-control"
											form-control="" aria-form-control="true">
										<div id="treeview"
											style="display: none; max-height: 500px; overflow: auto; overflow-x: hidden;"></div>
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">制造商名称:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="赛德斯" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">制造商类别:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="直供" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">制造商编码:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="12121" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">经营范围:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="南京" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">地址:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="小行路21号" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">用户名:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="xhep" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">密码:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="111111" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">合作企业:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="徐工" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label">合作时间:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="2017年3月12号" />
									</div>
								</div>

								<div class="control-group">
									<label class="col-sm-3 control-label lb">审核意见：</label>
									<div class="col-sm-8">
										<textarea class="form-control" rows="5" style="width: 500px"></textarea>
									</div>
								</div>
								<div class="control-group">
									<label class="col-sm-3 control-label lb">备注：</label>
									<div class="col-sm-8">
										<textarea class="form-control" rows="5" style="width: 500px"></textarea>
									</div>
								</div>
							</div>

							<div class="form-group" style="width: 350px;">
								<div class="col-sm-offset-3">
									<button class="btn btn-primary" type="submit">审 核</button>
									<button class="btn" onclick="history.go(-1)">撤 回</button>
								</div>
							</div>
						</form>
					</div>


				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var data1 = [];
		$(function() {
			$.ajax({
				type : "POST",
				url : "category/getCatTree.action",
				async : false,
				dataType : "json",
				success : function(result) {
					data1 = result;
				}
			});
			$("#catName").click(function() {
				var options = {
					bootstrap2 : false,
					showTags : true,
					levels : 1,
					ExpandDepth : 0,
					showCheckbox : false,
					checkedIcon : "glyphicon glyphicon-check",
					data : data1,
					onNodeSelected : function(event, data) {
						$("#catName").val(data.text);
						$("#catId").val(data.id);
						$("#treeview").hide();
					}
				};
				$('#treeview').treeview(options);
			});
		});
	</script>
</body>
</html>