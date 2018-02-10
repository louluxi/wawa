<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<!-- jqgrid-->
<link href="css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/treeTable.min.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<!-- Sweet alert -->
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<style type="text/css">
input.btn.btn-outline.btn-primary {
	margin-left: 5px; 
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
						<li class="active"><a href="menu/toLoadList.action">菜单列表</a></li>
						<li><a href="menu/getInfoById.action?opt=1">菜单新增</a></li>
					</ul>

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
		<script src="js/menuManage.js"></script>
</body>
</html>