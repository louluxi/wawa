<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>发布消息</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
<link href="css/plugins/summernote/summernote.css" rel="stylesheet">
<link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
<script src="js/plugins/summernote/summernote.min.js"></script>
<script src="js/plugins/summernote/summernote-zh-CN.js"></script>
<script src="js/plugins/suggest/bootstrap-suggest.min.js"></script>
<script src="js/addMessage.js"></script>
<style type="text/css">
label {
	margin: 0; 
}

.ibox-cont {
	margin-bottom: 1%; 
}
</style>
</head>
<body class="gray-bg">
	<form id="messageForm" action="" enctype="multipart/form-data" method="post" onsubmit="return iframeCallback(this, pageAjaxDone)">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li class=""><a href="communicate/toLoadList.action">我的发布</a>
						</li>
						<li class="active"><a href="messageSend/getInfoById.action?opt=1">发布消息</a>
						</li>
					</ul>
					<div class="tab-content">
						<div class="panel-body">
							<div class="ibox-title">
								<button class="btn btn-success" type="button" onclick="sendMessage()">
									<span class="bold">发送</span>
								</button>
								<button class="btn btn-warning" type="button" onclick="saveMessage()">
									<span class="bold">存草稿</span>
								</button>
							</div>
							<div class="ibox-content">
								<div class="ibox-cont">
									<div style="float:left;width:5em;padding-top:0.3em;">
										<label>发布至：</label>
									</div>
									<input class="send_type" type="radio" name="messageSend.send_type" value="new" <s:if test="messageSend.send_type eq 'new'">checked="checked"</s:if>><span>新产品区</span>
									<input class="send_type" type="radio" name="messageSend.send_type" value="apply" <s:if test="messageSend.send_type eq 'apply'">checked="checked"</s:if>><span>应用案例区</span>
									<input class="send_type" type="radio" name="messageSend.send_type" value="purchase" <s:if test="messageSend.send_type eq 'purchase'">checked="checked"</s:if>><span>采购交流区</span>
									<input class="send_type" type="radio" name="messageSend.send_type" value="skill" <s:if test="messageSend.send_type eq 'skill'">checked="checked"</s:if>><span>徐工-供应商技术交流区</span>										
								</div>
								<div class="ibox-cont">
									<div style="float:left;width:5em;padding-top:0.3em;">
										<label>选择品类：</label>
									</div>
									<input type="hidden" id="category" name="messageSend.category" 
										value='<s:property value="messageSend.category"/>'/>
									<div class="col-sm-8 input-group">
								    	<input id="test_data1" type="text" value='<s:property value="messageSend.category"/>' 
								    		class="form-control" required="" aria-required="true">
								        <div class="input-group-btn">
		                                	<ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
		                                </div>
								    </div>
								</div>
								<div class="ibox-cont">
									<div style="float:left;width:5em;padding-top:0.3em;">
										<label>选择品牌：</label>
									</div>
									<input type="hidden" id="brand" name="messageSend.brand" 
										value='<s:property value="messageSend.brand"/>'/>
									<div class="col-sm-8 input-group">
								    	<input id="test_data2" type="text" value='<s:property value="messageSend.brand"/>' 
								    		class="form-control" required="" aria-required="true">
								        <div class="input-group-btn">
		                                	<ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
		                                </div>
								    </div>
								</div>
								<div class="ibox-cont">
									<div style="float:left;width:5em;padding-top:0.3em;">
										<label>选择机型：</label>
									</div>
									<input type="hidden" id="model" name="messageSend.model" 
										value='<s:property value="messageSend.model"/>'/>
									<div class="col-sm-8 input-group">
								    	<input id="test_data3" type="text" value='<s:property value="messageSend.model"/>' 
								    		class="form-control" required="" aria-required="true">
								        <div class="input-group-btn">
		                                	<ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
		                                </div>
								    </div>
								</div>
								<s:if test="userType == 1">
									<div class="ibox-cont">
										<div style="float:left;width:5em;padding-top:0.3em;">
											<label>是否置顶：</label>
										</div>
										<div class="col-sm-8 input-group">
											<input type="radio" name="messageSend.is_top" value="2" ><span>是</span>
											<input type="radio" name="messageSend.is_top" value="1" checked="checked"><span>否</span>
										</div>
									</div>
								</s:if>
								<div class="ibox-cont">
									<input type="hidden" name="messageSend.id" value="<s:property value="messageSend.id"/>"/>
									<input type="hidden" name="messageSend.content" id="content"/>
									<input type="hidden" name="messageSend.send_status" id="send_status" value='<s:property value="messageSend.send_status"/>'/>
									<div style="float:left;width:5em;padding-top:0.3em;">
										<label>标题：</label>
									</div>
									<div class="col-sm-8 input-group">
										<input class="form-control" name="messageSend.title" type="text" 
											value='<s:property value="messageSend.title"/>' required="" aria-required="true" />
								        <div class="input-group-btn"></div>
									</div>
								</div>
								<div class="summernote" id="summernote" name="messageSend.content" placeholder="请填写信息交流的详情" action="messageSend/uploadImg.action"><s:property value="messageSend.content" escape="false"/></div>
								<div class="ibox-title">
									<button class="btn btn-success " type="button" onclick="toImport()"><span class="bold">导入产品</span></button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>