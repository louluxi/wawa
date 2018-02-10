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
						<li>
							<a href="merchType/toLoadList.action">商品类别管理</a>
						</li>
						<li class="active">
							<a href="merchType/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="merchType/saveOrUpdate.action" method="post"  enctype="multipart/form-data">
									  <input type="hidden" name="merchType.id" id="id" value='<s:property value="merchType.id"/>'/>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">类别编码：</label>
								          <div class="col-sm-8">
								              <input id="type_code"  name="merchType.type_code"   type="text" value='<s:property value="merchType.type_code"/>' class="form-control" required="" aria-required="true">
								          	  <span class="help-block m-b-none" id="alt"></span>
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">类别名称：</label>
								          <div class="col-sm-8">
								              <input id="type_name"   name="merchType.type_name"   value='<s:property value="merchType.type_name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">类别描述：</label>
								          <div class="col-sm-8">
								              <input id="type_desc" name="merchType.type_desc"  type="text" value='<s:property value="merchType.type_desc"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">父节点：</label>
								          <div class="col-sm-8">
								              <input id="parent" name="merchType.parent"  type="number" value='<s:property value="merchType.parent"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">等级：</label>
								          <div class="col-sm-8">
								              <input id="level" name="merchType.level"  type="number" value='<s:property value="merchType.level"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
                                            <label class="col-sm-3 control-label">商品缩略图：</label>
                                          <div class="col-sm-8">
                                              <input type="file" name="uploadfile"  class="form-control"/>
                                          </div>
                                      </div>
                                      
								      <div class="form-group">
								          <label class="col-sm-3 control-label">是否为父节点：</label>
								          <div class="col-sm-8">
								              <input id="is_root" name="merchType.is_root"  type="text" value='<s:property value="merchType.is_root"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <div class="col-sm-4 col-sm-offset-3">
								              <button class="btn btn-primary" type="submit">提交</button>
								              <button class="btn btn-warning" onclick="history.go(-1)">返 回</button>
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