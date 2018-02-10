<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户登录</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="decorator" content="blank" />
<script type="text/javascript" src="page/base/static/js/jquery-3.1.1.js"></script>
<link href="page/base/static/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<style type="text/css">
body {
	background-image: url(page/base/static/image/bj.png);
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

input {
	border-radius: 4px;
}

.submit {
	width: 135px;
	height: 45px;
	font-size: 21px;
	color: #fff;
}

html, body, table {
	background-color: #f5f5f5;
	width: 100%;
	height: 100%;
	text-align: center;
}

.form-signin-heading {
	font-family: Helvetica, Georgia, Arial, sans-serif, 黑体;
	font-size: 36px;
	margin-bottom: 6px;
	color: #fff;
}

.form-signin {
	position: relative;
	text-align: left;
	width: 360px;
	padding: 20px 30px 20px;
	margin: 0 auto 20px;
	background-color: rgba(255,255,255,0.3);
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .input-block-level {
	font-size: 16px;
	width:  300px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px;
	*width: 283px;
	*padding-bottom: 0;
	_padding: 7px 7px 9px 7px;
}

.form-signin .btn.btn-large {
	font-size: 16px;
}

.header {
	height: 80px;
	padding-top: 20px;
}

.ipt {
	display: inline;
}

.buttons {
	margin-top: 10px;
}

span.glyphicon.glyphicon-user::before {
	margin: 1px;
}
</style>
</head>
<body>
	<div class="header"></div>
	<h1 class="form-signin-heading" style="color: white;">这是标题</h1>
		<div class="form-signin">
			<div class="context">
				<div style="height: 50px;">
					<span class="glyphicon glyphicon-user" style="font-size: 20px; color: #fff;top：1px；">
						<strong>用户登录</strong>
					</span>
				</div>
				<input type="text" id="username" name="username"
					style="background-color: #e6ebf5; color: #8d9094;"
					class="input-block-level" placeholder="请输入账号">
				<input type="password" id="password" name="password"
					style="background-color: #e6ebf5; color: #8d9094;"
					class="input-block-level" placeholder="请输入密码">
			</div>
			<div class="buttons">
				<div class="ipt">
				<input class="submit btn btn-large btn-primary"	style="background-color: #00adfe;border-color:transparent;"	id="denglu" type="button" onclick="login()" value="登 录" /></div>
				<div class="ipt" style="float: right;">
					<input class="submit btn btn-large btn-primary" style="background-color: #00fd77;border-color:transparent;" type="button" onclick="javascript:goRegister();" value="注 册" />
				</div>
			</div>
		</div>
	<div class="form-signin-heading" style="margin-top:13%;font-size:12px;">
		<p>南京软道软件科技有限公司 版权所有 苏ICP备10206335号 服务电话：0516-888888 邮箱：xxxx@xxx.com</p>
	</div>
	
	<script type="text/javascript">
		document.onkeydown=keyListener;
		function keyListener(e){
		    e = e ? e : event;// 兼容FF
		    if(e.keyCode == 13){
		        login();
		    }
		}
		function login(){
			$.ajax({
	             type: "POST",
	             url: "sysadmin/login.action",
	             data: {username:$('#username').val(),password:$('#password').val()},
	             dataType: "json",
	             success: function(result){
	             		if (result.res=="1"){
	    	                 window.location ="sysadmin/index.action";
						}else if (result.res=="2")
						{
						     alert("用户名或密码错误");
						}else
						{
						     alert("系统错误，请联系管理员");
						}
	             }
	         });
			/* $('#loginForm').form('submit',{
				url: 'sysadmin/login.action',
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(msg){
				    var result;
				    try{
				    	result= eval('('+msg+')');
				    }catch(e){
				    	
				    }
					if (result.res=="1"){
    	                 window.location ="sysadmin/index.action";
					}else if (result.res=="2")
					{
					     $.messager.alert("信息","用户名或密码错误");
					}else
					{
					     $.messager.alert("信息","系统错误，请联系管理员");
					}
				}
			}); */
		}
		function goRegister(){
			window.location.href="page/base/register.jsp";
		}
	</script>
</body>
</html>