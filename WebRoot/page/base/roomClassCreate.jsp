<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>商品类别管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li>
							<a href="roomClass/toLoadList.action">商品类别管理</a>
						</li>
						<li class="active">
							<a href="roomClass/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="roomClass/saveOrUpdate.action" method="post" enctype="multipart/form-data">
									  <input type="hidden" name="roomClass.id" id="id" value='<s:property value="roomClass.id"/>'/>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">类别名称：</label>
								          <div class="col-sm-8">
								              <input id="class_name"  name="roomClass.class_name"   type="text" value='<s:property value="roomClass.class_name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      
								       <div class="form-group">
						                    <label class="col-sm-3 control-label">图标：</label>
                                          <div class="col-sm-8">
                                              <input type="file" name="uploadfile"  class="form-control"/>
                                          </div>
						               </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">序号：</label>
								          <div class="col-sm-8">
								              <input id="class_sort" name="roomClass.class_sort"  type="number" value='<s:property value="roomClass.class_sort"/>' class="form-control" required="" aria-required="true">
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