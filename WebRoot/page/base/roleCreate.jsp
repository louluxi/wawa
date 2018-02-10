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
<title>角色管理</title>
<script src="js/jquery.min.js?v=2.1.4"></script>
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link href="css/zTreeStyle.css" rel="stylesheet">
<script src="js/jquery.ztree.core.js"></script>
<script src="js/jquery.ztree.excheck.js"></script>
<style type="text/css">
.control-group {
	height: 30px;
	width: 100%;  
	margin: 5%;
}

label.control-label {
	position: relative;
	top: 8px;
}

.form-group {
	margin: 5%;
}
</style>
<script type="text/javascript">
var json = ${json};
$(document).ready(function() {
		var setting = {
			check: {
				chkboxType : { "Y" : "ps", "N" : "ps" },
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			 callback: {  
			        onCheck: onCheck  
			}  
		};
		$.fn.zTree.init($("#resource"), setting, json);
});
 function onCheck(e, treeId, treeNode){
   var zTreeO =  $.fn.zTree.getZTreeObj("resource").getCheckedNodes(true);  
   var resourceIds="";
   for (var i = 0; i < zTreeO.length; i++) {  
      if (zTreeO[i].id != null) {  
      	resourceIds += zTreeO[i].id + ",";
      }  
   };  
   $('#resourceIds').val(resourceIds);
}
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li><a href="role/toLoadList.action">角色列表</a></li>
						<li class="active"><a href="role/getInfoById.action?opt=1">${title}</a></li>
					</ul>

					<div class="ibox-content" style="padding: 25px 360px 35px 360px;">
						<form id="inputForm" class="form-inline" action="role/saveOrUpdate.action" method="post">
							<input name="role.id" type="hidden" value='<s:property value="role.id"/>' />
							<input name="role.resourceIds" id="resourceIds" type="hidden" />
							<div class="control-group">
								<label class="col-sm-3 col-sm-3 control-label">角色编码:</label>
								<div class="col-sm-8">
									<input id="role_id" name="role.role_id" class="form-control" value='<s:property value="role.role_id"/>' type="text" required="" aria-required="true">
								</div>
							</div>
							
							<div class="control-group">
								<label class="col-sm-3 control-label">角色名称:</label>
								<div class="col-sm-8">
									<input id="role_name" name="role.role_name" class="form-control" value='<s:property value="role.role_name"/>' type="text" required="" aria-required="true">
								</div>
							</div>
							
							<div class="control-group">
								<label class="col-sm-3 control-label">角色描述:</label>
								<div class="col-sm-8">
									<input id="role_desc" name="role.role_desc" class="form-control" value='<s:property value="role.role_desc"/>' type="text">
								</div>
							</div>
							<div class="control-group">
								<label class="col-sm-3 control-label">选择资源:</label>
								<div class="col-sm-8">
									<ul id="resource" class="ztree"></ul>
								</div>
							</div>
							<div class="form-group" style="width:330px;">
								<div class="col-sm-offset-3">
									<button class="btn btn-primary" type="submit" onclick="getCheck()">保 存</button>
									<button class="btn" onclick="history.go(-1)">返 回</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>