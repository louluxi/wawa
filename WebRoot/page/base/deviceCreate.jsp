<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>设备管理</title>
<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="tabs-container">
					<ul class="nav nav-tabs">
						<li>
							<a href="device/toLoadList.action">设备管理</a>
						</li>
						<li class="active">
							<a href="device/getInfoById.action?opt=1">${title}</a>
						</li>
					</ul>
					<div class="tab-content">
							<div class="panel-body">
								<form class="form-horizontal m-t" id="commentForm" action="device/saveOrUpdate.action" method="post">
									  <input type="hidden" name="device.id" id="id" value='<s:property value="device.id"/>'/>				     
								      <div class="form-group">
                                          <label class="col-sm-3 control-label">设备类型：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="device.device_type">
                                                    <s:iterator value="deviceTypeList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="device.device_type == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
                                                    </s:iterator>
                                                </select>
                                          </div>
                                      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">设备编号：</label>
								          <div class="col-sm-8">
								              <input id="device_code"   name="device.device_code"   value='<s:property value="device.device_code"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">序列号：</label>
								          <div class="col-sm-8">
								              <input id="device_num" name="device.device_num"  type="text" value='<s:property value="device.device_num"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">批次号：</label>
								          <div class="col-sm-8">
								              <input id="batch_num" name="device.batch_num"  type="text" value='<s:property value="device.batch_num"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">设备名称：</label>
								          <div class="col-sm-8">
								              <input id="device_name" name="device.device_name"  type="text" value='<s:property value="device.device_name"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">IP：</label>
								          <div class="col-sm-8">
								              <input id="ip" name="device.ip"  type="text" value='<s:property value="device.ip"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">端口号：</label>
								          <div class="col-sm-8">
								              <input id="port" name="device.port"  type="text" value='<s:property value="device.port"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">通信类型：</label>
								          <div class="col-sm-8">
								          	  <input id="communication_type" name="device.communication_type"  type="text" value='<s:property value="device.communication_type"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">价格：</label>
								          <div class="col-sm-8">
								              <input id="price" name="device.price"  type="text" value='<s:property value="device.price"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">进货来源：</label>
								          <div class="col-sm-8">
								              <input id="origin" name="device.origin"  type="text" value='<s:property value="device.origin"/>' class="form-control" required="" aria-required="true">
								          </div>
								      </div>
								      <div class="form-group">
                                          <label class="col-sm-3 control-label">设备状态：</label>
                                          <div class="col-sm-8">
                                                <select class="form-control m-b" name="device.status">
                                                    <s:iterator value="deviceStatusList" var="dict">
                                                        <option value='<s:property value="#dict.dictId"/>' <s:if test="device.status == #dict.dictId">selected='selected'</s:if>><s:property value="#dict.dictName"/></option>
                                                    </s:iterator>
                                                </select>
                                          </div>
                                      </div>
								      <div class="form-group">
								          <label class="col-sm-3 control-label">备注：</label>
								          <div class="col-sm-8">
								               <input id="remark" name="device.remark"  type="text" value='<s:property value="device.remark"/>' class="form-control"  aria-required="true">
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