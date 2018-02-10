<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    <title>首页</title>
<!-- 	<link rel="shortcut icon" href="favicon.ico">  -->
	<link href="<%=basePath %>css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath %>css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath %>css/animate.css" rel="stylesheet">
    <link href="<%=basePath %>css/style.css?v=4.1.0" rel="stylesheet">

  </head>
  
 <body class="gray-bg top-navigation">

    <div id="wrapper">
        <div id="page-wrapper" class="gray-bg">
            <div class="wrapper wrapper-content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-5">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <span class="label label-success pull-right">总</span>
                                    <h5>浏览量</h5>
                                </div>
                                <div class="ibox-content">
                                    <h1 class="no-margins" id="count"></h1>
                                    <div class="stat-percent font-bold text-success"><i class="fa fa-bolt"></i>
                                    </div>
                                    <small>总计浏览量</small>
                                </div>
                            </div>
                        </div>
                </div>

            </div>
        </div>
    </div>



    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>


    <!-- Flot -->
    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>

    <!-- ChartJS-->
    <script src="js/plugins/chartJs/Chart.min.js"></script>

    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>

    <!-- Peity demo -->
    <script src="js/demo/peity-demo.js"></script>


    <script>
        $(document).ready(function () {
				$.ajax({
					type : "POST",
					url : "sysadmin/setTotalCount.action",
					dataType : "text",
					success : function(result) {
						$('#count').html(result);
					}
				});
        });

		$(document).bind("click",function(){
			$('ul.dropdown-menu.dropdown-menu-right', window.parent.document).parent().removeClass("open");
		})
    </script>

</body>
</html>
