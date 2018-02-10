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
<title>字典管理</title>
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li><a href="dictionary/toLoadList.action">字典列表</a></li>
						<li class="active"><a href="dictionary/getInfoById.action?opt=1">${title}</a></li>
					</ul>

					<div class="ibox-content" style="padding: 25px 388px 35px 388px;">
						<form role="form" class="form-horizontal m-t" action="dictionary/saveOrUpdate.action" method="POST">
								<input name="dictionary.id" type="hidden" value='<s:property value="dictionary.id"/>' />
								<div class="form-group">
									<label class="col-sm-3 control-label">字典代码:</label>
									<div class="col-sm-8">
										<input id="dictId" name="dictionary.dictId" class="form-control" 
											value='<s:property value="dictionary.dictId"/>' type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">字典内容:</label>
									<div class="col-sm-8">
										<input id="dictName" name="dictionary.dictName" class="form-control" 
											value='<s:property value="dictionary.dictName"/>' type="text">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">字典说明:</label>
									<div class="col-sm-8">
										<input id="descript" name="dictionary.descript" class="form-control" 
											value='<s:property value="dictionary.descript"/>' type="text">
									</div>
								</div>
							<div class="form-group" style="width:330px;">
								<div class="col-sm-offset-3">
									<button class="btn btn-primary" type="submit">保 存</button>
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