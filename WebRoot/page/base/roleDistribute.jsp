<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link href="css/treeTable.min.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
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

.vis {
	display: none; 
}
</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li><a href="role/toLoadList.action">角色列表</a></li>
						<li><a href="role/getInfoById.action?opt=1">角色添加</a></li>
						<li class="active"><a href="role/getInfoById.action?opt=4">角色分配</a></li>
					</ul>
					
					<div class="ibox-content" style="padding: 25px 360px 35px 360px;">
						<form id="inputForm" class="form-inline" action="" method="post">
							
							<div class="control-group">
								<label class="col-sm-3 control-label">角色名称:</label>
								<div class="col-sm-8">
									<input id="role_name" name="role.role_name" class="form-control" 
											value='<s:property value="role.role_name"/>' type="text">
								</div>
							</div>
							
							<div class="control-group">
								<label class="col-sm-3 control-label">角色名称:</label>
								<div class="col-sm-8">
									<input id="role_name" name="role.role_name" class="form-control" 
											value='<s:property value="role.role_name"/>' type="text">
								</div>
							</div>
							
							<div class="control-group" style="height:100%;">
								<label class="col-sm-3 control-label">选择菜单:</label>
								<div id="tree" style="display:inline-block;">
									
								</div>
							</div>
							
							<div class="form-group" style="width:330px;">
								<div class="col-sm-offset-3">
									<button class="btn btn-primary" type="button">保 存</button>
									<button class="btn" onclick="history.go(-1)">返 回</button>
								</div>
							</div>
						</form>
					</div>
					
					
				</div>
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript">
		$(document).ready(function() {
			var myData = {};
			myData.rows = [];
			var count = 0;
			var index = 0;
			$.ajax({
				type : "POST",
				async : false,
				cache : false,
				url : "menu/getAjaxData.action",
				dataType : "json",
				success : function(data) {
					for (var i = 0; i < data.rows.length; i++) {
						count++;
						for(var k = 0;k < data.rows.length;k++) {
							var resource_type_id = data.rows[k].resource_type_id;
							if(resource_type_id == count) {
								myData.rows[index] = data.rows[k];
								index++;
							} else {
								continue;
							}
						}
						
						var text = myData.rows[i].resource_name;
						if (myData.rows[i].level == 1) {
							myData.rows[i].resource_name = '<span arrow="true" onclick="retractable(this)" class="default_active_node default_open"></span>'
									+ '<span><input onclick="selectAll(this)" type="checkbox" value="' + text + '" />' + text + '</span>';
						} else if (myData.rows[i].level == 2) {
							myData.rows[i].resource_name = '<span class="prev_sp"><span class="default_node default_vertline"></span><span class="default_node default_vertline"></span></span>'
									+ '<span><input type="checkbox" value="' + text + '" />' + text + '</span>';
						}
						
						$("div#tree").append("<div id='" + count + "'class='tree_code'>" + myData.rows[i].resource_name + "</div>");
					}
				}
			})
		})
	
	function selectAll(obj) {
		var getClass = $(obj).parent().parent().attr("class");
		var id = $(obj).parent().parent().attr("id");
		var tree_obj = $("." + getClass);
		
		for(var i = id;i < tree_obj.length;i++) {
			var child = $(tree_obj[i]).children();
			if(child.hasClass("prev_sp")) {
				console.log($(obj).prop('checked'));
				if(!$(obj).prop('checked')) {//获取是否选中 并判断
					child.next().children().prop('checked', false); //修改设置为不选中状态
				} else {
					child.next().children().prop('checked', true);//修改设置为选中状态
				}
			} else {
				break;
			}
		}
	}	
	
	function retractable(obj) {
		var getClass = $(obj).parent().attr("class");
		var id = $(obj).parent().attr("id");
		var tree_obj = $("." + getClass);
		if ($(obj).hasClass("default_open")) {
			$(obj).removeClass("default_open").addClass("default_shut");
			
			for(var i = id;i < tree_obj.length;i++) {
				if($(tree_obj[i]).children().hasClass("prev_sp")) {
					$(tree_obj[i]).addClass("vis");
				} else {
					break;
				}
			}
			
			
		} else if ($(obj).hasClass("default_shut")) {
			$(obj).removeClass("default_shut").addClass("default_open");
			
			for(var i = id;i < tree_obj.length;i++) {
				console.log(tree_obj[i]);
				if($(tree_obj[i]).children().hasClass("prev_sp")) {
					$(tree_obj[i]).removeClass("vis");
				} else {
					break;
				}
			}
		}
	}
	</script>
</body>
</html>