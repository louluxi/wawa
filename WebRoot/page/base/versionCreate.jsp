<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>轮播图管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li>
							<a href="version/toLoadList.action">App版本管理</a>
						</li>
						<li class="active">
							<a href="version/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="version/saveOrUpdate.action" method="post" enctype="multipart/form-data">
									  <input type="hidden" name="version.id" id="id" value='<s:property value="version.id"/>'/>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">版本号：</label>
								          <div class="col-sm-8">
								              <input id="version_code"  name="version.version_code"   type="text" value='<s:property value="version.version_code"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">子版本号：</label>
								          <div class="col-sm-8">
								              <input id="version_child_code" name="version.version_child_code"  type="text" value='<s:property value="version.version_child_code"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">平台：</label>
								          <div class="col-sm-8">
								              <input id="platform" name="version.platform" type="text" value='<s:property value="version.platform"/>' class="form-control"  aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
                                          <label class="col-sm-3 control-label">下载地址：</label>
                                          <div class="col-sm-8">
                                              <input id="download_url" name="version.download_url" type="text" value='<s:property value="version.download_url"/>' class="form-control"  aria-required="true">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-3 control-label">git版本号：</label>
                                          <div class="col-sm-8">
                                              <input id="tag" name="version.tag" type="text" value='<s:property value="version.tag"/>' class="form-control"  aria-required="true">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-3 control-label">状态：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="version.status">
                                                    <s:iterator value="statusList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="version.status == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
                                                    </s:iterator>
                                                </select>
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