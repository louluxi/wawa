<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>主页</title>
<style type="text/css">
a.right-sidebar-toggle {
	color: #fff !important; 
}
i.fa {
	color: #fff; 
}
.dropdown-toggle {
	cursor: default; 
}
div.font {
	text-align: center; 
}
div.font span {
	font-weight: 900; 
	font-size: medium; 
}
</style>
</head>
<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow:hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="nav-close">
			<i class="fa fa-times-circle"></i>
		</div>
		<div class="sidebar-collapse">
			<ul class="nav" id="side-menu">
				<li class="nav-header" style="padding: 15px 25px;">
					<div class="dropdown profile-element">
						<span><img alt="image" src="<%=basePath%>page/base/static/image/top-logo.png" /></span>
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
							<span class="clear">
								<span class="block m-t-xs">
									<%-- <strong class="font-bold">${sessionScope.user.user_name}</strong> --%>
								</span>
								<span class="text-muted text-xs block">${sessionScope.user.user_name}<!-- <b class="caret"></b> --></span>
							</span>
						</a>
					</div>
					<div class="logo-element">菜单</div>
				</li>
				<jsp:include page="../../sysadmin/getMenus.action"></jsp:include>
			</ul>
		</div>
		</nav>
		
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom:0;background-color:#273a4a;">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="#"><i class="fa fa-bars"></i> </a>
						<div><p class="fa"
							style="color:#fff;font-size:24px;position:relative;text-align:center;left:1em;top:0.3em;letter-spacing:2px;">
							这是标题</p>
						</div>
					</div>
					<ul class="nav navbar-top-links navbar-right">
                    	<li class="dropdown">
                      		<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            	<i class="fa fa-bell"></i>
                            	<span class="label label-primary">0</span>
                       		</a>
                       		<%-- <ul class="dropdown-menu dropdown-alerts">
                            	<li>
                                	<a href="mailbox.html">
                                    	<div>
                                       		<i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                        	<span class="pull-right text-muted small">4分钟前</span>
                                    	</div>
                               		</a>
                            	</li>
                            	<li class="divider"></li>
                            	<li>
                               		<a href="profile.html">
                                    	<div>
                                        	<i class="fa fa-qq fa-fw"></i> 3条新回复 
                                        	<span class="pull-right text-muted small">12分钟钱</span>
                                    	</div>
                                	</a>
                            	</li>
                            	<li class="divider"></li>
                            	<li>
                                	<div class="text-center link-block">
                                    	<a class="J_menuItem" href="notifications.html" data-index="89">
                                        	<strong>查看所有 </strong>
                                        	<i class="fa fa-angle-right"></i>
                                    	</a>
                                	</div>
                            	</li>
                        	</ul> --%>
                    	</li>
                    	<li class="hidden-xs">
                        	<a class="J_menuItem" href="<%=basePath%>page/data/personalData.jsp" style="color:#fff;" title="个人资料">
                        		<i class="fa fa-user"></i>个人资料
                        	</a>
                    	</li>
                    	<li>
                    		<label id="times" style="color:#fff;"></label>
                    	</li>
                	</ul>
				</nav>
			</div>
			<div class="row content-tabs">
				<button class="roll-nav roll-left J_tabLeft">
					<i class="fa fa-backward"></i>
				</button>
				<nav class="page-tabs J_menuTabs">
				<div class="page-tabs-content">
					<a href="javascript:;" class="active J_menuTab"	data-id="<%=basePath%>page/base/welcome.jsp">欢迎<i class="fa fa-times-circle"></i></a>
				</div>
				</nav>
				<button class="roll-nav roll-right J_tabRight">
					<i class="fa fa-forward"></i>
				</button>
				<div class="btn-group roll-nav roll-right">
					<button class="dropdown J_tabClose" data-toggle="dropdown">
						关闭操作<span class="caret"></span>

					</button>
					<ul role="menu" class="dropdown-menu dropdown-menu-right">
						<li class="J_tabShowActive"><a>定位当前选项卡</a></li>
						<li class="divider"></li>
						<li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
						<li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
					</ul>
				</div>
				<a href="<%=basePath%>page/base/login.jsp" class="roll-nav roll-right J_tabExit"><i
					class="fa fa fa-sign-out"></i> 退出</a>
			</div>
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=basePath%>page/base/welcome.jsp" frameborder="0" data-id="../page/base/welcome.jsp" seamless></iframe>
			</div>
			<div class="footer">
				<div class="font">
					<span>总访问量：</span>
					<span id="count"></span>
				</div>
				<div class="pull-right">
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		<!--右侧边栏开始-->
		<div id="right-sidebar">
			<div class="sidebar-container">

			</div>
		</div>
		<!--右侧边栏结束-->
		<!--mini聊天窗口开始-->
		<!--mini聊天窗口结束-->
	</div>

	<!-- 全局js -->
	<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
	
	<script type="text/javascript">
		function getTime() {
			var time = new Date();
			$("#times").text(time.toLocaleString());
		}
		
		$(document).ready(function() {
			setInterval("getTime()",1000);
			$.ajax({
				type : "POST",
				url : "sysadmin/setTotalCount.action",
				dataType : "text",
				success : function(result) {
					$('#count').html(result);
				}
			});
		})
		
		$(document).bind("click",function(){
			$('ul.dropdown-menu.dropdown-menu-right').parent().removeClass("open");
		})
	</script>
	
	<!--  <link rel="shortcut icon" href="favicon.ico">  -->
	<link href="<%=basePath%>css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=basePath%>css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
	<link href="<%=basePath%>css/animate.css" rel="stylesheet">
	<link href="<%=basePath%>css/style.css?v=4.1.0" rel="stylesheet">
	<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=basePath%>js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="<%=basePath%>js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="<%=basePath%>js/hplus.js?v=4.1.0"></script>
	<script type="text/javascript" src="../js/contabs.js"></script>

	<!-- 第三方插件 -->
	<script src="<%=basePath%>js/plugins/pace/pace.min.js"></script>
</body>

</html>
