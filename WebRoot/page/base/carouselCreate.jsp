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
							<a href="carousel/toLoadList.action">轮播图管理</a>
						</li>
						<li class="active">
							<a href="carousel/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="carousel/saveOrUpdate.action" method="post" enctype="multipart/form-data">
									  <input type="hidden" name="carousel.id" id="id" value='<s:property value="carousel.id"/>'/>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">标题：</label>
								          <div class="col-sm-8">
								              <input id="title"  name="carousel.title"   type="text" value='<s:property value="carousel.title"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">轮播图：</label>
								          <div class="col-sm-8">
								          <img alt="" id="img_carouse" style="width: 355px;height: 115px;" src='<s:property value="carousel.icon_path"/>'>
								              <%-- <input id="icon_path"   name="carousel.icon_path"   value='<s:property value="carousel.icon_path"/>' class="form-control" required="" aria-required="true"> --%>
								          </div>
								      </div>
								       <div class="form-group">
						                    <label class="col-sm-3 control-label">轮播图图片选择：</label>
                                          <div class="col-sm-8">
                                              <input type="file" name="uploadfile"  class="form-control" onchange="getFullPath(this)"/>
                                          </div>
						               </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">顺序号：</label>
								          <div class="col-sm-8">
								              <input id="order_num" name="carousel.order_num"  type="number" value='<s:property value="carousel.order_num"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">跳转地址：</label>
								          <div class="col-sm-8">
								              <input id="jump_path" name="carousel.jump_path" type="text" value='<s:property value="carousel.jump_path"/>' class="form-control"  aria-required="true">
								          </div>
								      </div>
								       <div class="form-group">
                                          <label class="col-sm-3 control-label">轮播图状态：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="carousel.state">
                                                    <s:iterator value="carouserlStateList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="carousel.state == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
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